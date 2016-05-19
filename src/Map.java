import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Map 
{
	private int x = 0;
	private int width = 30000;
	private int height = 768;
	private boolean perspective;
	private Image img;
	protected Physics phys;

	
	public Map()
	{
		phys = new Physics();
		try {
			img = ImageIO.read(new File("Data\\background.png"));
			img = img.getScaledInstance(width, height, Image.SCALE_FAST);
		} catch (IOException e) {
			System.exit(0);
		}
		
	}

	public void draw(Graphics2D g2d) 
	{
		g2d.drawImage(img , x, 0, null);
		x--;
		phys.draw(g2d);
		

	}

	public void setPerspective(boolean perspective) 
	{

	}

	public boolean isPerspective() 
	{
		return false;
	}

}
