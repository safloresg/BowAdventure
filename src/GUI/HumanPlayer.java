package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;

public class HumanPlayer extends Player{

	int contador;
	Arrow arrow ;
	float coordinateX;
	float coordinateY;
	boolean attacking;
    public HumanPlayer(Image img) throws SlickException {
		this.img = img;
		coordinateX = 10;
    	coordinateY = 310;
		arrow = new Arrow();
		attacking = false;
		
		
		// TODO Auto-generated constructor stub
	}
    public HumanPlayer() {
    	
    	
    }

	@Override
    public void makeMovement(){
		float velocidad = 80;
		arrow.setTeta(img.getRotation()*-1);
		arrow.setVelocidad(velocidad);
		arrow.setX(coordinateX);
		arrow.setY(coordinateY);
		arrow.draw();
    }
	


	public boolean isArrowThrowed(){
		return arrow.isArrowThrowed();
	}
	
	public void render(GameContainer gc, StateBasedGame stateGame, Graphics g ){
		img.draw(coordinateX,coordinateY);
    	g.drawString(""+img.getRotation(), 100, 20);		
		if (attacking){arrow.render(gc, stateGame, g);}
	}
	
	public void update(GameContainer gc,StateBasedGame stateGame, int delta){
		Input input = gc.getInput();
		if (input.isKeyPressed(input.KEY_SPACE) && !attacking){
			attacking = true;
		}
		
		if (input.isKeyPressed(input.KEY_UP) && img.getRotation() > -90){
			img.rotate(-5);
		}
		
		if (input.isKeyPressed(input.KEY_DOWN) && img.getRotation() < 0){
			img.rotate(5);
			
		}
		if (attacking){
			arrow.setX(coordinateX);
			arrow.setY(coordinateY);
			arrow.setTeta(-1*img.getRotation());
			arrow.setVelocidad(60);
			arrow.update(gc, stateGame, delta);
		    	
		}
	}
}
