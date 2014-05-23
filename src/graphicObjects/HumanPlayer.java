package graphicObjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class HumanPlayer extends Player {

	public HumanPlayer(){}
	
    public HumanPlayer(Image img,int x,int y) throws SlickException {
		super (img,x,y,new Image("Animaciones/Bowman/flecha.png"),true);
		
	}
    
    
}

