package application.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Controller implements Runnable, MouseInputListener, KeyListener {
	
	private final int FPS = 60;
	
	private Thread 				thread;
	
	private JPanel 				panel;
	
	public Controller() {
		// Load images
		/*try {
			tankTurretImage	= ImageIO.read(getClass().getResourceAsStream("/tank+turret.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}*/

		thread 		= new Thread(this);
		
		thread.start();
	}

	public void run() {
		while(true) {
		
			try {
				if(panel != null)
					panel.repaint(); //draw

				Thread.sleep(1000/FPS);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) 		{
		int code = e.getKeyCode();
		
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
}
