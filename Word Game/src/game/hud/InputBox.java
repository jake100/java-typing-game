package game.hud;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class InputBox extends RenderComponent
{
	public InputBox(String id)
	{
		super(id);
	}
	private String text = "";
	private int delay = 0, delayTime = 185;
	private boolean enter = false;
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
	{
		Input input = gc.getInput();
		if(delay <= 0)
		{
			if(input.isKeyDown(input.KEY_BACK))
			{
				eraseText();
			}
			else if(input.isKeyDown(input.KEY_SPACE))
			{
				text += " ";
			}
			else if(input.isKeyDown(input.KEY_RETURN))
			{
				enter = true;
			}
			else
			{
				typeKey(input);
			}
		}
		else delay -= delta;
				
	}
	private void typeKey(Input input)
	{
		for(int i = 0; i < 100; i++)
		{
			
			if(input.isKeyDown(i))
			{
				text += Input.getKeyName(i).toLowerCase();
				delay += delayTime;
			}
		}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException
	{
		g.setColor(Color.white);
		g.drawString(text, 30, Hud.HEIGHT / 2);
	}
	public void eraseText(){text = "";}
	public String getText(){return text;}
	public boolean isEnter(){return enter;}
	public void setEnter(boolean enter){this.enter = enter;}

}
