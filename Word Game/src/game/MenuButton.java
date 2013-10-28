package game;


import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class MenuButton 
{
	private Image buttonImage = null;
	private Image litButtonImage = null;
	private TrueTypeFont font = new TrueTypeFont(new Font("Times New Roman", Font.BOLD, 24), false);
	private String text;
	private int x, y, textWidth;
	private float scale = 3.0f;
	private boolean entered = false, clicked = false;
	public MenuButton(String str, int y) throws SlickException
	{
		this.text = str;
		this.y = y;
		scale = 3;
		buttonImage = new Image("res/button.png");
		litButtonImage = new Image("res/button_lit.png");
		textWidth = font.getWidth(text);
		x = (Game.WIDTH - buttonImage.getWidth()) / 2 - 55;
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		Input input = gc.getInput();
		int mx = input.getMouseX();
		int my = input.getMouseY();
		if((mx > x && mx < x + buttonImage.getWidth() * scale) && (my > y && my < y + buttonImage.getHeight() * scale)) entered = true;
		else entered = false;
		
		if(entered && input.isMouseButtonDown(0)) clicked = true;
		else clicked = false;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(entered)buttonImage.draw(x, y, scale);
		else litButtonImage.draw(x, y, scale);
		g.drawString(text, x + 25 + (textWidth - buttonImage.getWidth()) / 2, y + 10);
	}
	public boolean isEntered() {return entered;}
	public void setEntered(boolean entered) {this.entered = entered;}
	public boolean isClicked() {return clicked;}
	public void setClicked(boolean clicked) {this.clicked = clicked;}
}
