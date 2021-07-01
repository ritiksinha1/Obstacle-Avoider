import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public abstract class Enemy extends Component{

	private int x;
	private int y;
	private double vx;
	private Color color;
	private int width, height;
	
	public Enemy(int x, int y, double vx, int width, int height) {
		this.x = x;
		this.y = y;
		this.color = Color.BLUE;
		this.vx = vx;
		this.width = width;
		this.height = height;
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	
	public void move() {
		this.x -= vx;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int width() {
		return this.width;
	}
	
	public int height() {
		return this.height;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setVx(int vx) {
		this.vx = vx;
	}
	

	
}
