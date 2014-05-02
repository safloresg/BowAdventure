

package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.InputProviderTest;
import org.newdawn.slick.tiled.TiledMap;



class GamePanel extends BasicGameState  {

	private int id;
    /*Mapa del juego*/
    private TiledMap map;
    /*jugador 2*/
    private HumanPlayer player1;
    /*Jugador 2*/
    private Player player2;
    /*Coordenadas der arco*/
    private InputProvider provider;
    /*Lista de comandos*/
    /*Mover arco hacia arriba*/
    private Command moveUp = new BasicCommand("MoveUp");
    /*Mover arco hacia abajo*/
    private Command moveDown = new BasicCommand("MoveDown");
    /*Lanzar flecha*/
    private Command throwArrow = new BasicCommand ("ThrowArrow");
    
    int delta;
    
    public GamePanel(int id){
    	this.id = id;
    }
    
    

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		player1 = new HumanPlayer(new Image("Animaciones/Bowman/arco.png",true));
		
		//player2 = new ComputerPlayer(player1.getImg().getFlippedCopy(true,false));
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
    	player1.render(container, game , g);
    	/*
    	if (player1.isArrowThrowed()){
    		player1.makeMovement();  
		}*/
	}

	@Override
	public void update(GameContainer container, StateBasedGame stateGame, int delta)
			throws SlickException {
		player1.update(container, stateGame, delta);
		
	
		
		
	}

	@Override
	public int getID() {
		return id;
	}

}
