import java.io.IOException;

import javax.swing.JFrame;

public class Coordinator { 

	public static void main(String[] args) throws InterruptedException, IOException {		
		int frameX = 100;
		int frameY = 50;
		int frameWidth = 600;
		int frameHeight = 500;
		
		JFrame frame = new JFrame();
		frame.setBounds(frameX, frameY, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Screen screen = new Screen(frame);	
		int counter = 0;
		
		while(true) {
			screen.repaint();
			screen.getBall().move(screen.getEnemiesList());
			for(int i = 0; i < screen.getEnemiesList().size(); i++) {
				screen.getEnemiesList().get(i).move();
			}
			screen.repaint();
			Thread.currentThread().sleep(35);
			if(System.currentTimeMillis()%(200-counter) == 0) screen.addSlowEnemy();
			if(System.currentTimeMillis()%(100-counter) == 0)screen.addBasicEnemy();
			if(System.currentTimeMillis()%(150-counter) == 0)screen.addFastEnemy();
			if(System.currentTimeMillis()%200 == 0) screen.add2Powerup();
			if(System.currentTimeMillis() % 300 ==0 && screen.getBall().getsWidth() >=30) screen.addShrinkPowerup();
			if(System.currentTimeMillis() % 2500 == 0) counter++;
		
			
			if(screen.getBall().getCollide() == true) {
				Thread.currentThread().sleep(5000);
				frame.getContentPane().removeAll();
				screen = new Screen(frame);
			}
			
			
		}
		
			
		
		
		}
	
	
	
	
	}
