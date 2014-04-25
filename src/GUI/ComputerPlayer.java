package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class ComputerPlayer extends Player{

    public ComputerPlayer(Image img) throws SlickException {
		this.img = img;
	}

	@Override
    public void makeMovement(float teta,float velocidad, int x, int y) {}

    



}
