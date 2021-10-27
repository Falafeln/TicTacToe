package com.grupp5a;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//   VIKTIGA SAKER ATT KOLLA UPP!

/***************************************************
 * Det saknas foljande:                            *
 *   - Andra färger o fonts                        *
 *   - Ev. lagga in en dator som spelare           *
 *   - klickar man för snabbt missas forsta rundan *
 **************************************************/



public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame ram = new JFrame();
	JPanel titelPanel = new JPanel();
	JPanel knappPanel = new JPanel();
	JLabel textFalt = new JLabel();
	JButton[] knapp = new JButton[9];
	boolean spelare1_tur;

	TicTacToe() {

		ram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ram.setSize(800, 800);
		ram.getContentPane().setBackground(new Color(50, 50, 50));
		ram.setLayout(new BorderLayout());
		ram.setVisible(true);

		textFalt.setBackground(new Color(25, 25, 25));
		textFalt.setForeground(new Color(25, 255, 0));
		textFalt.setFont(new Font("Ink Free", Font.BOLD, 75));
		textFalt.setHorizontalAlignment(JLabel.CENTER);
		textFalt.setText("Tic-Tac-Toe");
		textFalt.setOpaque(true);

		titelPanel.setLayout(new BorderLayout());
		titelPanel.setBounds(0, 0, 800, 100);

		knappPanel.setLayout(new GridLayout(3, 3));
		knappPanel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			knapp[i] = new JButton();
			knappPanel.add(knapp[i]);
			knapp[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			knapp[i].setFocusable(false);
			knapp[i].addActionListener(this);
		}

		titelPanel.add(textFalt);
		ram.add(titelPanel, BorderLayout.NORTH);
		ram.add(knappPanel);

		forstaRundan();

	}

	public void actionPerformed(ActionEvent e) {

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

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (random.nextInt(2) == 0) {
			spelare1_tur = true;
			textFalt.setText("X tur");

		} else {
			spelare1_tur = false;
			textFalt.setText("O tur");
		}

	}

	public void kontrollera() {
		// Check X win conditions
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

		// Check O win conditions
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

	}

	public void xVinner(int a, int b, int c) {
		knapp[a].setBackground(Color.GREEN);
		knapp[b].setBackground(Color.GREEN);
		knapp[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			knapp[i].setEnabled(false);
		}
		textFalt.setText("X vinner!");

	}

	public void oVinner(int a, int b, int c) {
		knapp[a].setBackground(Color.GREEN);
		knapp[b].setBackground(Color.GREEN);
		knapp[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			knapp[i].setEnabled(false);
		}
		textFalt.setText("O vinner!");

	}
	public void lika() {
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
