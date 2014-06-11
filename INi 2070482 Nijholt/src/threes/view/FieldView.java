package threes.view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import threes.model.Tile;

@SuppressWarnings("serial")
public class FieldView extends JPanel{
	
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public FieldView(int size) {
		this.setLayout(new GridLayout(size,size));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
}
