package game;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import state.MenuState;
import state.PlayState;
import state.SplashState;

public class Game extends StateBasedGame 
{
	public static final int WIDTH = 1256, HEIGHT = 866;
	public static final int Splash = 0, MENU = 1, PLAY = 2;
	public static final String Title = "Word Game";
	public Game() throws SlickException
	{
		super(Title);
		this.addState(new SplashState(Splash));
		this.addState(new MenuState(MENU));
		this.addState(new PlayState(PLAY));
	}
	public void initStatesList(GameContainer gc) throws SlickException 
	{
		getState(Splash).init(gc, this);
		getState(MENU).init(gc, this);
		getState(PLAY).init(gc, this);
		enterState(PLAY);
	}

	public static void main(String args[]) throws SlickException
	{
		 AppGameContainer app = new AppGameContainer(new Game());
		 app.setDisplayMode(WIDTH, HEIGHT, false);
		 app.start();
	}

}
