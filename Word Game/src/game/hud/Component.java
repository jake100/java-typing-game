package game.hud;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Component
{
    protected String id;
    protected boolean enabled = true;
    public Component(String id)
    {
    	this.id = id;
    }
    public String getId()
    {
        return id;
    }
 
    public boolean isEnabled() {return enabled;}
	public void setEnabled(boolean enabled) {this.enabled = enabled;}

	public abstract void update(GameContainer gc, StateBasedGame sbg, int delta);
}
