package screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Core.Game;

public class Easy extends JPanel implements ActionListener {

	private Game mainCore;
	
	public Easy(Game mainCore, int width, int height) {
		super();
		this.mainCore = mainCore;
	}
	
	public void run() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
