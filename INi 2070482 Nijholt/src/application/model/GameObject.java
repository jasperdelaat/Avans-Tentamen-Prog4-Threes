package application.model;

public abstract class GameObject {

	private int 			x_coordination,
							y_coordination;
	private Boolean			solid;
	
	public GameObject( int x, int y, boolean so) {
		this.setX_coordination(x);
		this.setY_coordination(y);
		this.setSolid(so);
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

	public Boolean getSolid() {
		return solid;
	}

	public void setSolid(Boolean solid) {
		this.solid = solid;
	}
}
