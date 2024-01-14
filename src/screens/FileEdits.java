package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import utilities.FileChanger;

public class FileEdits extends JFrame implements ActionListener{

	private ArrayList<FileChanger> categories;
	
	public FileEdits() {
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
	
	public Vector<String> returnNames() {
		Vector<String> categoryNames = new Vector<String>();
		for (int i = 0; i < categories.size(); i++) {
			categoryNames.add(categories.get(i).toString());
		}
		return categoryNames;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
