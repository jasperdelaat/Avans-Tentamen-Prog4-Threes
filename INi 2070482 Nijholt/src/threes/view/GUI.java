package threes.view;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GUI extends JFrame{

	private final int		SCALE	= 1;
	private final int 		WIDTH 	= 700;
	private final int 		HEIGHT 	= 1000;
	private JPanel			screen = new JPanel();
	
	public GUI(String title){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(this.WIDTH*SCALE, this.HEIGHT*SCALE));
		this.setResizable(false);
		this.setTitle(title);
		this.setContentPane(new JPanel());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		init();
	}
	
	private void init(){
		screen.add(new FieldView());
		screen.add(new Statistics());
		this.setContentPane(screen);
	}
	
	public void setLoadingCursor(boolean loading){
		if(loading) 
			this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
		else 
			this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
}
