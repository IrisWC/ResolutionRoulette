package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.AttributedString;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import core.Game;
import fileStuff.FileChanger;

public class Screen extends JPanel implements ActionListener {

	private Game mainCore;
	private String level;
	private FileChanger[] categories;
	
	public Screen(Game mainCore, String level) {
		super();
		this.mainCore = mainCore;
		this.level = level;
		categories = new FileChanger[7];
		
		this.setBackground(new Color(230,190,200));
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

//		Graphics2D g2 = (Graphics2D)g;
//
//		int width = getWidth();
//		int height = getHeight();
//
//		double ratioX = (double)width/this.width;
//		double ratioY = (double)height/this.height;
//
//		AffineTransform at = g2.getTransform();
//		g2.scale(ratioX, ratioY);
//		
//		g2.setTransform(at);
		
		Font font = null;
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PixelifySans-VariableFont_wght.ttf")).deriveFont(48f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		g.drawString("mwahahahaha", 100, 100);
		AttributedString atString= new AttributedString("mwahahahaha");
		atString.addAttribute(TextAttribute.FONT, font);
		g.drawString(atString.getIterator(), 100, 100);
		
	}
	
	
//	public void run() {
//		while(true) {
//			repaint();
//			
//			try {
//				Thread.sleep(20);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}