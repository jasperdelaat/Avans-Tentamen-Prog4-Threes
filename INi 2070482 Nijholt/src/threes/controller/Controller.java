package threes.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import threes.model.Board;
import threes.model.Tile;
import threes.view.GUI;

public class Controller implements MouseInputListener, KeyListener {
	
	private GUI						frame;
	private HashMap<Integer, Color>	tileColor = new HashMap<Integer, Color>();
	private HashMap<Integer, Color>	textColor = new HashMap<Integer, Color>();
	private ActionAdapter 			aa = new ActionAdapter();
	private Board					b;
	private final int				maximum = 10, minimum = 2;
	private JMenuItem				save,
									load,
									restart,	
									change,
									exit;
	private JFileChooser 			myFileChooser = new JFileChooser();
	
	public Controller() {
		this.b = new Board();
		this.frame = new GUI("Threes", b.getSize());
		this.frame.setLoadingCursor(true);
		this.createMenu();
		this.playSound("music.wav", true);
		this.fillMaps();
		this.frame.getField().setTiles(b.getTiles());
		
		// Load images
		/*try {
			tankTurretImage	= ImageIO.read(getClass().getResourceAsStream("/tank+turret.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}*/
		frame.addMouseMotionListener(this);
		frame.addMouseListener(this);
		this.frame.setLoadingCursor(false);
	}
	
	public void fillMaps(){
		this.tileColor.put(1, Color.BLUE);
		this.tileColor.put(2, Color.RED);
		this.tileColor.put(3, Color.WHITE);
		this.tileColor.put(6, Color.WHITE);
		this.textColor.put(1, Color.BLACK);
		this.textColor.put(2, Color.BLACK);
		this.textColor.put(3, Color.BLACK);
		this.textColor.put(6, Color.PINK);
	}
	
	private void restart() {
		b = new Board(4);
	}
	private void restart(int size) {
		b = new Board(size);
	}
	private void save() {
		int result = myFileChooser.showSaveDialog(frame);
		if (result == JFileChooser.APPROVE_OPTION) {
			File targetFile = myFileChooser.getSelectedFile();

			try {
				if (!targetFile.exists()) {
					targetFile.createNewFile();
				}
				FileWriter fw = new FileWriter(targetFile);
				for(Tile t: b.getTiles()){
					fw.write(t.getX_coordination() + " " + t.getY_coordination() + " " + t.getValue());
				}
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();	
			}
		}
	}
	private void load() {
		int result = myFileChooser.showOpenDialog(frame);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				Path path = Paths.get(myFileChooser.getSelectedFile().toURI());
				for (String s : Files.readAllLines(path,StandardCharsets.UTF_8)) {
//					tiles.add(new Tile(0,0,0));
//					content = content + s + "\n";
				}
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
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
	public void mouseClicked(MouseEvent e) 	{}
	public void mouseEntered(MouseEvent e) 	{}
	public void mouseExited(MouseEvent e) 	{}
	public void mousePressed(MouseEvent e) 	{}
	public void mouseReleased(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
	// menu's maken en initializeren
	private void createMenu(){
		JMenuBar 	myMenuBar 	= new JMenuBar();
		JMenu		optionMenu 	= new JMenu("Options");

		save 		= new JMenuItem("Save");
		load 		= new JMenuItem("Load");
		restart		= new JMenuItem("Restart");
		change		= new JMenuItem("Change size");
		exit		= new JMenuItem("Exit");
			
		frame.setJMenuBar(myMenuBar);
		myMenuBar.add(optionMenu);
		optionMenu.add(load);
		optionMenu.add(save);
		optionMenu.add(restart);
		optionMenu.add(change);
		optionMenu.add(exit);
		
		change.addActionListener(aa);
		restart.addActionListener(aa);
		exit.addActionListener(aa);	
		load.addActionListener(aa);
		save.addActionListener(aa);
		frame.revalidate();
	}
	
	class ActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(exit))
				System.exit(0);
			if(e.getSource().equals(restart))
				restart();
			if(e.getSource().equals(save))
				save();
			if(e.getSource().equals(load))
				load();
			if(e.getSource().equals(change)){
				
				// TODO: Redo this
				
				int size = 0;
				String sizetext = JOptionPane.showInputDialog("How big would you like the field to be? \nMaximum of 10 and minumum of 2", "4");
				try{
					size = Integer.parseInt(sizetext);
				} catch(NumberFormatException ne){
					System.err.print("Errored on parsing interger for field");
					ne.printStackTrace();
				}
				if(size <= minimum && size >= maximum)
					restart(size);
				else{
					JOptionPane.showMessageDialog(null, "You entered a invalid text, field was set to default of 4.", "Failed", JOptionPane.INFORMATION_MESSAGE);
					restart();
				}
			}
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
