package com.grupp5a;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1_turn;

	TicTacToe() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9;i++) {
			button[i]= new JButton();
			button_panel.add(button[i]);
			button[i].setFont(new Font("MV Boli", Font.BOLD,120));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		
		firstTurn();
		

	}

	public void actionPerformed(ActionEvent e) {

	}

	public void firstTurn() {
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("X turn");
			
		}
		else {
			player1_turn=false;
			textfield.setText("O turn");
		}

	}

	public void check() {

	}

	public void xWins(int a, int b, int c) {

	}

	public void oWins(int a, int b, int c) {

	}

}
