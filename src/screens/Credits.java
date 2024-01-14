package screens;

import core.Game;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;
import javax.swing.*;

public class Credits extends JPanel implements ActionListener{

	private Game mainCore;
	private JButton backButton;
	private int w, h;
	
	public Credits(Game mainCore, int w, int h) {
		super();
		this.mainCore = mainCore;
		this.w = w;
		this.h = h;
		
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
		
		g.drawImage(new ImageIcon("img/credits.png").getImage(), 0, 0, w, h, this);
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
