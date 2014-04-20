

package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.tests.InputProviderTest;
import org.newdawn.slick.tiled.TiledMap;



class GamePanel extends BasicGame  {

    /*Mapa del juego*/
    private TiledMap map;
    /*Coordenadas del jugador 1*/
    /*coordenas jugador 2*/
    /*jugador 2*/
    private HumanPlayer player1;
    /*Jugador 2*/
    private Player player2;
    /*Coordenadas der arco*/
    private int arrowX= 0, arrowY= 100;
    private boolean iniciarArrow= false;
    private InputProvider provider;
    /*Lista de comandos*/
    /*Mover arco hacia arriba*/
    private Command moveUp = new BasicCommand("MoveUp");
    /*Mover arco hacia abajo*/
    private Command moveDown = new BasicCommand("MoveDown");
    
    public static void main (String args[]){
    	try {
			AppGameContainer app = new AppGameContainer(new GamePanel());
			app.setDisplayMode(500, 400, false);
			app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public GamePanel(){
	super("BowAdventure");
    }
    
    public void init(GameContainer container) throws SlickException {
	player1 = new HumanPlayer(new Image("Animaciones/Bowman/arco.png",true));
	player2 = new ComputerPlayer(player1.getImg().getFlippedCopy(true,false));
    provider = new InputProvider(container.getInput());
	provider.addListener(player1);
	provider.bindCommand(new KeyControl(Input.KEY_UP), moveUp);
	provider.bindCommand(new KeyControl(Input.KEY_DOWN), moveDown );
    }
    
    public void update (GameContainer container,int delta)throws SlickException{
    	
  
    }

    public void render(GameContainer container, Graphics g)
	throws SlickException {
    	player1.draw(50, 50);
    	g.drawString(""+player1.getImg().getRotation(), 100, 20);
	
    }

}
