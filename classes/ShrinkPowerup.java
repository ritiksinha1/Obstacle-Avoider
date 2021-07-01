import java.awt.Color;
import java.awt.Graphics;

public class ShrinkPowerup extends Powerup{

	public ShrinkPowerup(int x, int y) {
		super(x, y, Color.WHITE, 5, 50, 50);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), 30, 30);
	}
	
}
