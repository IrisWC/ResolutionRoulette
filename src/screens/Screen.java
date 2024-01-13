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
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import core.Game;
import fileStuff.FileChanger;

public class Screen extends JPanel implements ActionListener {

	private Game mainCore;
	private String level;
	private FileChanger[] categories;
	private String[] categoryNames;
	
	private FileChanger test;
	
	public Screen(Game mainCore, String level) {
		super();
		this.mainCore = mainCore;
		this.level = level;
		
		this.setBackground(new Color(230,190,200));
		
		categories = new FileChanger[8];
		categories[0] = new FileChanger("files/clean.txt");
		categories[1] = new FileChanger("files/diet.txt");
		categories[2] = new FileChanger("files/exercise.txt");
		categories[3] = new FileChanger("files/mindfulness.txt");
		categories[4] = new FileChanger("files/new skill.txt");
		categories[5] = new FileChanger("files/punishment.txt");
		categories[6] = new FileChanger("files/self-care.txt");
		categories[7] = new FileChanger("files/social.txt");
		
		categoryNames = new String[8];
		for (int i = 0; i < categories.length; i++) {
			categoryNames[i] = categories[i].toString();
		}
        
		
		JComboBox<String> categoryBox = new JComboBox<>(categoryNames);	
		categoryBox.setBounds(543, 244, 140, 50);
		categoryBox.setBackground(new Color(65, 31, 78));
		this.setOpaque(true);
		categoryBox.setForeground(new Color(200, 200, 200));
		this.add(categoryBox);
        
        this.add(categoryBox);
		
//		test = new FileChanger("files/test.txt");
//		if (test.readFile()) {
//			test.add("i love apples", "i eat monkeys");
//			test.add(null, "i am the all mighty");
//			test.delete("u shall laugh");
//			test.writeToFile();
//		}
		
		/*
		 * i am a monkey
i love apples
poop is delicious
u shall laugh
		 */
		
		
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
		
		g.drawImage(new ImageIcon("img/orb.gif").getImage(), 250, 200, 144*2, 143*2, this);
//		g.drawImage(new ImageIcon("img/orb-shatter.gif").getImage(), 400, 400, 167, 149, this);
		
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
		AttributedString atString= new AttributedString("Do a small coloring page today.");
		atString.addAttribute(TextAttribute.FONT, font);
		g.drawString(atString.getIterator(), 50, 600);
		
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
