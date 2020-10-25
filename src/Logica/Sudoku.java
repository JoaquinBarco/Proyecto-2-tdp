package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {
	
	private Celda[][] celdas;
	
	public Sudoku(Celda[][] c) throws ArchivoMalException {
		celdas = c;	
		estadosIniciales();
	}
	
	private void estadosIniciales() throws ArchivoMalException {
		try {
			String[] cadena;
			FileReader f = new FileReader("Sudoku.txt");
			BufferedReader b = new BufferedReader(f);
			for(int i = 0;i<9;i++) {
				cadena = b.readLine().split("\\s+");			
				for(int j = 0;j<9;j++) {
					if(Math.floor(Math.random() * 101) < 70) {
						celdas[i][j].setValor(Integer.parseInt(cadena[j]));
						celdas[i][j].estaBien();
					}
				}
			}
			b.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArchivoMalException("El archivo no tiene todas las columnas/filas completas");
		} catch (IOException e) {
			throw new ArchivoMalException("El archivo tiene errores");
		} catch (NumberFormatException e) {
			throw new ArchivoMalException("El archivo tiene caracteres no validos");
		}
	}
	
	public boolean checkFila(int v) {
		boolean[] check = new boolean[9];
		for(int i = 0;i<9;i++) {
			check[i] = false;
		}
		boolean ret = true;
		for(int i = 0;i<9 && ret;i++) {
			if(celdas[v][i].getValor() == 0) {
				ret = false;
			} else {
				ret = !check[celdas[v][i].getValor()-1];
				if(ret) 
					check[celdas[v][i].getValor()-1] = ret;
			}
		}
		for(int i = 0;i<check.length;i++) {
			ret = ret && check[i];
		}
		return ret;
	}
	
	public boolean checkColumna(int h) {
		boolean[] check = new boolean[9];
		for(int i = 0;i<9;i++) {
			check[i] = false;
		}
		boolean ret = true;
		for(int i = 0;i<9 && ret;i++) {
			if(celdas[i][h].getValor() == 0) {
				ret = false;
			} else {
				ret = !check[celdas[i][h].getValor()-1];
				if(ret) {
					check[celdas[i][h].getValor()-1] = ret;
				}
			}
		}

		for(int i = 0;i<check.length;i++) {
			ret = ret && check[i];
		}
		return ret;
	}	
	
	public boolean checkCuadrado(int x, int y) {
		int maxX = x;
		int maxY = y;
		boolean ret = true;
		boolean[] check = new boolean[9];
		for(int i = 0;i<9;i++) {
			check[i] = false;
		}
		for(int i = maxX-3;i<maxX && ret;i++) {
			for(int j= maxY-3;j<maxY && ret;j++) {
				if(celdas[i][j].getValor() == 0) {
					ret = false;
				} else {
					ret = !check[celdas[i][j].getValor()-1];
					if(ret) {
						check[celdas[i][j].getValor()-1] = ret;
					}
				}								
			}
		}
		for(int i = 0;i<check.length && ret;i++) {
			ret = ret && check[i];
		}
		return ret;
	}
	
	public void preCheckCelda(Celda c) {
		if(cantFila(c,null)-1==1)
			filaGris(c);
		if(cantColumna(c,null)-1==1)
			columnaGris(c);
		if(cantCuadrado(c,null)-1==1) {
			cuadradoGris(c);
		}
	}
	
	public void checkCelda(Celda c) {
		if(cantFila(c,null) > 1)
			filaRoja(c);
		if(cantColumna(c,null) > 1)
			columnaRoja(c);
		if(cantCuadrado(c,null) > 1) {
			cuadradoRoja(c);
		}
	}
	
	public void filaRoja(Celda c) {
		c.estaMal();
		for(int i = 0;i<9;i++) {
			if(celdas[c.getV()][i].getValor()==c.getValor()) {
				celdas[c.getV()][i].estaMal();
			}
		}
	}
	
	public void filaGris(Celda c) {
		boolean b = true;
		for(int i = 0;i<9 && b;i++) {
			if(celdas[c.getV()][i] != c && celdas[c.getV()][i].getValor() == c.getValor()) {
				if(cantColumna(celdas[c.getV()][i],c) <= 1 && cantCuadrado(celdas[c.getV()][i],c) <= 1)
					celdas[c.getV()][i].estaRegular();
				b = false;
			}
		}
	}
	
	public void columnaRoja(Celda c) {
		for(int i = 0;i<9;i++) {
			if(celdas[i][c.getH()].getValor()==c.getValor()) {
				celdas[i][c.getH()].estaMal();
			}
		}
	}
	
	public void columnaGris(Celda c) {
		boolean b = true;
		for(int i = 0;i<9 && b;i++) {
			if(celdas[i][c.getH()] != c && celdas[i][c.getH()].getValor()==c.getValor()) {
				if(cantFila(celdas[i][c.getH()],c) <= 1 && cantCuadrado(celdas[i][c.getH()],c) <= 1)
					celdas[i][c.getH()].estaRegular();
				b = false;
			}
		}
		
	}
	
	public Pair cuadradoMax(Celda c) {
		Pair ret = new Pair();
		int x = c.getH();
		int y = c.getV();
		int maxX;
		int maxY;
		if(x < 3) {
			if( y < 3) {
				maxX = 3;
				maxY=3;
			} else if (y < 6){
				maxX = 3;
				maxY=6;
			} else {
				maxX = 3;
				maxY=9;
			}
		} else if (x < 6) {
			if( y < 3) {
				maxX = 6;
				maxY=3;
			} else if (y < 6){
				maxX = 6;
				maxY=6;
			} else {
				maxX = 6;
				maxY=9;
			}		
		} else {
			if( y < 3) {
				maxX = 9;
				maxY=3;
			} else if (y < 6){
				maxX = 9;
				maxY=6;
			} else {
				maxX = 9;
				maxY=9;
			}		
		}
		ret.setA(maxX);
		ret.setB(maxY);
		return ret;
	}

	public void cuadradoRoja(Celda c) {
		Pair max = cuadradoMax(c);
		int maxX = max.getA();
		int maxY = max.getB();
		for(int i = maxY-3;i<maxY;i++) {
			for(int j = maxX-3;j<maxX;j++) {
				if(celdas[i][j].getValor() == c.getValor())
					celdas[i][j].estaMal();
			}
		}
	}
	
	public void cuadradoGris(Celda c) {
		Pair max = cuadradoMax(c);
		int maxX = max.getA();
		int maxY = max.getB();
		boolean b = true;
		for(int i = maxY-3;i<maxY && b;i++) {
			for(int j = maxX-3;j<maxX;j++) {
				if(celdas[i][j]!=c && celdas[i][j].getValor() == c.getValor()) {
					if(cantFila(celdas[i][j],c) <= 1 && cantColumna(celdas[i][j],c) <= 1)
						celdas[i][j].estaRegular();
					b = false;
				}
			}
		}
	}
	
	public int cantFila(Celda c, Celda no) {
		int cont= 0;
		for(int i = 0;i<9;i++) {
			if(celdas[c.getV()][i] != no) {
				if(celdas[c.getV()][i].getValor()==c.getValor()) {
					if(celdas[c.getV()][i] == c) {
						cont++;
					}else 
						cont++;
				}
			}
		}
		return cont;
	}
	
	public int cantColumna(Celda c, Celda no) {
		int cont= 0;
		for(int i = 0;i<9;i++) {
			if(celdas[i][c.getH()] != no) {
				if(celdas[i][c.getH()].getValor()==c.getValor()) {
					if(celdas[i][c.getH()] == c) {
						cont++;
					} else {
						cont++;
					}
				}
			}
		}
		return cont;
	}
	
	public int cantCuadrado(Celda c, Celda no) {
		Pair max = cuadradoMax(c);
		int maxX = max.getA();
		int maxY = max.getB();
		int cont = 0;
		for(int i = maxY-3;i<maxY;i++) {
			for(int j = maxX-3;j<maxX;j++) {
				if(celdas[i][j] != no) {
					if(celdas[i][j].getValor()==c.getValor()) {
						if(celdas[i][j] == c) {
							cont++;
						}else 
							cont++;
					}
				}
			}
		}
		return cont;
	}
	
	public boolean checkCompleto() {
		boolean ret = true;
		for(int i = 0;i<9;i++) {
			ret = ret && checkColumna(i) && checkFila(i);
			if(i!=0 && i % 3 == 0 || i == 8) {
				if(i == 8)
					i=9;
				for(int j = 3;j<=9;j=j+3) {
					ret = ret && checkCuadrado(i, j);
				}
			}
		}
		return ret;
	}	
}
