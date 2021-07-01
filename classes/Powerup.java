import java.awt.Color;

public abstract class Powerup extends Enemy{
	
	public Powerup(int x, int y, Color color, double vx, int width, int height) {
		super(x, y, vx, width, height);
		this.setColor(color);
	}

	

	
	
}
