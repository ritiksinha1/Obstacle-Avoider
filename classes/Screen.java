import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JPanel implements MouseListener{
	
	private JFrame frame;
	private Ball ball;
	private List<Enemy> enemies;
	
	public Screen(JFrame frame) throws IOException {
		this.frame = frame;
		frame.getContentPane().add(this);
		frame.setResizable(false);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		ball = new Ball(20, 50, 30, 30);
		this.add(ball);
		enemies = new ArrayList<Enemy>();
		frame.setVisible(true);
		this.setFocusable(true);
		this.addMouseListener(this);
		enemies.add(new BasicEnemy(frame.getWidth()-50, (int)(Math.random()*200) + 200, 50, 5));
		frame.repaint();
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		frame.toFront();
		g.setColor(Color.GRAY);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString("" + ball.getScore(), 300, 250);
		g.drawRect(ball.getsX(), ball.getY(), ball.getsWidth(), 500);
		ball.paintComponent(g);
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).paintComponent(g);
			if(enemies.get(i).getX() <= -20) enemies.remove(i);
		}
		
		if(ball.collided) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("GAME OVER", this.getWidth()/2-100, this.getHeight()/2);
			g.drawString("Score: " + ball.getScore(), this.getWidth()/2-70, this.getHeight()/2+50);
			this.add(new JButton("X"));
			frame.setVisible(true);
		
		}
	
	}
	
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public Ball getBall() {
		return this.ball;
	}

	public List<Enemy> getEnemiesList() {
		return this.enemies;
	}
	
	public void mousePressed(MouseEvent e) {
		if(!(ball.getsY() >= 440))ball.slowDown();
	}


	public void mouseReleased(MouseEvent e) {
		ball.speedUp();
	}

	
	public void addBasicEnemy() {
		enemies.add(new BasicEnemy(550, (int)(Math.random()*400), 50, 5));
		this.add(enemies.get(enemies.size()-1));
	}
	
	public void addFastEnemy() {
		enemies.add(new BasicEnemy(550, (int)(Math.random()*400), 30, 10));
		this.add(enemies.get(enemies.size()-1));
	}
	
	public void addSlowEnemy() {
		enemies.add(new BasicEnemy(550, (int)(Math.random()*400), 60, 3));
		this.add(enemies.get(enemies.size()-1));
	}
	
	public void add2Powerup() {
		enemies.add(new Add2Powerup(550,(int)(Math.random()*500)));
	}
	
	public void addShrinkPowerup() {
		enemies.add(new ShrinkPowerup(550, (int)(Math.random()*500)));
	}
	

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}




	



}
