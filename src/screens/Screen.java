package screens;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.UIManager;

import core.Game;
import utilities.FileChanger;
import utilities.PesonalComboBoxUI;

public class Screen extends JPanel implements ActionListener {

	private Game mainCore;
	private FileEdits fw;
	private String level;
	private String[] categoryNames, difficultyNames;
	private JComboBox<String> categoryBox, difficultyBox;
	private JButton edit, rollButton;
	private String display, punishment;
	private FileChanger selected;
	
	public Screen(Game mainCore, FileEdits fw) {
		super();
		this.mainCore = mainCore;
		
		this.setBackground(new Color(12,4,43));
		this.setLayout(null);
		
		this.fw = fw;
//		selected = FileChanger();
		
		categoryNames = fw.returnNames();
		difficultyNames = new String[]{"Easy", "Medium", "Hard", "Nightmare"};
		
		display = "Please make your selections";
		punishment = "Then hit \"New Challenge\"";
		
		difficultyBox = new JComboBox<>(difficultyNames);	
        difficultyBox.setBounds(50, 50, 240, 60);
        difficultyBox.setUI(new PesonalComboBoxUI(Game.font, Game.PAPAYA_WHIP, Game.EMINENCE));
        difficultyBox.addActionListener(this);
        this.add(difficultyBox);
		
		categoryBox = new JComboBox<>(categoryNames);	
		categoryBox.setBounds(330, 50, 260, 60);
//		categoryBox.setBorder(BorderFactory.createEmptyBorder());
//		categoryBox.setOpaque(true);
		categoryBox.setUI(new PesonalComboBoxUI(Game.font, Game.PAPAYA_WHIP, Game.EMINENCE));
		categoryBox.addActionListener(this);
        this.add(categoryBox);
        
        edit = new JButton("Edit");
        edit.setFont(Game.font.deriveFont(35f));
        edit.setBounds(630, 50, 120, 60);
        edit.addActionListener(this);
        edit.setBackground(Game.PAPAYA_WHIP);
        edit.setForeground(Game.EMINENCE);
        edit.setOpaque(true);
        edit.setBorderPainted(false);
        this.add(edit);
        
        rollButton = new JButton("New challenge");
        rollButton.setFont(Game.font);
        rollButton.setBounds(200, 480, 400, 60);
        rollButton.addActionListener(this);
        rollButton.setBackground(Game.PAPAYA_WHIP);
        rollButton.setForeground(Game.EMINENCE);
        rollButton.setOpaque(true);
        rollButton.setBorderPainted(false);
        this.add(rollButton);
		
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
		
		g.drawImage(new ImageIcon("img/orb.gif").getImage(), 250, 150, 144*2, 143*2, this);
		
		g.setColor(Game.PAPAYA_WHIP);
		
		centerString(g, new Rectangle(), display, Game.font.deriveFont(30f), 600);
		centerString(g, new Rectangle(), punishment, Game.font.deriveFont(30f), 660);
		
		
//		test.deleteFirstChar();
//		test.add(null, (int)(Math.random() * 10) + "");
//		test.writeToFile();
		
	}
	
	public void centerString(Graphics g, Rectangle r, String s, Font font, int y) {
	    FontRenderContext frc = new FontRenderContext(null, true, true);
	    Rectangle2D r2D = font.getStringBounds(s, frc);
	    int rWidth = (int) Math.round(r2D.getWidth());
	    int a = (800 / 2) - (rWidth / 2);

	    AttributedString atString = new AttributedString(s);
		atString.addAttribute(TextAttribute.FONT, Game.font.deriveFont(30f));
		
	    g.drawString(atString.getIterator(), r.x + a, y);
	}
	
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font, int y) {
		AttributedString atString = new AttributedString(text);
		atString.addAttribute(TextAttribute.FONT, Game.font.deriveFont(30f));
		g.setColor(Game.PAPAYA_WHIP);
		
	    FontMetrics metrics = g.getFontMetrics(font);
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    g.setFont(font);
	    g.drawString(atString.getIterator(), x, y);
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
	
//	public void setUpBox() {
//		categoryBox = new JComboBox<>(categoryNames);	
//		categoryBox.setBounds(450, 50, 300, 60);
//		categoryBox.setUI(new PesonalComboBoxUI(font, PAPAYA_WHIP, EMINENCE));
//		categoryBox.addActionListener(this);
//        this.add(categoryBox);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == categoryBox) {
//			setUpBox();
			String selection = (String)categoryBox.getSelectedItem();
			selected = new FileChanger("files/" + selection + ".txt");
		}
		if(e.getSource() == rollButton) {
			display = roll();
			punishment = rollPunishment();
		}
		if(e.getSource() == edit) {
			mainCore.switchScreen("edit");
		}
	}
	
	public String roll() {
		if (selected == null) {
			selected = new FileChanger("files/clean.txt");
		}
		String contents = selected.readFile();
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
			end = contents.length()-1;
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
		contents = "Task: " + contents;
		
		return contents;
	}
	
	public String rollPunishment() {
		String contents = new FileChanger("files/punishment.txt").readFile();
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
			end = contents.length()-1;
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
		contents = "Punishment: " + contents;
		
		return contents;
	}
	
}
