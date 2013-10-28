package words;

import game.hud.Hud;
import game.hud.InputBox;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Level
{
	private Hud hud;
	private Random rnd = new Random();
	private int numWords;
	private float time, averageTime, counter;
	private float[] times;
	private Word[] words;
	private boolean levelOver = false;
	private String text = "";
	private int points = 0;
	public Level(String[] read, int numWords, float time)
	{
		this.time = time;
		this.numWords = numWords;
	   	averageTime = time / (float)numWords;
    	times = new float[numWords];
    	words = new Word[numWords];
    	for(int i = 0;i < numWords;i++)
    	{
    		int randNum = rnd.nextInt(WordReader.totalWords);
    		words[i] = new Word(read[randNum]);
    		times[i] = averageTime * (float)i;
    	}
    	hud = new Hud();
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		counter += delta;
		if(counter > time)levelOver = true;
		hud.update(gc, sbg, delta);
		text = ((InputBox)hud.getComponent(Hud.InputBoxID)).getText();
		for(int i = 0;i < numWords;i++)
    	{
			if(counter > times[i])
			{
				words[i].update(gc, delta);
			}
			if(words[i].getID().equalsIgnoreCase(text) && words[i].isVisible())
			{
				words[i].setVisible(false);
				points += 10;
				((InputBox)hud.getComponent(Hud.InputBoxID)).eraseText();
			}
    	}
		hud.setPoints(points);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		for(int i = 0;i < numWords;i++)
    	{
			if(counter > times[i])
			{
				words[i].render(gc, g);
			}
    	}
		hud.render(gc, sbg, g);
	}
	public boolean isLevelOver(){return false;}
}
