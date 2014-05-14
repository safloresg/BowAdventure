package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class HumanPlayer extends Player {

    public HumanPlayer(Image img) throws SlickException {
		this.img = img;
		coordinateX = 10;
    	coordinateY = 310;
		arrow = new Flecha();
		attacking = false;
		barra = new LoadBar();
		estado = Estado.REPOSO;
		
		
		// TODO Auto-generated constructor stub
	}
    
	
	public void render(GameContainer gc, StateBasedGame stateGame, Graphics g ){
		img.draw(coordinateX,coordinateY);
    	g.drawString(""+img.getRotation(), 100, 20);	
    	
    	switch(estado){
		case ATACADO:
			break;
		case ATACANDO:
			arrow.render(gc, stateGame, g);
			break;
		case CARGANDOATAQUE:
			barra.render();
			break;
		case REPOSO:
			break;
		default:
			break;
    	 
    	
    	}
	}
	
	public void update(GameContainer gc,StateBasedGame stateGame, int delta){
		Input input = gc.getInput();
		
        switch(estado){
        
        case REPOSO :
        	if (input.isKeyDown(Input.KEY_SPACE))
        	{
            	estado = Estado.CARGANDOATAQUE;
            	barra.init(coordinateX, coordinateY);
        	}
        	break;
        case CARGANDOATAQUE :
        	if (input.isKeyDown(Input.KEY_SPACE))
        	{
        		barra.update();
        		//estado = Estado.ATACANDO;        		
        	}else{
        		 estado = Estado.ATACANDO;
     			arrow.init(gc, coordinateX, coordinateY,-1* img.getRotation(), barra.getVelocidad());
        	}
        	break;
        case ATACANDO :
        	// Si hay un ataque en curso se actualiza el juego , si no, se cambia el estado a REPOSO
        	if (arrow.isThrowed())
        	{
        		arrow.update(gc, stateGame, delta);
        	}else
        		estado = Estado.REPOSO;
        	break;
		case ATACADO:
			break;
		default:
			break;
        }
		if (input.isKeyPressed(Input.KEY_UP) && img.getRotation() > -90){
			img.rotate(-5);
		}
		
		if (input.isKeyPressed(Input.KEY_DOWN) && img.getRotation() < 0){
			img.rotate(5);
			
		}
	}
}
