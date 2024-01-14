package screens;

import core.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel implements ActionListener{
	
	private Game mainCore;
	private JButton start, credits;
	private int w, h;
	
	public Menu(Game mainCore, int w, int h) {
		super();
		this.mainCore = mainCore;
		this.w = w;
		this.h = h;
		
		setLayout(null);
		
		start = new JButton();
		start.setBounds(332, 502, 386, 94);
//		start.setOpaque(false);
//		start.setContentAreaFilled(false);
//		start.setBorderPainted(false);
		start.addActionListener(this);
		add(start);
		
		credits = new JButton();
		credits.setBounds(582, 648, 386, 94);
//		creditsButton.setOpaque(false);
//		creditsButton.setContentAreaFilled(false);
//		creditsButton.setBorderPainted(false);
		credits.addActionListener(this);
		add(credits);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(new ImageIcon("img/menu.png").getImage(), 0, 0, w, h, this);
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
