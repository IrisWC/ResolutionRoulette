package core;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import screens.FileEdits;
import screens.Screen;
import screens.Menu;
import screens.Credits;

public class Game extends JFrame { //implements ActionListener, WindowListener{
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 825;
	
	public static final int IMG_HEIGHT = 800;
	
	public static final Color PAPAYA_WHIP = new Color(255, 236, 206);
	public static final Color EMINENCE = new Color(91, 58, 124);
	public static Font font;
	
	private JPanel cardPanel;
	private FileEdits edit;
	private Screen mainScreen;
	private Menu menu;
	private Credits credits;
	
	public Game() {
		super("Resolution Roulette");
		
		ImageIcon img = new ImageIcon("img/orb-frame1.png");
		setIconImage(img.getImage());
		
		setSize(WIDTH, HEIGHT);
		setBounds(100, 0, WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PixelifySans-VariableFont_wght.ttf")).deriveFont(40f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		menu = new Menu(this);
		edit = new FileEdits(this);
		mainScreen = new Screen(this, edit);
		credits = new Credits(this);
		
//		cardPanel.add(menu, "menu");
		cardPanel.add(edit, "edit");
		cardPanel.add(mainScreen, "mainScreen");
		cardPanel.add(credits, "credits");
		
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
