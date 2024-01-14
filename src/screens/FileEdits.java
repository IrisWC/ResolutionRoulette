package screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import core.Game;
import utilities.FileChanger;
import utilities.PesonalComboBoxUI;

public class FileEdits extends JPanel implements ActionListener{

	private Game mainCore;
	private int w, h;
	private FileChanger[] categories;
	private String[] categoryNames, difficultyNames;
	private JComboBox<String> categoryBox, difficultyBox;
	private FileChanger selected;
	private JTextArea text;
	
	public FileEdits(Game mainCore, int w, int h) {
		super();
		this.mainCore = mainCore;
		this.w = w;
		this.h = h;
		
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
        difficultyBox.setBounds(50, 50, 300, 60);
        difficultyBox.setUI(new PesonalComboBoxUI(Game.font, Game.PAPAYA_WHIP, Game.EMINENCE));
        difficultyBox.addActionListener(this);
        this.add(difficultyBox);
		
		categoryBox = new JComboBox<>(categoryNames);	
		categoryBox.setBounds(450, 50, 300, 60);
//		categoryBox.setBorder(BorderFactory.createEmptyBorder());
//		categoryBox.setOpaque(true);
		categoryBox.setUI(new PesonalComboBoxUI(Game.font, Game.PAPAYA_WHIP, Game.EMINENCE));
		categoryBox.addActionListener(this);
        this.add(categoryBox);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/edit.png").getImage(), 0, 0, w, h, this);
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
//		if(e.getSource() == back) {
//			mainCore.switchScreen("mainScreen");
//		}
	}
	
	public String roll() {
		if (selected == null) {
			selected = new FileChanger("files/clean.txt");
		}
		String contents = selected.readFileContents();
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
		
		return contents;
	}

}
