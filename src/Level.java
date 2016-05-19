import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

 

public class Level extends JFrame 
{
	private Map map;
	private Main main;
	private ArrayList<Objects> objects;
	private ArrayList<Menu> menus;
	private ArrayList<HUD> huds;
	private ArrayList sprites;
	private int state = 1;
	private boolean up, right, down, left;

	public Level ()
	{
		super("Knight Runner");
		
		map = new Map();
		main = new Main();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(new ContentPane());
		setVisible(true);
		setResizable(true); //should be false!!!
		setSize(1024, 820);
		setLocationRelativeTo(null);
		
		
		
	} 
	class ContentPane extends JPanel implements ActionListener
	{
		private ActionListener refresh = new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				map.phys.step();
				repaint();
				
			}
		};
		public ContentPane()
		{
			map = new Map();
			new Timer(1000/60, this).start();
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponents(g);
			Graphics2D g2d = (Graphics2D)g;
			map.draw(g2d);
		}
		
		public void setMap(Map map) 
		{
	
		}
	
		public Map getMap() 
		{
			return null;
		}
	
		public void switchState() 
		{
	
		}
		int i = 0;
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			i++;
			update2();
			if(i==200){
				map.phys.reposition(1,1);
				System.out.println("i");
			}
		}
		
	}
	
	public void addHud(HUD hud)
	{
		huds.add(hud);
	}
	
	public void update2()
	{
		map.phys.step();
		repaint();
	}
	
	public void APressed(int id)
	{
		switch(state) {
		case 0:
			
		break;
		}
	}
	
	public void setUp(boolean state)
	{
		if(state)
			up = true;
		else
			up = false;
	}
	
	public void setRight(boolean state)
	{
		if(state)
			right = true;
		else
			right = false;
	}
	
	public void setDown(boolean state)
	{
		if(state)
			down = true;
		else
			down = false;
	}
	
	public void setLeft(boolean state)
	{
		if(state)
			left = true;
		else
			left = false;
	}
	

}
