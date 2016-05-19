


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends Menu implements ActionListener
	{
	private int width = 1080;
	private int height = 768;
	private boolean perspective;
	private Image img, archer, unicorn, dragon, archerselected, unicornselected, dragonselected;
	private int state = 0;
	private int playerID;
	
		public Main()
		{
			new Timer(1000/60, this).start();
			
			try {
				img = ImageIO.read(new File("Data\\Playerchoise\\Playerchoise_background.png"));
				archer = ImageIO.read(new File("Data\\Playerchoise\\archer.png"));
				unicorn = ImageIO.read(new File("Data\\Playerchoise\\unicorn.png"));
				dragon = ImageIO.read(new File("Data\\Playerchoise\\dragon.png"));
				archerselected = ImageIO.read(new File("Data\\Playerchoise\\archer_selected.png"));
				unicornselected = ImageIO.read(new File("Data\\Playerchoise\\unicorn_selected.png"));
				dragonselected = ImageIO.read(new File("Data\\Playerchoise\\dragon_selected.png"));
				img = img.getScaledInstance(width, height, Image.SCALE_FAST);
			} catch (IOException e) {
				System.exit(0);
			}
	        
			JPanel buttons = new JPanel(new GridLayout(3, 1));
			buttons.add(new JLabel("hoi"));
		}
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaint();	
		}
		
		public void draw(Graphics2D g2d)
		{
			g2d.setFont(new Font("Verdana", Font.PLAIN, 30));
			g2d.drawImage(img , 0, 0, null);
			g2d.drawString("Choose your character player 1", 250, 100);
			if(state == 0)
				g2d.drawImage(dragonselected , 50, 300, null);
			else	
				g2d.drawImage(dragon , 50, 300, null);
			if(state == 1)
				g2d.drawImage(unicornselected , 350, 303, null);
			else
				g2d.drawImage(unicorn , 350, 303, null);
			if(state == 2)
				g2d.drawImage(archerselected , 650, 295, null);		
			else
				g2d.drawImage(archer , 650, 295, null);		

		}

		public void goRight()
		{
			if(state+1 == 3)
				state = 0;
			else
				state++;
		}
		
		public void goLeft()
		{
			if(state-1 == -1)
				state = 2;
			else
				state--;
		}
		
}
