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

public class HumanPlayer {

	int contador;
	Flecha arrow ;
	LoadBar barra;
	float coordinateX;
	float coordinateY;
	boolean loading;
	boolean attacking;
	Image img;
	Estado estado;
	
	enum Estado{REPOSO,ATACANDO,CARGANDOATAQUE,ATACADO}
	
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
   

	/*public boolean isArrowThrowed(){
		return arrow.isArrowThrowed();
	}*/
	
	
	
	public void render(GameContainer gc, StateBasedGame stateGame, Graphics g ){
		img.draw(coordinateX,coordinateY);
    	g.drawString(""+img.getRotation(), 100, 20);	
    	
    	switch(estado){
		case ATACADO:
			break;
		case ATACANDO:
			arrow.render();
			break;
		case CARGANDOATAQUE:
			barra.render();
			break;
		case REPOSO:
			break;
		default:
			break;
    	 
    	
    	}/*
		if (attacking){
			arrow.render();
			}
		if (loading){
			barra.render();
		}*/
	}
	
	public void update(GameContainer gc,StateBasedGame stateGame, int delta){
		Input input = gc.getInput();
		
        switch(estado){
        
        case REPOSO :
        	if (input.isKeyDown(input.KEY_SPACE))
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
     			arrow.init(gc, coordinateX, coordinateY,-1* img.getRotation(), 80);
        		
        	}

        	
        	break;
        	
        case ATACANDO :
        	if (arrow.isThrowed())
        	{
        		arrow.update(gc);
        	}else
        		estado = Estado.REPOSO;
        	break;
		case ATACADO:
			break;
		default:
			break;
        	
        
        
        }
        
       
/*
 		if (input.isKeyPressed(input.KEY_SPACE) && !attacking){
			attacking = true;
			arrow.init(gc, coordinateX, coordinateY,-1* img.getRotation(), 80);
			
		}
 		
       if (input.isKeyDown(Input.KEY_SPACE) && !loading ){
			loading = true;
			barra.init(coordinateX, coordinateY);
			
			
		}else loading = false;
		*/
		if (input.isKeyPressed(input.KEY_UP) && img.getRotation() > -90){
			img.rotate(-5);
		}
		
		if (input.isKeyPressed(input.KEY_DOWN) && img.getRotation() < 0){
			img.rotate(5);
			
		}/*
		if (attacking){
			if (arrow.isThrowed()){
				arrow.update(gc);
			}else
				attacking = false;
		}
		
		if (input.isKeyDown(Input.KEY_SPACE)&&loading){
			barra.update();
			
		}*/
	}
}
