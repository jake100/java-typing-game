package words;

import game.Game;
import game.hud.Hud;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Word
{
	protected String id;
	protected Vector2f pos;
	protected int buffer, y, startX, endX;
	protected float speed = .025f;
	protected boolean visible = true, onScreen = true;
	protected Random rnd = new Random();
	protected Color color;
	public Word(String id)
	{
	    startX = -75;
		this.id = id;
		int buffer = 10;
		y = rnd.nextInt(Game.HEIGHT - (Hud.HEIGHT + buffer) * 2) + Hud.HEIGHT + buffer;
	    pos = new Vector2f(startX, y);
	    endX = Game.WIDTH - buffer;
	    float min = 0.15f;
	    float red = rnd.nextFloat() + min;
	    float blue = rnd.nextFloat() + min;
	    float green = rnd.nextFloat() + min;
	    if(red > 1.0f)red = 1.0f;
	    if(blue > 1.0f)blue = 1.0f;
	    if(green > 1.0f)green = 1.0f;
	    color = new Color(red, blue, green);
	}
	public void update(GameContainer gc, int delta) throws SlickException
	{
		if(visible)
		{
			pos.x += speed;
			if(pos.x > endX - buffer)
			{
				onScreen = false;
			}
		}
	}
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		if(visible)
		{
			g.setColor(color);
			g.drawString(id, pos.x, pos.y);
		}
	}
	public void setVisible(boolean visible){this.visible = visible;}
	public boolean isVisible(){return visible;}
	public String getID(){return id;}
	public boolean isOnScreen(){return onScreen;}
}
