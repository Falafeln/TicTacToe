package com.grupp5a;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//   VIKTIGA SAKER ATT KOLLA UPP!

/****************************************************
 * Det saknas foljande:                             *
 *   - Andra farger o fonts                         *
 *   - Ev. lagga in en dator som spelare            *
 *   - klickar man f�r snabbt missas forsta rundan  *
 *   - Skriv in kommentarer som forklarar varje steg*
 ***************************************************/



public class TicTacToe implements ActionListener {
	
	Random random = new Random();
	JFrame ram = new JFrame();
	JPanel titelPanel = new JPanel();
	JPanel knappPanel = new JPanel();
	JLabel textFalt = new JLabel();
	JButton[] knapp = new JButton[9];
	boolean spelare1_tur;

	// Alla variabler som används udner programets körning
	
	TicTacToe() {
		
		// Tillverkar spelbrädan 

		ram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ram.setSize(800, 800);
		ram.getContentPane().setBackground(new Color(50, 50, 50));
		ram.setLayout(new BorderLayout());
		ram.setVisible(true);
		
		// Gjort ramen för Jframe

		textFalt.setBackground(new Color(25, 25, 25));
		textFalt.setForeground(new Color(25, 255, 0));
		textFalt.setFont(new Font("Ink Free", Font.BOLD, 75));
		textFalt.setHorizontalAlignment(JLabel.CENTER);
		textFalt.setText("Tic-Tac-Toe");
		textFalt.setOpaque(true);
		
		// Gjort textfältet för spelet

		titelPanel.setLayout(new BorderLayout());
		titelPanel.setBounds(0, 0, 800, 100);
		
		// Gjort rutan för textrutan

		knappPanel.setLayout(new GridLayout(3, 3));
		knappPanel.setBackground(new Color(150, 150, 150));
			
		// Gjort knapprutan, använde GridLayout för att få ett spelfält som är 3x3

		for (int i = 0; i < 9; i++) {
			knapp[i] = new JButton();
			knappPanel.add(knapp[i]);
			knapp[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			knapp[i].setFocusable(false);
			knapp[i].addActionListener(this);
		}
		
		// Använde oss av for-lop för att göra 9 knappar

		titelPanel.add(textFalt);
		ram.add(titelPanel, BorderLayout.NORTH);
		ram.add(knappPanel);
		
		// Lägger in allt i Jframe, använde BorderLayout.NORTH för att få titelpanelen ovanförknapparna 

		forstaRundan();

	}

	public void actionPerformed(ActionEvent e) {
		
		/* Använder oss av ActionLisener för att se vilken knapp användarna trycker på.
 	   	*  Lopar igenom knapparna för att ta fram vilken spelare det var som tryckte och på vilken knapp dom tryckte på.
		*  Kollar även så att ingen spelare redan har lagt på rutan som användaren trycker på.
		*  Använder även blooean spelare1_tur för att byta mellan spelare 1 och 2 omgång. */

		for (int i = 0; i < 9; i++) {
			if (e.getSource() == knapp[i]) {
				if (spelare1_tur) {
					if (knapp[i].getText() == "") {
						knapp[i].setForeground(new Color(255, 0, 0));
						knapp[i].setText("X");
						spelare1_tur = false;
						textFalt.setText("O tur");
						kontrollera();
						lika();
					}
				} else {
					if (knapp[i].getText() == "") {
						knapp[i].setForeground(new Color(0, 0, 255));
						knapp[i].setText("O");
						spelare1_tur = true;
						textFalt.setText("X tur");
						kontrollera();
						lika();
					}
				}
			}
		}

	}

	public void forstaRundan() {
		
		// Tar fram vem som får börja, använder oss av Random.
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Har en .sleep så man hinner se vad det är man spelar innan vi anger vilken spelare som börjar.

		if (random.nextInt(2) == 0) {
			spelare1_tur = true;
			textFalt.setText("X tur");

		} else {
			spelare1_tur = false;
			textFalt.setText("O tur");
		}

	}

	public void kontrollera() {
		
		// Kollar om nån har vunnit.
		// Använder oss av getText för att få Char för varje ruta och kollar på så sätt om nån av spelarna har vunnit.
		
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
		// kollat om X har vunnit, forstätter med O.

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
		
		// Om X har vunnit så byter vi färg på den/dom vinnande raderna så man lätt ser vart spelarn har vunnit.
		
		knapp[a].setBackground(Color.GREEN);
		knapp[b].setBackground(Color.GREEN);
		knapp[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			knapp[i].setEnabled(false);
		}
		textFalt.setText("X vinner!");

	}

	public void oVinner(int a, int b, int c) {
		
		// Om O har vunnit så byter vi färg på den/dom vinnande raderna så man lätt ser vart spelarn har vunnit.
		
		knapp[a].setBackground(Color.GREEN);
		knapp[b].setBackground(Color.GREEN);
		knapp[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			knapp[i].setEnabled(false);
		}
		textFalt.setText("O vinner!");

	}
	public void lika() {
		
		// Lopar igenom alla knappar för att se om dom är använda.
		// Om alla knappar är använda och ingen har vunnit så Skriver vi ut att spelet blev lika
		
		int lika = 0;
		for (int i = 0; i < 9; i++) {
			if (knapp[i].getText() == "X" || knapp[i].getText() == "O") {
				lika++;
			}
		}
		if (lika == 9 && textFalt.getText() != "O vinner!" && textFalt.getText() != "X vinner!") {
			for (int i = 0; i < 9; i++) {
				knapp[i].setBackground(Color.RED);
				knapp[i].setEnabled(false);
			}
			textFalt.setText("Det blev lika!");
		}
	}

}
