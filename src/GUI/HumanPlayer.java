package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;

public class HumanPlayer extends Player implements InputProviderListener{

	int contador;
	Arrow arrow ;
    public HumanPlayer(Image img) throws SlickException {
		this.img = img;
		arrow = new Arrow();
		// TODO Auto-generated constructor stub
	}
    public HumanPlayer() {
    	
    	
    }

	@Override
    public void makeMovement(int delta){
		
		arrow.draw(-1*img.getRotation(),delta,10f,310f);
    }
	@Override
	public void controlPressed(Command command) {
		// TODO Auto-generated method stub
		if (((BasicCommand)command).getName().equals("MoveUp") && img.getRotation() > -90){
			img.rotate(-10);
			
		}else if (((BasicCommand)command).getName().equals("MoveDown") && img.getRotation() < 0){
			img.rotate(10);
			
		}else if (((BasicCommand)command).getName().equals("ThrowArrow")&& !arrow.isArrowThrowed()){
			System.out.print(command);
			arrow.isArrowThrowed = true;
		} 

	}
	@Override
	public void controlReleased(Command command) {
		// TODO Auto-generated method stub
		
	}
	
	


}
