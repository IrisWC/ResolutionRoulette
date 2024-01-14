package screens;

import core.Game;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class Credits extends JPanel implements ActionListener{

	private Game mainCore;
	private JButton backButton;
	
	public Credits(Game mainCore) {
		super();
		this.mainCore = mainCore;
		
		setLayout(null);
		
		backButton = new JButton();
		backButton.setBounds(43, 43, 75, 75);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.addActionListener(this);
		add(backButton);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/credits.png").getImage(), 0, 0, Game.WIDTH, Game.IMG_HEIGHT, this);
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
		if(e.getSource() == backButton) {
			mainCore.switchScreen("menu");
		}
	}
}
