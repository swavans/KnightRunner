import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import net.phys2d.math.Vector2f;
import net.phys2d.raw.Body;
import net.phys2d.raw.StaticBody;
import net.phys2d.raw.World;
import net.phys2d.raw.shapes.Box;
import net.phys2d.raw.strategies.QuadSpaceStrategy;

public class Physics 
{
	private int X;
	private int Y;
	private int size = 768;
	private int width = 500000000;
	
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int LEFT = 3;
	private static final int DOWN = 4;
	
	protected World myWorld = new World(new Vector2f(0.0f,10.0f),10,new QuadSpaceStrategy(20, 3));
	
	private Body floor1, floor2, wall1, wall2, wall3, wall4, player1, player2, player3, testBullet;
	
	public Physics()
	{	
		myWorld.clear();
		myWorld.setGravity(0, 10f);
		
		//Wall1 top wall
		wall1 = new StaticBody(new Box((float)width,(float)5));
		wall1.setPosition(0, 0);
		//wall2 right wall
		wall2 = new StaticBody(new Box((float)10,(float)width));
		wall2.setPosition(1013, 0);
		//wall3 down wall
		wall3 = new StaticBody(new Box((float)width,(float)1));
		wall3.setPosition(0, 730);
		//wall4 left wall
		wall4 = new StaticBody(new Box((float)1,(float)width));
		wall4.setPosition(0, 0);
		
		floor1 = new StaticBody("floor1", new Box((float)width,(float)1));
		floor1.setPosition(0, (size/3)*2);
		
		floor2 = new StaticBody("floor2", new Box((float)width,(float)1));
		floor2.setPosition(0, (size/3)*1);
		
		player1 = new Body("Ridder", new Box(50.0f, 50.0f), 10.0f);
		player1.setPosition(500, ((size/3)*1)+50);
		player1.setRestitution(1.0f);
		player1.setFriction(1.0f);
		
		player2 = new StaticBody("Draak", new Box(50.0f, 50.0f));
		player2.setPosition(500, 50);
		player2.setRestitution(1.0f);
		player2.setFriction(1.0f);
		
		player3 = new Body("Eenhoorn", new Box(50.0f, 50.0f), 10.0f);
		player3.setPosition(500, ((size/3)*2)+50);
		player3.setRestitution(1.0f);
		player3.setFriction(1.0f);
		
		testBullet = new Body("Test", new Box(25.0f, 25.0f), 5.0f);
		testBullet.setPosition(600, 400);
		testBullet.setRestitution(0.7f);


		myWorld.add(wall1);
		myWorld.add(wall2);
		myWorld.add(wall3);
		myWorld.add(wall4);
		
		myWorld.add(floor1);
		myWorld.add(floor2);
		
		myWorld.add(player1);
		myWorld.add(player2);
		myWorld.add(player3);
		myWorld.add(testBullet);
	}

	public void step()
	{
		for(int i = 0; i<5; i++)
		{
			myWorld.step();
		}
	}
	
	public void drawBox(Graphics2D g2d, Body b)
	{
		Box box = (Box) b.getShape();
		Vector2f[] pts = box.getPoints(b.getPosition(), b.getRotation());
	
		Vector2f p1 = pts[0];
		Vector2f p2 = pts[1];
		Vector2f p3 = pts[2];
		Vector2f p4 = pts[3];
		
		g2d.drawLine((int) p1.x,(int) p1.y,(int) p2.x,(int) p2.y);
		g2d.drawLine((int) p2.x,(int) p2.y,(int) p3.x,(int) p3.y);
		g2d.drawLine((int) p3.x,(int) p3.y,(int) p4.x,(int) p4.y);
		g2d.drawLine((int) p4.x,(int) p4.y,(int) p1.x,(int) p1.y);

	}
	
	public void draw(Graphics2D g2d)
	{
		// Dikke lijn, beter zichtbaar
		g2d.setStroke(new BasicStroke(2));
		
		g2d.setColor(Color.GREEN);
		drawBox(g2d, wall1);
		drawBox(g2d, wall2);
		drawBox(g2d, wall3);
		drawBox(g2d, wall4);
		
		g2d.setColor(Color.black);
		drawBox(g2d, floor1);
		drawBox(g2d, floor2);
		drawBox(g2d, player1);
		drawBox(g2d, player2);
		drawBox(g2d, player3);
		drawBox(g2d, testBullet);
		
	}
	/**
	 * @Method Jumping of @param body. 
	 * @param Direction 0 for up, -1 for jump left, 1 for jump right.
	 */
	
	public void jump(int playerID, int direction)
	{
		Body player = playerSelection(playerID);
		player.setFriction(1);
		player.addForce(new Vector2f(direction*15000.0f, -30000.0f));
		player.setFriction(0);
	}
	
	public Body playerSelection(int playerID)
	{
		
		Body player;
		switch(playerID)
		{
		case 1:
			player = player1;
			break;
		case 2:
			player = player2;
			break;
		case 3: 
			player = player3;
			break;
			
		default: 
			player = null;
			break;
		
		}
		return player;
	}
	
	
	public void reposition(int playerID, int direction)
	{
		Body player = playerSelection(playerID);
		player.setFriction(0);
		if(direction>0)
		{
			player.adjustVelocity(new Vector2f(100,0));
		}
		else if(direction<0)
		{
			player.adjustVelocity(new Vector2f(-100,0));
		}
		else if(direction == 0)
		{
			player.adjustVelocity(new Vector2f(-10,0));
		}
	}

}
