package Core;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import screens.Easy;

public class Game extends JFrame { //implements ActionListener, WindowListener{
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	private JPanel cardPanel;
	
	private Easy easy;
	
	public Game() {
		super("Mwahahaha");
		setSize(WIDTH, HEIGHT);
		setBounds(200, 0, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		easy = new Easy(this, WIDTH, HEIGHT);
		
		add(cardPanel);
		
		setVisible(true);
		
//		JayLayer sound = new JayLayer("audio/", null, false);
//		sound.addPlayList();
//		sound.addSong(0, "Monplaisir - Soundtrack.mp3");
//		sound.changePlayList(0);
//		sound.nextSong();

	}
	
	public void switchScreen(String panelName) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel, panelName);
		requestFocusInWindow();
		requestFocus();
	}

	
}
