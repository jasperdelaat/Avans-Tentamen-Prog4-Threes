package application.view;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GUI extends JFrame{

	public final int 		WIDTH 	= 1600;
	public final int 		HEIGHT 	= 900;
	
	public GUI(String title){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
		this.setResizable(false);
		this.setTitle(title);
		this.setContentPane(new JPanel());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void setLoadingCursor(boolean loading){
		if(loading) 
			this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
		else 
			this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
}
