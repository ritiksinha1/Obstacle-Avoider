import java.awt.Color;
import java.awt.Graphics;

public class Add2Powerup extends Powerup{

	public Add2Powerup(int x, int y) {
		super(x, y, Color.GRAY, 5, 50, 50);
	}
	

	public void paintComponent(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), 30, 30);
	}


	
	
	
}
