package application.view;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GUI extends JFrame{

	public final int 		WIDTH 	= 1000;
	public final int 		HEIGHT 	= 600;
	public final String 	TITLE 	= "CHANGE ME IN GUI";
	
	public GUI(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle(TITLE);
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
