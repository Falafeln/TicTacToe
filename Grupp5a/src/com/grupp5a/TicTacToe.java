package com.grupp5a;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;





public class TicTacToe implements ActionListener {
	
	Random random = new Random();
	JFrame ram = new JFrame();
	JPanel titelPanel = new JPanel();
	JPanel knappPanel = new JPanel();
	JLabel textFalt = new JLabel();
	JButton[] knapp = new JButton[9];
	boolean spelare1_tur;

	// Alla variabler som anv�nds under programmets k�rning
	
	TicTacToe() {
		
		// Tillverkar spelbr�dan 

		ram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ram.setSize(800, 800);
		ram.getContentPane().setBackground(new Color(50, 50, 50));
		ram.setLayout(new BorderLayout());
		ram.setVisible(true);
		
		// Gjort ramen f�r Jframe

		textFalt.setBackground(new Color(25, 25, 25));
		textFalt.setForeground(new Color(255, 153, 0));
		textFalt.setFont(new Font("Elephant", Font.BOLD, 50));
		textFalt.setHorizontalAlignment(JLabel.CENTER);
		textFalt.setText("Tic-Tac-Toe");
		textFalt.setOpaque(true);
		
		// Gjort textf�ltet f�r spelet

		titelPanel.setLayout(new BorderLayout());
		titelPanel.setBounds(0, 0, 800, 100);
		
		// Gjort rutan f�r textrutan

		knappPanel.setLayout(new GridLayout(3, 3));
		knappPanel.setBackground(new Color(204, 204, 204));
			
		// Gjort knapprutan, anv�nde GridLayout f�r att f� ett spelf�lt som �r 3x3

		for (int i = 0; i < 9; i++) {
			knapp[i] = new JButton();
			knappPanel.add(knapp[i]);
			knapp[i].setFont(new Font("Chiller", Font.BOLD, 150));
			knapp[i].setFocusable(false);
			knapp[i].addActionListener(this);
			knapp[i].setBackground(new Color (40,45,45));
		}
		
		// Anv�nde oss av for-lop f�r att g�ra 9 knappar

		titelPanel.add(textFalt);
		ram.add(titelPanel, BorderLayout.NORTH);
		ram.add(knappPanel);
		
		// L�gger in allt i Jframe, anv�nde BorderLayout.NORTH f�r att f� titelpanelen ovanf�r knapparna 

		forstaRundan();

	}

	public void actionPerformed(ActionEvent e) {
		
		/* Anv�nder oss av ActionLisener f�r att se vilken knapp anv�ndarna trycker p�.
 	   	*  Lopar igenom knapparna f�r att ta fram vilken spelare det var som tryckte och p� vilken knapp dom tryckte p�.
		*  Kollar �ven s� att ingen spelare redan har lagt p� rutan som anv�ndaren trycker p�.
		*  Anv�nder �ven blooean spelare1_tur f�r att byta mellan spelare 1 och 2 omg�ng. */

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == knapp[i]) {
				if (spelare1_tur) {
					if (knapp[i].getText() == "") {
						knapp[i].setForeground(new Color(102, 0, 153));
						knapp[i].setText("X");
						spelare1_tur = false;
						textFalt.setText("Spelare O, det �r din tur!");
						kontrollera();
						lika();
					}
				} else {
					if (knapp[i].getText() == "") {
						knapp[i].setForeground(new Color(51, 204, 255));
						knapp[i].setText("O");
						spelare1_tur = true;
						textFalt.setText("Spelare X, det �r din tur!");
						kontrollera();
						lika();
					}
				}
			}
		}

	}

	public void forstaRundan() {
		
		// Tar fram vem som f�r b�rja, anv�nder oss av Random.
		for (int i = 0; i < 9; i++) {
			knapp[i].setEnabled(false);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Har en .sleep s� man hinner se vad det �r man spelar innan vi anger vilken spelare som b�rjar.

		if (random.nextInt(2) == 0) {
			for (int i = 0; i < 9; i++) {
				knapp[i].setEnabled(true);
			}
			spelare1_tur = true;
			textFalt.setText("Spelare X, det �r din tur!");

		} else {
			for (int i = 0; i < 9; i++) {
				knapp[i].setEnabled(true);
			}
			spelare1_tur = false;
			textFalt.setText("Spelare O, det �r din tur!");
		}

	}

	public void kontrollera() {
		
		// Kollar om n�gon har vunnit.
		// Anv�nder oss av getText f�r att f� Char f�r varje ruta och kollar p� s� s�tt om n�gon av spelarna har vunnit.
		
		if ((knapp[0].getText() == "X") && (knapp[1].getText() == "X") && (knapp[2].getText() == "X")) {
			xVinner(0, 1, 2);

		}
		
		if ((knapp[3].getText() == "X") && (knapp[4].getText() == "X") && (knapp[5].getText() == "X")) {
			xVinner(3, 4, 5);

		}
		if((knapp[6].getText()=="X") &&
				(knapp[7].getText()=="X") &&
				(knapp[8].getText()=="X")
					) {
				xVinner(6,7,8);
					
				}
		if((knapp[0].getText()=="X") &&
				(knapp[3].getText()=="X") &&
				(knapp[6].getText()=="X")
					) {
				xVinner(0,3,6);
					
				}
		if((knapp[1].getText()=="X") &&
				(knapp[4].getText()=="X") &&
				(knapp[7].getText()=="X")
					) {
				xVinner(1,4,7);
					
				}
		if((knapp[2].getText()=="X") &&
				(knapp[5].getText()=="X") &&
				(knapp[8].getText()=="X")
					) {
				xVinner(2,5,8);
					
				}
		if((knapp[0].getText()=="X") &&
				(knapp[4].getText()=="X") &&
				(knapp[8].getText()=="X")
					) {
				xVinner(0,4,8);
					
				}
		if((knapp[2].getText()=="X") &&
				(knapp[4].getText()=="X") &&
				(knapp[6].getText()=="X")
					) {
				xVinner(2,4,6);
					
				}
		// kollat om X har vunnit, forts�tter med O.

		if ((knapp[0].getText() == "O") && (knapp[1].getText() == "O") && (knapp[2].getText() == "O")) {
			oVinner(0, 1, 2);

		}
		
		if ((knapp[3].getText() == "O") && (knapp[4].getText() == "O") && (knapp[5].getText() == "O")) {
			oVinner(3, 4, 5);

		}
		if((knapp[6].getText()=="O") &&
				(knapp[7].getText()=="O") &&
				(knapp[8].getText()=="O")
					) {
				oVinner(6,7,8);
					
				}
		if((knapp[0].getText()=="O") &&
				(knapp[3].getText()=="O") &&
				(knapp[6].getText()=="O")
					) {
				oVinner(0,3,6);
					
				}
		if((knapp[1].getText()=="O") &&
				(knapp[4].getText()=="O") &&
				(knapp[7].getText()=="O")
					) {
				oVinner(1,4,7);
					
				}
		if((knapp[2].getText()=="O") &&
				(knapp[5].getText()=="O") &&
				(knapp[8].getText()=="O")
					) {
				oVinner(2,5,8);
					
				}
		if((knapp[0].getText()=="O") &&
				(knapp[4].getText()=="O") &&
				(knapp[8].getText()=="O")
					) {
				oVinner(0,4,8);
					
				}
		if((knapp[2].getText()=="O") &&
				(knapp[4].getText()=="O") &&
				(knapp[6].getText()=="O")
					) {
				oVinner(2,4,6);
					
				}
		// kollat om O har vunnit.

	}

	public void xVinner(int a, int b, int c) {
		
		// Om X har vunnit s� byter vi f�rg p� den/dom vinnande raderna s� man l�tt ser vart spelaren har vunnit.
		
		knapp[a].setBackground(new Color(102,255,102));
		knapp[b].setBackground(new Color(102,255,102));
		knapp[c].setBackground(new Color(102,255,102));
		
		for(int i=0;i<9;i++) {
			knapp[i].setEnabled(false);
		}
		textFalt.setText("X vinner!");

	}

	public void oVinner(int a, int b, int c) {
		
		// Om O har vunnit s� byter vi f�rg p� den/dom vinnande raderna s� man l�tt ser vart spelaren har vunnit.
		
		knapp[a].setBackground(new Color(102,255,102));
		knapp[b].setBackground(new Color(102,255,102));
		knapp[c].setBackground(new Color(102,255,102));
		
		for(int i=0;i<9;i++) {
			knapp[i].setEnabled(false);
		}
		textFalt.setText("O vinner!");

	}
	public void lika() {
		
		// Loopar igenom alla knappar f�r att se om dom �r anv�nda.
		// Om alla knappar �r anv�nda och ingen har vunnit s� Skriver vi ut att spelet blev lika
		
		int lika = 0;
		for (int i = 0; i < 9; i++) {
			if (knapp[i].getText() == "X" || knapp[i].getText() == "O") {
				lika++;
			}
		}
		if (lika == 9 && textFalt.getText() != "O vinner!" && textFalt.getText() != "X vinner!") {
			for (int i = 0; i < 9; i++) {
				knapp[i].setBackground(new Color(153,0,0));
				knapp[i].setEnabled(false);
			}
			textFalt.setText("Det blev lika!");
		}
	}

}
