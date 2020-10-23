package Logica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Celda extends JButton {

	int valor;
	int h, v;
	boolean bien;

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public Celda() {
		super("");
		this.setBackground(Color.white);
		valor = 0;
	}

	public int getValor(){
		return valor;
	}
	public void click() {
		setValor(valor+1);
	}
	public void setValor(int i){
		if(!bien) {
			valor = i;
			if(valor >= 10)
				valor = 1;
			if(valor <=0) {
				valor = 9;
			}
			estaRegular();
			this.setIcon(new ImageIcon("Imagenes\\"+valor+".png"));
		}
	}
	public void estaMal() {
		if(!bien)
			this.setBackground(Color.red);
	}

	public void estaRegular() {
		if(!bien)
			this.setBackground(Color.white);
	}

	public void estaBien() {
		bien = true;
		this.setBackground(Color.lightGray);		
	}

	public void antiClick() {
		setValor(valor-1);
	}

}
