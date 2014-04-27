package GUI;

import javax.swing.JButton;

import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sun.prism.paint.Color;

public class Menu extends BasicGameState{
	StateBasedGame game;
	int id ;
	Image iniciar;
	Image puntuaciones;
	Image salir;

	public Menu (int id){
		this.id = id;
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame game)
			throws SlickException {
		this.game = game;
		iniciar = new Image("Animaciones/Bowman/iniciar.png");
		puntuaciones = new Image("Animaciones/Bowman/puntuaciones.png");
		salir = new Image("Animaciones/Bowman/salir.png");
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		g.drawString("Menu Principal", 100, 10);
		
		iniciar.draw(100,100);
		puntuaciones.draw(100,200);
		salir.draw(100,300);


		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame stateGame, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		Input input = container.getInput();
		int mousex = input.getMouseX();
		int mousey = input.getMouseY();
		
	if ((mousex > 100 && mousex < 600 )  && (mousey > 100 && mousey < 200)){
		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			stateGame.enterState(1);

			
		}
		
	}
if ((mousex > 100 && mousex < 600 )  && (mousey > 200 && mousey < 300)){
	
		
	}
if ((mousex > 100 && mousex < 600 )  && (mousey > 300 && mousey < 400)){	
	
}
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	/*
	public void keyReleased(int key,char c ){
		System.out.print(key);
		if (key == Input.KEY_NUMPAD1){
			game.enterState(1);
			System.out.print(key);
			
			
			
		}
		
	}*/
	

		
		
	}

	


