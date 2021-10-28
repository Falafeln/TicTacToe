package com.grupp5a;
import java.awt.*;
public class Anna extends Frame {

	
	   public void paint(Graphics g)
	   {
	      setBackground(Color.black);
	      setForeground(Color.white);
	      Font tr = new Font("TimesRoman", Font.PLAIN, 18);
	      Font trb = new Font("TimesRoman", Font.BOLD, 18);
	      Font tri = new Font("TimesRoman", Font.ITALIC, 18);
	      Font trbi = new Font("TimesRoman", Font.BOLD+Font.ITALIC, 18);
	      Font h = new Font("Helvetica", Font.PLAIN, 18);
	      Font c = new Font("Courier", Font.PLAIN, 18);
	      Font d = new Font("Dialog", Font.PLAIN, 18);      
	      Font z = new Font("ZapfDingbats", Font.PLAIN, 18);            

	      g.setFont(tr);
	      g.drawString("TIC-TAC-TOE (times roman plain)",10,25);
	      g.setFont(trb);
	      g.drawString("TIC-TAC-TOE (times roman bold)",10,50);
	      g.setFont(tri);
	      g.drawString("TIC-TAC-TOE (times roman italic)",10,75);
	      g.setFont(trbi);
	      g.drawString("TIC-TAC-TOE (times roman bold & italic)",10,100);
	      g.setFont(h);
	      g.drawString("TIC-TAC-TOE (helvetica)",10,125);
	      g.setFont(c);
	      g.drawString("TIC-TAC-TOE (courier)",10,150);
	      g.setFont(d);
	      g.drawString("TIC-TAC-TOE (dialog)",10,175);
	      g.setFont(z);
	      g.drawString("TIC-TAC-TOE (zapf dingbats)",10,200);
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame ff = new Anna();
	      ff.resize(400,400);
	      ff.show();
	}
	
	
	
	}
	

