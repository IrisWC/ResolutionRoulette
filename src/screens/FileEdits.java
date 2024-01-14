package screens;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.Game;
import utilities.FileChanger;

public class FileEdits extends JPanel implements ActionListener{

	private Game mainCore;
	private int w, h;
	private ArrayList<FileChanger> categories;
	
	public FileEdits(Game mainCore, int w, int h) {
		super();
		this.mainCore = mainCore;
		this.w = w;
		this.h = h;
		
		categories = new ArrayList<FileChanger>();
		categories.add(new FileChanger("files/clean.txt"));
		categories.add(new FileChanger("files/diet.txt"));
		categories.add(new FileChanger("files/exercise.txt"));
		categories.add(new FileChanger("files/mindfulness.txt"));
		categories.add(new FileChanger("files/new skill.txt"));
		categories.add(new FileChanger("files/punishment.txt"));
		categories.add(new FileChanger("files/self-care.txt"));
		categories.add( new FileChanger("files/social.txt"));
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/edit.png").getImage(), 0, 0, w, h, this);
	}
	
	public Vector<String> returnNames() {
		Vector<String> categoryNames = new Vector<String>();
		for (int i = 0; i < categories.size(); i++) {
			if (!categories.get(i).toString().equals("punishment"))
					categoryNames.add(categories.get(i).toString());
		}
		return categoryNames;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
