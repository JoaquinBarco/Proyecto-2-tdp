package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.ArchivoMalException;
import Logica.Celda;
import Logica.Sudoku;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	private boolean h, a, c;
	private int segundos, minutos;
	private JPanel contentPane;
	private Celda[][] celda;
	private Sudoku s;
	private JFrame ventana = this;
	private JLabel lblNewLabel_2_1_1,lblNewLabel_2, lblNewLabel_2_1, lblNewLabel_4;


	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		h = false; a = false; c = false;


		class teclasListener implements KeyListener{

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_H) {
					h = true;
				} else if(h && arg0.getKeyCode() == KeyEvent.VK_A) {
					a = true;
				} else if(h && a && arg0.getKeyCode() == KeyEvent.VK_C) {
					c = true;
				}else if(h && a && c &&  arg0.getKeyCode() == KeyEvent.VK_K) {
					try {
						java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://youtu.be/PC1NyOIm03A?t=73"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					h = false;
					a = false;
					c = false;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
			}

		}

		class BotonCeldas implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				Celda aux = (Celda) e.getSource();
				if(aux.getValor()>0)	
					s.preCheckCelda(aux);
				if(e.getButton() == MouseEvent.BUTTON1) {
					aux.click();
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					aux.antiClick();
				}
				s.checkCelda(aux);
				if(s.checkCompleto()){
					timerTask.cancel();
					JOptionPane.showMessageDialog(null, "Ganaste fiera");
					ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		}

		celda = new Celda[9][9];
		contentPane.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("SUDOKU");
		lblNewLabel_3.setBounds(339, 61, 80, 36);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_3);

		Celda btnNewButton = new Celda();
		btnNewButton.setBounds(51, 138, 47, 41);
		contentPane.add(btnNewButton);

		Celda btnNewButton_1 = new Celda();
		btnNewButton_1.setBounds(110, 138, 47, 41);
		contentPane.add(btnNewButton_1);

		Celda btnNewButton_1_1 = new Celda();
		btnNewButton_1_1.setBounds(228, 138, 47, 41);
		contentPane.add(btnNewButton_1_1);

		Celda btnNewButton_2 = new Celda();
		btnNewButton_2.setBounds(169, 138, 47, 41);
		contentPane.add(btnNewButton_2);

		Celda btnNewButton_1_2 = new Celda();
		btnNewButton_1_2.setBounds(346, 138, 47, 41);
		contentPane.add(btnNewButton_1_2);

		Celda btnNewButton_3 = new Celda();
		btnNewButton_3.setBounds(287, 138, 47, 41);
		contentPane.add(btnNewButton_3);

		Celda btnNewButton_1_3 = new Celda();
		btnNewButton_1_3.setBounds(464, 138, 47, 41);
		contentPane.add(btnNewButton_1_3);

		Celda btnNewButton_4 = new Celda();
		btnNewButton_4.setBounds(405, 138, 47, 41);
		contentPane.add(btnNewButton_4);

		Celda btnNewButton_1_3_1 = new Celda();
		btnNewButton_1_3_1.setBounds(523, 138, 47, 41);
		contentPane.add(btnNewButton_1_3_1);

		Celda btnNewButton_5 = new Celda();
		btnNewButton_5.setBounds(51, 192, 47, 41);
		contentPane.add(btnNewButton_5);

		Celda btnNewButton_1_4 = new Celda();
		btnNewButton_1_4.setBounds(110, 192, 47, 41);
		contentPane.add(btnNewButton_1_4);

		Celda btnNewButton_1_1_1 = new Celda();
		btnNewButton_1_1_1.setBounds(228, 192, 47, 41);
		contentPane.add(btnNewButton_1_1_1);

		Celda btnNewButton_2_1 = new Celda();
		btnNewButton_2_1.setBounds(169, 192, 47, 41);
		contentPane.add(btnNewButton_2_1);

		Celda btnNewButton_1_2_1 = new Celda();
		btnNewButton_1_2_1.setBounds(346, 192, 47, 41);
		contentPane.add(btnNewButton_1_2_1);

		Celda btnNewButton_3_1 = new Celda();
		btnNewButton_3_1.setBounds(287, 192, 47, 41);
		contentPane.add(btnNewButton_3_1);

		Celda btnNewButton_1_3_2 = new Celda();
		btnNewButton_1_3_2.setBounds(464, 192, 47, 41);
		contentPane.add(btnNewButton_1_3_2);

		Celda btnNewButton_4_1 = new Celda();
		btnNewButton_4_1.setBounds(405, 192, 47, 41);
		contentPane.add(btnNewButton_4_1);

		Celda btnNewButton_1_3_1_1 = new Celda();
		btnNewButton_1_3_1_1.setBounds(523, 192, 47, 41);
		contentPane.add(btnNewButton_1_3_1_1);

		Celda btnNewButton_6 = new Celda();
		btnNewButton_6.setBounds(51, 246, 47, 41);
		contentPane.add(btnNewButton_6);

		Celda btnNewButton_1_5 = new Celda();
		btnNewButton_1_5.setBounds(110, 246, 47, 41);
		contentPane.add(btnNewButton_1_5);

		Celda btnNewButton_1_1_2 = new Celda();
		btnNewButton_1_1_2.setBounds(228, 246, 47, 41);
		contentPane.add(btnNewButton_1_1_2);

		Celda btnNewButton_2_2 = new Celda();
		btnNewButton_2_2.setBounds(169, 246, 47, 41);
		contentPane.add(btnNewButton_2_2);

		Celda btnNewButton_1_2_2 = new Celda();
		btnNewButton_1_2_2.setBounds(346, 246, 47, 41);
		contentPane.add(btnNewButton_1_2_2);

		Celda btnNewButton_3_2 = new Celda();
		btnNewButton_3_2.setBounds(287, 246, 47, 41);
		contentPane.add(btnNewButton_3_2);

		Celda btnNewButton_1_3_3 = new Celda();
		btnNewButton_1_3_3.setBounds(464, 246, 47, 41);
		contentPane.add(btnNewButton_1_3_3);

		Celda btnNewButton_4_2 = new Celda();
		btnNewButton_4_2.setBounds(405, 246, 47, 41);
		contentPane.add(btnNewButton_4_2);

		Celda btnNewButton_1_3_1_2 = new Celda();
		btnNewButton_1_3_1_2.setBounds(523, 246, 47, 41);
		contentPane.add(btnNewButton_1_3_1_2);

		Celda btnNewButton_7 = new Celda();
		btnNewButton_7.setBounds(51, 300, 47, 41);
		contentPane.add(btnNewButton_7);

		Celda btnNewButton_1_6 = new Celda();
		btnNewButton_1_6.setBounds(110, 300, 47, 41);
		contentPane.add(btnNewButton_1_6);

		Celda btnNewButton_1_1_3 = new Celda();
		btnNewButton_1_1_3.setBounds(228, 300, 47, 41);
		contentPane.add(btnNewButton_1_1_3);

		Celda btnNewButton_2_3 = new Celda();
		btnNewButton_2_3.setBounds(169, 300, 47, 41);
		contentPane.add(btnNewButton_2_3);

		Celda btnNewButton_1_2_3 = new Celda();
		btnNewButton_1_2_3.setBounds(346, 300, 47, 41);
		contentPane.add(btnNewButton_1_2_3);

		Celda btnNewButton_3_3 = new Celda();
		btnNewButton_3_3.setBounds(287, 300, 47, 41);
		contentPane.add(btnNewButton_3_3);

		Celda btnNewButton_1_3_4 = new Celda();
		btnNewButton_1_3_4.setBounds(464, 300, 47, 41);
		contentPane.add(btnNewButton_1_3_4);

		Celda btnNewButton_4_3 = new Celda();
		btnNewButton_4_3.setBounds(405, 300, 47, 41);
		contentPane.add(btnNewButton_4_3);

		Celda btnNewButton_1_3_1_3 = new Celda();
		btnNewButton_1_3_1_3.setBounds(523, 300, 47, 41);
		contentPane.add(btnNewButton_1_3_1_3);

		Celda btnNewButton_8 = new Celda();
		btnNewButton_8.setBounds(51, 354, 47, 41);
		contentPane.add(btnNewButton_8);

		Celda btnNewButton_1_7 = new Celda();
		btnNewButton_1_7.setBounds(110, 354, 47, 41);
		contentPane.add(btnNewButton_1_7);

		Celda btnNewButton_1_1_4 = new Celda();
		btnNewButton_1_1_4.setBounds(228, 354, 47, 41);
		contentPane.add(btnNewButton_1_1_4);

		Celda btnNewButton_2_4 = new Celda();
		btnNewButton_2_4.setBounds(169, 354, 47, 41);
		contentPane.add(btnNewButton_2_4);

		Celda btnNewButton_1_2_4 = new Celda();
		btnNewButton_1_2_4.setBounds(346, 354, 47, 41);
		contentPane.add(btnNewButton_1_2_4);

		Celda btnNewButton_3_4 = new Celda();
		btnNewButton_3_4.setBounds(287, 354, 47, 41);
		contentPane.add(btnNewButton_3_4);

		Celda btnNewButton_1_3_5 = new Celda();
		btnNewButton_1_3_5.setBounds(464, 354, 47, 41);
		contentPane.add(btnNewButton_1_3_5);

		Celda btnNewButton_4_4 = new Celda();
		btnNewButton_4_4.setBounds(405, 354, 47, 41);
		contentPane.add(btnNewButton_4_4);

		Celda btnNewButton_1_3_1_4 = new Celda();
		btnNewButton_1_3_1_4.setBounds(523, 354, 47, 41);
		contentPane.add(btnNewButton_1_3_1_4);

		Celda btnNewButton_9 = new Celda();
		btnNewButton_9.setBounds(51, 408, 47, 41);
		contentPane.add(btnNewButton_9);

		Celda btnNewButton_1_8 = new Celda();
		btnNewButton_1_8.setBounds(110, 408, 47, 41);
		contentPane.add(btnNewButton_1_8);

		Celda btnNewButton_1_1_5 = new Celda();
		btnNewButton_1_1_5.setBounds(228, 408, 47, 41);
		contentPane.add(btnNewButton_1_1_5);

		Celda btnNewButton_2_5 = new Celda();
		btnNewButton_2_5.setBounds(169, 408, 47, 41);
		contentPane.add(btnNewButton_2_5);

		Celda btnNewButton_1_2_5 = new Celda();
		btnNewButton_1_2_5.setBounds(346, 408, 47, 41);
		contentPane.add(btnNewButton_1_2_5);

		Celda btnNewButton_3_5 = new Celda();
		btnNewButton_3_5.setBounds(287, 408, 47, 41);
		contentPane.add(btnNewButton_3_5);

		Celda btnNewButton_1_3_6 = new Celda();
		btnNewButton_1_3_6.setBounds(464, 408, 47, 41);
		contentPane.add(btnNewButton_1_3_6);

		Celda btnNewButton_4_5 = new Celda();
		btnNewButton_4_5.setBounds(405, 408, 47, 41);
		contentPane.add(btnNewButton_4_5);

		Celda btnNewButton_1_3_1_5 = new Celda();
		btnNewButton_1_3_1_5.setBounds(523, 408, 47, 41);
		contentPane.add(btnNewButton_1_3_1_5);

		Celda btnNewButton_10 = new Celda();
		btnNewButton_10.setBounds(51, 462, 47, 41);
		contentPane.add(btnNewButton_10);

		Celda btnNewButton_1_9 = new Celda();
		btnNewButton_1_9.setBounds(110, 462, 47, 41);
		contentPane.add(btnNewButton_1_9);

		Celda btnNewButton_1_1_6 = new Celda();
		btnNewButton_1_1_6.setBounds(228, 462, 47, 41);
		contentPane.add(btnNewButton_1_1_6);

		Celda btnNewButton_2_6 = new Celda();
		btnNewButton_2_6.setBounds(169, 462, 47, 41);
		contentPane.add(btnNewButton_2_6);

		Celda btnNewButton_1_2_6 = new Celda();
		btnNewButton_1_2_6.setBounds(346, 462, 47, 41);
		contentPane.add(btnNewButton_1_2_6);

		Celda btnNewButton_3_6 = new Celda();
		btnNewButton_3_6.setBounds(287, 462, 47, 41);
		contentPane.add(btnNewButton_3_6);

		Celda btnNewButton_1_3_7 = new Celda();
		btnNewButton_1_3_7.setBounds(464, 462, 47, 41);
		contentPane.add(btnNewButton_1_3_7);

		Celda btnNewButton_4_6 = new Celda();
		btnNewButton_4_6.setBounds(405, 462, 47, 41);
		contentPane.add(btnNewButton_4_6);

		Celda btnNewButton_1_3_1_6 = new Celda();
		btnNewButton_1_3_1_6.setBounds(523, 462, 47, 41);
		contentPane.add(btnNewButton_1_3_1_6);

		Celda btnNewButton_11 = new Celda();
		btnNewButton_11.setBounds(51, 516, 47, 41);
		contentPane.add(btnNewButton_11);

		Celda btnNewButton_1_10 = new Celda();
		btnNewButton_1_10.setBounds(110, 516, 47, 41);
		contentPane.add(btnNewButton_1_10);

		Celda btnNewButton_1_1_7 = new Celda();
		btnNewButton_1_1_7.setBounds(228, 516, 47, 41);
		contentPane.add(btnNewButton_1_1_7);

		Celda btnNewButton_2_7 = new Celda();
		btnNewButton_2_7.setBounds(169, 516, 47, 41);
		contentPane.add(btnNewButton_2_7);

		Celda btnNewButton_1_2_7 = new Celda();
		btnNewButton_1_2_7.setBounds(346, 516, 47, 41);
		contentPane.add(btnNewButton_1_2_7);

		Celda btnNewButton_3_7 = new Celda();
		btnNewButton_3_7.setBounds(287, 516, 47, 41);
		contentPane.add(btnNewButton_3_7);

		Celda btnNewButton_1_3_8 = new Celda();
		btnNewButton_1_3_8.setBounds(464, 516, 47, 41);
		contentPane.add(btnNewButton_1_3_8);

		Celda btnNewButton_4_7 = new Celda();
		btnNewButton_4_7.setBounds(405, 516, 47, 41);
		contentPane.add(btnNewButton_4_7);

		Celda btnNewButton_1_3_1_7 = new Celda();
		btnNewButton_1_3_1_7.setBounds(523, 516, 47, 41);
		contentPane.add(btnNewButton_1_3_1_7);

		Celda btnNewButton_12 = new Celda();
		btnNewButton_12.setBounds(51, 570, 47, 41);
		contentPane.add(btnNewButton_12);

		Celda btnNewButton_1_11 = new Celda();
		btnNewButton_1_11.setBounds(110, 570, 47, 41);
		contentPane.add(btnNewButton_1_11);

		Celda btnNewButton_1_1_8 = new Celda();
		btnNewButton_1_1_8.setBounds(228, 570, 47, 41);
		contentPane.add(btnNewButton_1_1_8);

		Celda btnNewButton_2_8 = new Celda();
		btnNewButton_2_8.setBounds(169, 570, 47, 41);
		contentPane.add(btnNewButton_2_8);

		Celda btnNewButton_1_2_8 = new Celda();
		btnNewButton_1_2_8.setBounds(346, 570, 47, 41);
		contentPane.add(btnNewButton_1_2_8);

		Celda btnNewButton_3_8 = new Celda();
		btnNewButton_3_8.setBounds(287, 570, 47, 41);
		contentPane.add(btnNewButton_3_8);

		Celda btnNewButton_1_3_9 = new Celda();
		btnNewButton_1_3_9.setBounds(464, 570, 47, 41);
		contentPane.add(btnNewButton_1_3_9);

		Celda btnNewButton_4_8 = new Celda();
		btnNewButton_4_8.setBounds(405, 570, 47, 41);
		contentPane.add(btnNewButton_4_8);

		Celda btnNewButton_1_3_1_8 = new Celda();
		btnNewButton_1_3_1_8.setBounds(523, 570, 47, 41);
		contentPane.add(btnNewButton_1_3_1_8);

		btnNewButton.setH(0);
		btnNewButton_1.setH(1);
		btnNewButton_2.setH(2);
		btnNewButton_1_1.setH(3);
		btnNewButton_3.setH(4);
		btnNewButton_1_2.setH(5);
		btnNewButton_4.setH(6);
		btnNewButton_1_3.setH(7);
		btnNewButton_1_3_1.setH(8);
		btnNewButton_5.setH(0);
		btnNewButton_1_4.setH(1);
		btnNewButton_2_1.setH(2);
		btnNewButton_1_1_1.setH(3);
		btnNewButton_3_1.setH(4);
		btnNewButton_1_2_1.setH(5);
		btnNewButton_4_1.setH(6);
		btnNewButton_1_3_2.setH(7);
		btnNewButton_1_3_1_1.setH(8);
		btnNewButton_6.setH(0);
		btnNewButton_1_5.setH(1);
		btnNewButton_2_2.setH(2);
		btnNewButton_1_1_2.setH(3);
		btnNewButton_3_2.setH(4);
		btnNewButton_1_2_2.setH(5);
		btnNewButton_4_2.setH(6);
		btnNewButton_1_3_3.setH(7);
		btnNewButton_1_3_1_2.setH(8);
		btnNewButton_7.setH(0);
		btnNewButton_1_6.setH(1);
		btnNewButton_2_3.setH(2);
		btnNewButton_1_1_3.setH(3);
		btnNewButton_3_3.setH(4);
		btnNewButton_1_2_3.setH(5);
		btnNewButton_4_3.setH(6);
		btnNewButton_1_3_4.setH(7);
		btnNewButton_1_3_1_3.setH(8);
		btnNewButton_8.setH(0);
		btnNewButton_1_7.setH(1);
		btnNewButton_2_4.setH(2);
		btnNewButton_1_1_4.setH(3);
		btnNewButton_3_4.setH(4);
		btnNewButton_1_2_4.setH(5);
		btnNewButton_4_4.setH(6);
		btnNewButton_1_3_5.setH(7);
		btnNewButton_1_3_1_4.setH(8);
		btnNewButton_9.setH(0);
		btnNewButton_1_8.setH(1);
		btnNewButton_2_5.setH(2);
		btnNewButton_1_1_5.setH(3);
		btnNewButton_3_5.setH(4);
		btnNewButton_1_2_5.setH(5);
		btnNewButton_4_5.setH(6);
		btnNewButton_1_3_6.setH(7);
		btnNewButton_1_3_1_5.setH(8);
		btnNewButton_10.setH(0);
		btnNewButton_1_9.setH(1);
		btnNewButton_2_6.setH(2);
		btnNewButton_1_1_6.setH(3);
		btnNewButton_3_6.setH(4);
		btnNewButton_1_2_6.setH(5);
		btnNewButton_4_6.setH(6);
		btnNewButton_1_3_7.setH(7);
		btnNewButton_1_3_1_6.setH(8);
		btnNewButton_11.setH(0);
		btnNewButton_1_10.setH(1);
		btnNewButton_2_7.setH(2);
		btnNewButton_1_1_7.setH(3);
		btnNewButton_3_7.setH(4);
		btnNewButton_1_2_7.setH(5);
		btnNewButton_4_7.setH(6);
		btnNewButton_1_3_8.setH(7);
		btnNewButton_1_3_1_7.setH(8);
		btnNewButton_12.setH(0);
		btnNewButton_1_11.setH(1);
		btnNewButton_2_8.setH(2);
		btnNewButton_1_1_8.setH(3);
		btnNewButton_3_8.setH(4);
		btnNewButton_1_2_8.setH(5);
		btnNewButton_4_8.setH(6);
		btnNewButton_1_3_9.setH(7);
		btnNewButton_1_3_1_8.setH(8);

		btnNewButton.setV(0);
		btnNewButton_1.setV(0);
		btnNewButton_2.setV(0);
		btnNewButton_1_1.setV(0);
		btnNewButton_3.setV(0);
		btnNewButton_1_2.setV(0);
		btnNewButton_4.setV(0);
		btnNewButton_1_3.setV(0);
		btnNewButton_1_3_1.setV(0);
		btnNewButton_5.setV(1);
		btnNewButton_1_4.setV(1);
		btnNewButton_2_1.setV(1);
		btnNewButton_1_1_1.setV(1);
		btnNewButton_3_1.setV(1);
		btnNewButton_1_2_1.setV(1);
		btnNewButton_4_1.setV(1);
		btnNewButton_1_3_2.setV(1);
		btnNewButton_1_3_1_1.setV(1);
		btnNewButton_6.setV(2);
		btnNewButton_1_5.setV(2);
		btnNewButton_2_2.setV(2);
		btnNewButton_1_1_2.setV(2);
		btnNewButton_3_2.setV(2);
		btnNewButton_1_2_2.setV(2);
		btnNewButton_4_2.setV(2);
		btnNewButton_1_3_3.setV(2);
		btnNewButton_1_3_1_2.setV(2);
		btnNewButton_7.setV(3);
		btnNewButton_1_6.setV(3);
		btnNewButton_2_3.setV(3);
		btnNewButton_1_1_3.setV(3);
		btnNewButton_3_3.setV(3);
		btnNewButton_1_2_3.setV(3);
		btnNewButton_4_3.setV(3);
		btnNewButton_1_3_4.setV(3);
		btnNewButton_1_3_1_3.setV(3);
		btnNewButton_8.setV(4);
		btnNewButton_1_7.setV(4);
		btnNewButton_2_4.setV(4);
		btnNewButton_1_1_4.setV(4);
		btnNewButton_3_4.setV(4);
		btnNewButton_1_2_4.setV(4);
		btnNewButton_4_4.setV(4);
		btnNewButton_1_3_5.setV(4);
		btnNewButton_1_3_1_4.setV(4);
		btnNewButton_9.setV(5);
		btnNewButton_1_8.setV(5);
		btnNewButton_2_5.setV(5);
		btnNewButton_1_1_5.setV(5);
		btnNewButton_3_5.setV(5);
		btnNewButton_1_2_5.setV(5);
		btnNewButton_4_5.setV(5);
		btnNewButton_1_3_6.setV(5);
		btnNewButton_1_3_1_5.setV(5);
		btnNewButton_10.setV(6);
		btnNewButton_1_9.setV(6);
		btnNewButton_2_6.setV(6);
		btnNewButton_1_1_6.setV(6);
		btnNewButton_3_6.setV(6);
		btnNewButton_1_2_6.setV(6);
		btnNewButton_4_6.setV(6);
		btnNewButton_1_3_7.setV(6);
		btnNewButton_1_3_1_6.setV(6);
		btnNewButton_11.setV(7);
		btnNewButton_1_10.setV(7);
		btnNewButton_2_7.setV(7);
		btnNewButton_1_1_7.setV(7);
		btnNewButton_3_7.setV(7);
		btnNewButton_1_2_7.setV(7);
		btnNewButton_4_7.setV(7);
		btnNewButton_1_3_8.setV(7);
		btnNewButton_1_3_1_7.setV(7);
		btnNewButton_12.setV(8);
		btnNewButton_1_11.setV(8);
		btnNewButton_2_8.setV(8);
		btnNewButton_1_1_8.setV(8);
		btnNewButton_3_8.setV(8);
		btnNewButton_1_2_8.setV(8);
		btnNewButton_4_8.setV(8);
		btnNewButton_1_3_9.setV(8);
		btnNewButton_1_3_1_8.setV(8);

		btnNewButton.addMouseListener(new BotonCeldas());	
		btnNewButton_1.addMouseListener(new BotonCeldas());	
		btnNewButton_2.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1.addMouseListener(new BotonCeldas());	
		btnNewButton_3.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2.addMouseListener(new BotonCeldas());	
		btnNewButton_4.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1.addMouseListener(new BotonCeldas());
		btnNewButton_5.addMouseListener(new BotonCeldas());	
		btnNewButton_1_4.addMouseListener(new BotonCeldas());	
		btnNewButton_2_1.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_1.addMouseListener(new BotonCeldas());	
		btnNewButton_3_1.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_1.addMouseListener(new BotonCeldas());	
		btnNewButton_4_1.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_2.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_1.addMouseListener(new BotonCeldas());
		btnNewButton_6.addMouseListener(new BotonCeldas());	
		btnNewButton_1_5.addMouseListener(new BotonCeldas());	
		btnNewButton_2_2.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_2.addMouseListener(new BotonCeldas());	
		btnNewButton_3_2.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_2.addMouseListener(new BotonCeldas());	
		btnNewButton_4_2.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_3.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_2.addMouseListener(new BotonCeldas());
		btnNewButton_7.addMouseListener(new BotonCeldas());	
		btnNewButton_1_6.addMouseListener(new BotonCeldas());	
		btnNewButton_2_3.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_3.addMouseListener(new BotonCeldas());	
		btnNewButton_3_3.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_3.addMouseListener(new BotonCeldas());	
		btnNewButton_4_3.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_4.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_3.addMouseListener(new BotonCeldas());
		btnNewButton_8.addMouseListener(new BotonCeldas());	
		btnNewButton_1_7.addMouseListener(new BotonCeldas());	
		btnNewButton_2_4.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_4.addMouseListener(new BotonCeldas());	
		btnNewButton_3_4.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_4.addMouseListener(new BotonCeldas());	
		btnNewButton_4_4.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_5.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_4.addMouseListener(new BotonCeldas());
		btnNewButton_9.addMouseListener(new BotonCeldas());	
		btnNewButton_1_8.addMouseListener(new BotonCeldas());	
		btnNewButton_2_5.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_5.addMouseListener(new BotonCeldas());	
		btnNewButton_3_5.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_5.addMouseListener(new BotonCeldas());	
		btnNewButton_4_5.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_6.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_5.addMouseListener(new BotonCeldas());
		btnNewButton_10.addMouseListener(new BotonCeldas());	
		btnNewButton_1_9.addMouseListener(new BotonCeldas());	
		btnNewButton_2_6.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_6.addMouseListener(new BotonCeldas());	
		btnNewButton_3_6.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_6.addMouseListener(new BotonCeldas());	
		btnNewButton_4_6.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_7.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_6.addMouseListener(new BotonCeldas());
		btnNewButton_11.addMouseListener(new BotonCeldas());	
		btnNewButton_1_10.addMouseListener(new BotonCeldas());	
		btnNewButton_2_7.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_7.addMouseListener(new BotonCeldas());	
		btnNewButton_3_7.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_7.addMouseListener(new BotonCeldas());	
		btnNewButton_4_7.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_8.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_7.addMouseListener(new BotonCeldas());
		btnNewButton_12.addMouseListener(new BotonCeldas());	
		btnNewButton_1_11.addMouseListener(new BotonCeldas());	
		btnNewButton_2_8.addMouseListener(new BotonCeldas());	
		btnNewButton_1_1_8.addMouseListener(new BotonCeldas());	
		btnNewButton_3_8.addMouseListener(new BotonCeldas());	
		btnNewButton_1_2_8.addMouseListener(new BotonCeldas());	
		btnNewButton_4_8.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_9.addMouseListener(new BotonCeldas());	
		btnNewButton_1_3_1_8.addMouseListener(new BotonCeldas());

		celda[0][0]=btnNewButton;	
		celda[0][1]=btnNewButton_1;	
		celda[0][2]=btnNewButton_2;	
		celda[0][3]=btnNewButton_1_1;	
		celda[0][4]=btnNewButton_3;	
		celda[0][5]=btnNewButton_1_2;	
		celda[0][6]=btnNewButton_4;	
		celda[0][7]=btnNewButton_1_3;	
		celda[0][8]=btnNewButton_1_3_1;	
		celda[1][0]=btnNewButton_5;	
		celda[1][1]=btnNewButton_1_4;	
		celda[1][2]=btnNewButton_2_1;	
		celda[1][3]=btnNewButton_1_1_1;	
		celda[1][4]=btnNewButton_3_1;	
		celda[1][5]=btnNewButton_1_2_1;	
		celda[1][6]=btnNewButton_4_1;	
		celda[1][7]=btnNewButton_1_3_2;	
		celda[1][8]=btnNewButton_1_3_1_1;	
		celda[2][0]=btnNewButton_6;	
		celda[2][1]=btnNewButton_1_5;	
		celda[2][2]=btnNewButton_2_2;	
		celda[2][3]=btnNewButton_1_1_2;	
		celda[2][4]=btnNewButton_3_2;	
		celda[2][5]=btnNewButton_1_2_2;	
		celda[2][6]=btnNewButton_4_2;	
		celda[2][7]=btnNewButton_1_3_3;	
		celda[2][8]=btnNewButton_1_3_1_2;	
		celda[3][0]=btnNewButton_7;	
		celda[3][1]=btnNewButton_1_6;	
		celda[3][2]=btnNewButton_2_3;	
		celda[3][3]=btnNewButton_1_1_3;	
		celda[3][4]=btnNewButton_3_3;	
		celda[3][5]=btnNewButton_1_2_3;	
		celda[3][6]=btnNewButton_4_3;	
		celda[3][7]=btnNewButton_1_3_4;	
		celda[3][8]=btnNewButton_1_3_1_3;	
		celda[4][0]=btnNewButton_8;	
		celda[4][1]=btnNewButton_1_7;	
		celda[4][2]=btnNewButton_2_4;	
		celda[4][3]=btnNewButton_1_1_4;	
		celda[4][4]=btnNewButton_3_4;	
		celda[4][5]=btnNewButton_1_2_4;	
		celda[4][6]=btnNewButton_4_4;	
		celda[4][7]=btnNewButton_1_3_5;	
		celda[4][8]=btnNewButton_1_3_1_4;	
		celda[5][0]=btnNewButton_9;	
		celda[5][1]=btnNewButton_1_8;	
		celda[5][2]=btnNewButton_2_5;	
		celda[5][3]=btnNewButton_1_1_5;	
		celda[5][4]=btnNewButton_3_5;	
		celda[5][5]=btnNewButton_1_2_5;	
		celda[5][6]=btnNewButton_4_5;	
		celda[5][7]=btnNewButton_1_3_6;	
		celda[5][8]=btnNewButton_1_3_1_5;	
		celda[6][0]=btnNewButton_10;	
		celda[6][1]=btnNewButton_1_9;	
		celda[6][2]=btnNewButton_2_6;	
		celda[6][3]=btnNewButton_1_1_6;	
		celda[6][4]=btnNewButton_3_6;	
		celda[6][5]=btnNewButton_1_2_6;	
		celda[6][6]=btnNewButton_4_6;	
		celda[6][7]=btnNewButton_1_3_7;	
		celda[6][8]=btnNewButton_1_3_1_6;	
		celda[7][0]=btnNewButton_11;	
		celda[7][1]=btnNewButton_1_10;	
		celda[7][2]=btnNewButton_2_7;	
		celda[7][3]=btnNewButton_1_1_7;	
		celda[7][4]=btnNewButton_3_7;	
		celda[7][5]=btnNewButton_1_2_7;	
		celda[7][6]=btnNewButton_4_7;	
		celda[7][7]=btnNewButton_1_3_8;	
		celda[7][8]=btnNewButton_1_3_1_7;
		celda[8][0]=btnNewButton_12;
		celda[8][1]=btnNewButton_1_11;
		celda[8][2]=btnNewButton_2_8;
		celda[8][3]=btnNewButton_1_1_8;
		celda[8][4]=btnNewButton_3_8;
		celda[8][5]=btnNewButton_1_2_8;
		celda[8][6]=btnNewButton_4_8;
		celda[8][7]=btnNewButton_1_3_9;
		celda[8][8]=btnNewButton_1_3_1_8;


		JPanel lblNewLabel = new JPanel();
		lblNewLabel.setBounds(216, 138, 13, 473);
		lblNewLabel.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel);

		JPanel lblNewLabel_1 = new JPanel();
		lblNewLabel_1.setBounds(392, 138, 13, 473);
		lblNewLabel_1.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(51, 287, 519, 13);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 449, 519, 13);
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Eclipse-workbench\\Proyecto 2 tdp\\Imagenes\\0.png"));
		lblNewLabel_2.setBounds(670, 176, 47, 57);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\Eclipse-workbench\\Proyecto 2 tdp\\Imagenes\\0.png"));
		lblNewLabel_2_1.setBounds(639, 176, 38, 57);
		contentPane.add(lblNewLabel_2_1);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Eclipse-workbench\\Proyecto 2 tdp\\Imagenes\\0.png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(712, 176, 38, 57);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("D:\\Eclipse-workbench\\Proyecto 2 tdp\\Imagenes\\0.png"));
		lblNewLabel_2_1_1.setBounds(743, 176, 38, 57);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_5 = new JLabel(":");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_5.setBounds(709, 184, 13, 36);
		contentPane.add(lblNewLabel_5);

		segundos = 0;
		minutos = 0;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);

		btnNewButton.addKeyListener(new teclasListener());

		try {
			s = new Sudoku(celda);
		} catch (ArchivoMalException e) {
			JOptionPane.showMessageDialog(null, "El archivo ingresado es incorrecto: "+e.getMessage());
			ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));			
		}
		setVisible(true);
	}
	TimerTask timerTask = new TimerTask()
	{
		public void run() 
		{
			if(segundos==60) {
				segundos=0;
				minutos++;
			}
			actualizarReloj();
			segundos++;
		}
	};

	public void actualizarReloj() {
		lblNewLabel_2_1_1.setIcon(new ImageIcon("Imagenes\\"+segundos%10+".png")); 
		lblNewLabel_4.setIcon(new ImageIcon("Imagenes\\"+segundos/10+".png"));
		lblNewLabel_2.setIcon(new ImageIcon("Imagenes\\"+minutos%10+".png"));
		lblNewLabel_2_1.setIcon(new ImageIcon("Imagenes\\"+minutos/10+".png"));
	}
}
