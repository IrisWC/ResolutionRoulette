package screens;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Game;
import utilities.FileChanger;
import utilities.PesonalComboBoxUI;

public class FileEdits extends JPanel implements ActionListener{

	private Game mainCore;
	private int w, h;
	private FileChanger[] categories;
	private String[] categoryNames, difficultyNames;
	private JComboBox<String> categoryBox, difficultyBox;
	
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
		
	}

}
