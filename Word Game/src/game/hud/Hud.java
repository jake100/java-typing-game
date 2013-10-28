package game.hud;

import game.Game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Hud
{
	public static final int HEIGHT = 80;
	private ArrayList<Component> components = new ArrayList();
	public static final String InputBoxID = "Input Box";
	private int points = 0;
	public Hud()
	{
		components.add(new InputBox(InputBoxID));
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		for(Component component : components)
		{
			component.update(gc, sbg, delta);
		}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.setColor(Color.white);
		g.drawRect(0, 0, Game.WIDTH, HEIGHT);
		g.drawRect(0, Game.HEIGHT - HEIGHT, Game.WIDTH, HEIGHT);
		
		g.setColor(Color.green);
		g.drawString(points+"", 150, HEIGHT / 2);
		
		for(Component component : components)
		{
			if(component instanceof RenderComponent)((RenderComponent)component).render(gc, sbg, g);
		}
	}
	public Component getComponent(String id)
	{
		for(Component component : components)
		{
			if(component.id == id)return component;
		}
		return null;
	}
	public void setPoints(int points){this.points = points;}
}
