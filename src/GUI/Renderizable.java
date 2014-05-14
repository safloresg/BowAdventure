package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public interface Renderizable {
	
	
	public void render(GameContainer gc, StateBasedGame stateGame, Graphics g );
	
	public void update(GameContainer container, StateBasedGame stateGame, int delta);


}
