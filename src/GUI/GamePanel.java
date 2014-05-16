

package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;



class GamePanel extends BasicGameState  {

	private int id;
    /*Mapa del juego*/
    private TiledMap map;
    /*jugador 2*/
    private HumanPlayer player1;
    /*Jugador 2*/
    private Player player2;
    //tiempo transcurrido
    int delta;
    //true si es el turno de player1. false si es turno de player2
    private boolean turno;
    
    public GamePanel(int id){
    	this.id = id;
    }
    
    

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		player1 = new HumanPlayer(new Image("Animaciones/Bowman/arco.png",true),10,310);
		
		player2 = new ComputerPlayer(player1.getImg().getFlippedCopy(true,false),500,310);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
    	player1.render(container, game, g);
    	
    	player2.render(container, game, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame stateGame, int delta)
			throws SlickException {
		Input in = container.getInput();
	    //if (!player1.isMoveMaked())
		if (!player1.isMoveMaked())
		player1.update(container, stateGame, delta);
		//if (!player2.isMoveMaked())
		player2.update(container, stateGame, delta);
		
		
		if (in.isKeyPressed(Input.KEY_ENTER)){
			stateGame.enterState(Estados.Menu.getNumberOfMenu());
		}
	}

	@Override
	public int getID() {
		return id;
	}

}
