package threes.model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import threes.model.Tile;

public class Board{

	private int 			size;
	private ArrayList<Tile> tiles = new ArrayList<Tile>();

	public Board() {
		this.setSize(4);
		init();
	}

	public Board(int size){
		this.setSize(size);
		init();
	}
	public Board(int size, ArrayList<Tile> tiles){
		this.setSize(size);
		this.tiles = tiles;
	}

	private void init() {
		for(int i = 0; i < 7; i++){
			Random r1 = new Random();
			Tile t = new Tile(r1.nextInt(size), r1.nextInt(size));
			for(Tile tile : tiles){
				if(!(tile.getX_coordination() == t.getX_coordination() && tile.getY_coordination() == t.getY_coordination())){
					tiles.add(t);
				}
			}
		}
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	public void addTile(Tile t){
		tiles.add(t);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
