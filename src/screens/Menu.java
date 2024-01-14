package screens;

import core.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener{
	
	private Game mainCore;
	private JButton start, credits;
	
	public Menu(Game mainCore) {
		super();
		this.mainCore = mainCore;
		
		setLayout(null);
		
		start = new JButton();
		start.setBounds(195, 490, 410, 96);
		start.setOpaque(false);
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.addActionListener(this);
		add(start);
		
		credits = new JButton();
		credits.setBounds(195, 635, 410, 96);
		credits.setOpaque(false);
		credits.setContentAreaFilled(false);
		credits.setBorderPainted(false);
		credits.addActionListener(this);
		add(credits);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/menu.gif").getImage(), 0, 0, Game.WIDTH, Game.IMG_HEIGHT, this);
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
		if(e.getSource() == start) {
			mainCore.switchScreen("mainScreen");
		}
		if(e.getSource() == credits) {
			mainCore.switchScreen("credits");
		}
		
	}
}
