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

import Core.Game;

public class Easy extends JPanel implements ActionListener {

	private Game mainCore;
	
	public Easy(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
		
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
	
	public static void setUp(String i, String o) {//String i, String o) {
//		try {
//			File input = new File(i);
//			Scanner s = new Scanner(input);
//			s.useDelimiter(",");
//			
//			File output = new File(o);
//			PrintWriter writer = new PrintWriter(output);
//			
//			while (s.hasNext()) {
//				String next = s.next();
//				if (isPrime(next)) {
//					writer.println(next);
//				}
//			}
//			
//			writer.close();
//			
//		}
//		catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		try {
			File input = new File(i);
			Scanner s = new Scanner(input);
			s.useDelimiter("\n");
			
			File output = new File(o);
			PrintWriter writer = new PrintWriter(output);
			
			while (s.hasNext()) {
				String next = s.next();
				if (next.charAt(0) == 'i') {
					writer.println(next);
				}
			}
			
			writer.close();
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * i am a monkey
i love apples
poop is delicious
u shall laugh
	 */
	
	public static void main (String[] args) {
		Easy.setUp("easy/input", "easy/output");
		
	}
	
	public void run() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
