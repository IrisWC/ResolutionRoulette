package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import core.Game;
import utilities.FileChanger;
import utilities.PesonalComboBoxUI;

public class FileEdits extends JPanel implements ActionListener{

	private Game mainCore;
	private FileChanger[] categories;
	private String[] categoryNames, difficultyNames;
	private JComboBox<String> categoryBox, difficultyBox;
	private FileChanger selected;
	private JButton confirm, back, done;
	private Font font;
	private JTextArea text;
	private JScrollPane textPane;
	private String textContents;
	
	public FileEdits(Game mainCore) {
		super();
		this.mainCore = mainCore;
		this.setLayout(null);
		
		font = Game.font.deriveFont(30f);
		
		back = new JButton();
		back.setBounds(45, 45, 70, 70);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(this);
		add(back);
		
//		categories = new ArrayList<FileChanger>();
//		categories.add(new FileChanger("files/clean.txt"));
//		categories.add(new FileChanger("files/diet.txt"));
//		categories.add(new FileChanger("files/exercise.txt"));
//		categories.add(new FileChanger("files/mindfulness.txt"));
//		categories.add(new FileChanger("files/new skill.txt"));
//		categories.add(new FileChanger("files/punishment.txt"));
//		categories.add(new FileChanger("files/self-care.txt"));
//		categories.add( new FileChanger("files/social.txt"));
		
		categories = new FileChanger[8];
		categories[0] = new FileChanger("files/clean.txt");
		categories[1] = new FileChanger("files/diet.txt");
		categories[2] = new FileChanger("files/exercise.txt");
		categories[3] = new FileChanger("files/mindfulness.txt");
		categories[4] = new FileChanger("files/new skill.txt");
		categories[5] = new FileChanger("files/self-care.txt");
		categories[6] =  new FileChanger("files/social.txt");
		categories[7] = new FileChanger("files/punishment.txt");
		
		categoryNames = returnNames();
		difficultyNames = new String[]{"Easy", "Medium", "Hard", "Nightmare"};
		
		difficultyBox = new JComboBox<>(difficultyNames);	
        difficultyBox.setBounds(80, 180, 180, 60);
        difficultyBox.setUI(new PesonalComboBoxUI(font, Game.PAPAYA_WHIP, Game.EMINENCE));
        difficultyBox.addActionListener(this);
        this.add(difficultyBox);
		
		categoryBox = new JComboBox<>(categoryNames);	
		categoryBox.setBounds(300, 180, 200, 60);
		categoryBox.setUI(new PesonalComboBoxUI(font, Game.PAPAYA_WHIP, Game.EMINENCE));
		categoryBox.addActionListener(this);
        this.add(categoryBox);
        
        confirm = new JButton("Confirm");
        confirm.setFont(font);
        confirm.setBounds(545, 180, 170, 60);
        confirm.addActionListener(this);
        confirm.setBackground(Game.PAPAYA_WHIP);
        confirm.setForeground(Game.EMINENCE);
        confirm.setOpaque(true);
        confirm.setBorderPainted(false);
        this.add(confirm);
        
        done = new JButton("Done");
        done.setFont(font);
        done.setBounds(320, 690, 150, 60);
        done.addActionListener(this);
        done.setBackground(Game.PAPAYA_WHIP);
        done.setForeground(Game.EMINENCE);
        done.setOpaque(true);
        done.setBorderPainted(false);
        done.setVisible(false);
        this.add(done);
        
        text = new JTextArea();
	    text.setLineWrap(true);
	    text.setWrapStyleWord(true);
	    text.setBackground(Game.PAPAYA_WHIP);
	    text.setFont(font.deriveFont(20f));
	    text.setForeground(Game.EMINENCE);
	    textPane = new JScrollPane(text,
	              ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	              ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    textPane.setBounds(100, 280, 600, 370);
	    textPane.setVisible(false);
		this.add(textPane);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/edit.png").getImage(), 0, 0, Game.WIDTH, Game.IMG_HEIGHT, this);
	}
	
	public String[] returnNames() {
		String[] categoryNames = new String[7];
		for (int i = 0; i < categoryNames.length; i++) {
			categoryNames[i] = categories[i].toString();
		}
		return categoryNames;
	}
	
//	public Vector<String> returnNames() {
//		Vector<String> categoryNames = new Vector<String>();
//		for (int i = 0; i < categories.size(); i++) {
//			if (!categories.get(i).toString().equals("punishment"))
//					categoryNames.add(categories.get(i).toString());
//		}
//		return categoryNames;
//	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == categoryBox) {
//			setUpBox();
			String selection = (String)categoryBox.getSelectedItem();
			selected = new FileChanger("files/" + selection + ".txt");
		}
		if(e.getSource() == confirm) {
			setTextBox();
		}
		if (e.getSource() == done) {
			saveEdits();
		}
		if(e.getSource() == back) {
			mainCore.switchScreen("mainScreen");
		}
	}
	
	public void setTextBox() {
		textContents = roll();
		
		done.setVisible(true);
	    text.setText(textContents);
		textPane.setVisible(true);
	}
	
	public void saveEdits() {
		selected.add(textContents, text.getText());
		selected.writeToFile();
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
		
		return contents;
	}

}
