package threes.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import threes.model.Tile;

public class Controller implements MouseInputListener, KeyListener {
	
	private JFrame					frame;
	private JPanel 					panel;
	private HashMap<Integer, Color>	tileColor;
	private HashMap<Integer, Color>	textColor;
	private ActionAdapter 			aa = new ActionAdapter();
	private ArrayList<Tile> 		tiles;
	
	public Controller(JFrame f) {
		this.frame = f;
		
		this.createMenu();
//		this.playSound("music.wav", true);
		
		// Load images
		/*try {
			tankTurretImage	= ImageIO.read(getClass().getResourceAsStream("/tank+turret.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void fillMaps(){
		this.tileColor.put(1, Color.BLUE);
		this.tileColor.put(2, Color.RED);
		this.tileColor.put(3, Color.WHITE);
		this.tileColor.put(6, Color.WHITE);
		this.textColor.put(1, Color.BLACK);
		this.textColor.put(2, Color.BLACK);
		this.textColor.put(3, Color.BLACK);
		this.textColor.put(6, Color.BLACK);
	}
	
	private void restart() {
		// TODO Auto-generated method stub
	}
	private void save() {
		// TODO Auto-generated method stub
	}
	private void load() {
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) 		{
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP)
			move("up");
		if(code == KeyEvent.VK_LEFT)
			move("left");
		if(code == KeyEvent.VK_DOWN) 
			move("down");
		if(code == KeyEvent.VK_RIGHT) 
			move("right");
		
	}

	private void move(String string) {
//		panel.changetext(string);
	}

	public void keyReleased(KeyEvent e) 	{
		int code = e.getKeyCode();
		
	}
	
	public void keyTyped(KeyEvent e) 		{}

	public void mouseClicked(MouseEvent e) 	{
		
	}

	public void mouseEntered(MouseEvent e) 	{}
	public void mouseExited(MouseEvent e) 	{}
	public void mousePressed(MouseEvent e) 	{}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
	public void setPanel(JPanel panel) {
		panel.addMouseMotionListener(this);
		panel.addMouseListener(this);
		this.panel = panel;
	}
	
	// menu's maken en initializeren
	private void createMenu(){
		JMenuBar 	myMenuBar 	= new JMenuBar();
		JMenu		optionMenu 	= new JMenu("Options");

		JMenuItem	save 		= new JMenuItem("Save");
		JMenuItem	load 		= new JMenuItem("Load");
		JMenuItem	restart		= new JMenuItem("Restart");
		JMenuItem	exit		= new JMenuItem("Exit");
			
		frame.setJMenuBar(myMenuBar);
		myMenuBar.add(optionMenu);
		optionMenu.add(load);
		optionMenu.add(save);
		optionMenu.add(restart);
		optionMenu.add(exit);
		
		restart.addActionListener(aa);
		exit.addActionListener(aa);	
		load.addActionListener(aa);
		save.addActionListener(aa);
		frame.revalidate();
	}
	
	class ActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals("exit"))
				System.exit(0);
			if(e.getSource().equals("restart"))
				restart();
			if(e.getSource().equals("save"))
				save();
			if(e.getSource().equals("load"))
				load();
		}
	}
	
	public void playSound(String filename, boolean shouldLoop) {
		try {
	         // Open an audio input stream.
	         URL url = this.getClass().getClassLoader().getResource(filename);
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         // Get a sound clip resource.
	         Clip clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         clip.open(audioIn);
	         if (shouldLoop)
	        	clip.loop(Clip.LOOP_CONTINUOUSLY);
			else
				clip.start();
				
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }
	
}
