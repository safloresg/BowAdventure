package GUI;

import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.sun.prism.paint.Color;

public class Menu extends BasicGameState{
	StateBasedGame game;
	int id ;
	public Menu (int id){
		this.id = id;
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame game)
			throws SlickException {
		this.game = game;
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		g.drawString("Menu Principal", 100, 10);
		
		g.drawString("1.- Iniciar Juego", 100, 100);
		g.drawString("2.- Puntuaciones", 100, 120);
		g.drawString("3. -Salir", 100, 140);


		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public void keyReleased(int key,char c ){
		System.out.print(key);
		if (key == Input.KEY_NUMPAD1){
			game.enterState(1);
			System.out.print(key);
			
			
			
		}
		
	}
	

		
		
	}

	


