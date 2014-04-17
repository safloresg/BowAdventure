package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;

public class HumanPlayer extends Player implements InputProviderListener{

    public HumanPlayer(Image img) throws SlickException {
		this.img = img;
		// TODO Auto-generated constructor stub
	}
    public HumanPlayer() {
    	
    	
    }

	@Override
    public void makeMovement(GameContainer container){
        
		Input input = container.getInput();
		System.out.println("movement"+input.isKeyPressed(input.KEY_DOWN));

		if(input.isKeyPressed(input.KEY_UP) && (img.getRotation() > -90) ){	
			System.out.println("movement");
			img.rotate(-10);
    	}else
    	if (input.isKeyPressed(input.KEY_DOWN) && (img.getRotation() < 0)){
    		img.rotate(10);
    		
    	}
		
		
    }
	@Override
	public void controlPressed(Command arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void controlReleased(Command arg0) {
		// TODO Auto-generated method stub
		
	}
	
	


}
