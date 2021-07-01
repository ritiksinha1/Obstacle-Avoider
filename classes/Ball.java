import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

public class Ball extends Component{

	private int x;
	private int y;
	private int width;
	private int height;
	private int vy;
	boolean collided;
	private int score;
	
	public Ball(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		vy = 10;
		collided = false;
		score = 0;
	}
	
	public void paintComponent(Graphics g) {
		((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

	
	public void move(List<Enemy> enemies) {
		y+=vy;
		if(y + this.height/2 >= 450) {
			vy = -Math.abs(vy);
			this.score++;
		}
		if(y <= 0) {
			vy = Math.abs(vy);
			this.score++;
		}
		
		
		for(int i = 0; i < enemies.size(); i++) {
			if(checkCollision(enemies, i) == true) {	
				if(enemies.get(i) instanceof Add2Powerup) {
					this.score++;
					enemies.remove(i);
				}
				
				else if(enemies.get(i) instanceof ShrinkPowerup) {
					this.width = 10;
					this.height=10;
				}
				
				else {
					collided = true;
				}
				
				
			}
		}
		
}
	
	
	public void slowDown() {
		if(this.vy > 0) this.vy = 5;
		else this.vy = -5;
		this.height = 40;
		this.width = 40;
	}
	
	public void speedUp() {
		if(this.vy > 0) this.vy = 10;
		else this.vy = -10;
		this.height = 30;
		this.width = 30;
	}

	
	
	public int getsX() {
		return this.x;
	}
	
	public int getsY() {
		return this.y;
	}
	
	public int getsWidth() {
		return this.width;
	}
	
	public void setX(int i) {
		x  = i;
	}
	
	public void setVy(int vy) {
		this.vy = vy;
	}
	
	public int getVy() {
		return this.vy;
	}
	
	public boolean getCollide() {
		return this.collided;
	}

	public int getScore() {
		return this.score;
	}
	
	public void setRadius (int height) {
		this.height = height;
	}
	
	public boolean checkCollision(List<Enemy> enemies, int index) {
	
			if((this.x + this.width >= enemies.get(index).getX() && this.x <= enemies.get(index).getX() + enemies.get(index).width()) && 
				(this.y <= enemies.get(index).getY()+enemies.get(index).height() 
						&& this.y + this.height >= enemies.get(index).getY())) {
				return true;
			}
		return false;
	}
	
	
	   
}
