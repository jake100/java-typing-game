package game.hud;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class RenderComponent extends Component
{
	public RenderComponent(String id)
	{
		super(id);
	}
	private boolean visible = true;
    public boolean isVisible() {return visible;}
	public void setVisible(boolean visible) {this.visible = visible;}
	public abstract void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException;
}
