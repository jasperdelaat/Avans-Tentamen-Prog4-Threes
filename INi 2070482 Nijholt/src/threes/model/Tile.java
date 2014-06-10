package threes.model;

import java.util.Random;

public abstract class Tile {

	private int x_coordination, 
				y_coordination, 
				value;

	public Tile(int x, int y, int v) {
		this.setX_coordination(x);
		this.setY_coordination(y);
		this.setValue(v);
	}

	public Tile(int x, int y) {
		this.setX_coordination(x);
		this.setY_coordination(y);
		
		Random r1 = new Random();
		int v = r1.nextInt(3) + 1;
		
		this.setValue(v);
	}

	public int getX_coordination() {
		return x_coordination;
	}

	public void setX_coordination(int x_coordination) {
		this.x_coordination = x_coordination;
	}

	public int getY_coordination() {
		return y_coordination;
	}

	public void setY_coordination(int y_coordination) {
		this.y_coordination = y_coordination;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
