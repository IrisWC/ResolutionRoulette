package fileStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class FilesWindow extends JFrame implements ActionListener{

	private FileChanger[] categories;
	
	public FilesWindow() {
		categories = new FileChanger[8];
		categories[0] = new FileChanger("files/clean.txt");
		categories[1] = new FileChanger("files/diet.txt");
		categories[2] = new FileChanger("files/exercise.txt");
		categories[3] = new FileChanger("files/mindfulness.txt");
		categories[4] = new FileChanger("files/new skill.txt");
		categories[5] = new FileChanger("files/punishment.txt");
		categories[6] = new FileChanger("files/self-care.txt");
		categories[7] = new FileChanger("files/social.txt");
		
	}
	
	public String[] returnNames() {
		String[] categoryNames = new String[8];
		for (int i = 0; i < categories.length; i++) {
			categoryNames[i] = categories[i].toString();
		}
		return categoryNames;
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
