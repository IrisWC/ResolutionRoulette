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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import core.Game;
import fileStuff.FileChanger;
import fileStuff.FilesWindow;

public class Screen extends JPanel implements ActionListener {

	private Game mainCore;
	private FilesWindow fw;
	private String level;
	private String[] categoryNames, difficultyNames;
	private JComboBox<String> categoryBox, difficultyBox;
	private JButton rollButton;
	private String display;
	private FileChanger test;
	
	public Screen(Game mainCore, FilesWindow fw, String level) {
		super();
		this.mainCore = mainCore;
		this.level = level;
		
		this.setBackground(new Color(230,190,200));
		this.setLayout(null);
		
		this.fw = fw;
		categoryNames = fw.returnNames();
		difficultyNames = new String[]{"Easy", "Medium", "Hard", "Nightmare"};
		
		display = "Please make your selections";
        
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PixelifySans-VariableFont_wght.ttf")).deriveFont(48f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		categoryBox = new JComboBox<>(categoryNames);	
		categoryBox.setFont(font);
		categoryBox.setBounds(250, 50, 300, 60);
		categoryBox.setBackground(new Color(65, 31, 78));
		categoryBox.setOpaque(true);
		categoryBox.setForeground(new Color(200, 200, 200));
		categoryBox.addActionListener(this);
        this.add(categoryBox);
        
        difficultyBox = new JComboBox<>(difficultyNames);	
        difficultyBox.setFont(font);
        difficultyBox.setBounds(250, 125, 300, 60);
        difficultyBox.setBackground(new Color(65, 31, 78));
        difficultyBox.setOpaque(true);
        difficultyBox.setForeground(new Color(200, 200, 200));
        difficultyBox.addActionListener(this);
        this.add(difficultyBox);
        
        rollButton = new JButton("New challenge");
        rollButton.setFont(font);
        rollButton.setBounds(200, 650, 400, 60);
        rollButton.addActionListener(this);
        rollButton.setBackground(new Color(65, 31, 78));
        rollButton.setForeground(new Color(200, 200, 200));
        this.add(rollButton);
		
		test = new FileChanger("files/test.txt");
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
//		AttributedString atString= new AttributedString("Do a small coloring page today.");
//		atString.addAttribute(TextAttribute.FONT, font);
//		g.drawString(atString.getIterator(), 50, 600);
		
		AttributedString atString = new AttributedString(display);
		atString.addAttribute(TextAttribute.FONT, font);
		g.drawString(atString.getIterator(), 60, 600);

		
//		test.deleteFirstChar();
//		test.add(null, (int)(Math.random() * 10) + "");
//		test.writeToFile();
		
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
		if(e.getSource() == categoryBox) {
			String selection = (String)categoryBox.getSelectedItem();
			test = new FileChanger("files/" + selection + ".txt");
		}
		if(e.getSource() == rollButton) {
			display = roll();
		}
	}
	
	public String roll() {
		String contents = test.readFileContents();
		int start = 0; 
		int end = 0;
		if(((String)difficultyBox.getSelectedItem()).equals(difficultyNames[0])) {
			start = contents.indexOf("EASY") + 5;
			end = contents.indexOf("MEDIUM") - 1;
		}
		else if(((String)difficultyBox.getSelectedItem()).equals(difficultyNames[1])) {
			start = contents.indexOf("MEDIUM") + 7;
			end = contents.indexOf("HARD") - 1;
		}
		else if(((String)difficultyBox.getSelectedItem()).equals(difficultyNames[2])) {
			start = contents.indexOf("HARD") + 5;
			end = contents.indexOf("NIGHTMARE") - 1;
		}
		else if(((String)difficultyBox.getSelectedItem()).equals(difficultyNames[3])) {
			start = contents.indexOf("NIGHTMARE") + 10;
			end = contents.length();
		}
		contents = contents.substring(start, end);
		contents = contents.trim();
		
		if(contents.length() == 0) {
			return "No options available";
		}
		
		int numOptions = 0;
		contents = contents + "\n";
		for(int i = 0; i < contents.length(); i++) {
			if(contents.charAt(i) == '\n')
				numOptions++;
		}

		int optionNum = (int)(Math.random() * numOptions);
		for(int i = 0; i < optionNum; i++) {
			contents = contents.substring(contents.indexOf('\n') + 1);
		}
		contents = contents.substring(0, contents.indexOf('\n'));
		
		return contents;
	}
	
}
