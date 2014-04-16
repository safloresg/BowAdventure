

package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.InputProviderTest;
import org.newdawn.slick.tiled.TiledMap;



class GamePanel extends BasicGame {

    
    TiledMap map;
    private static final int player1X = 1,player1Y=50;
    private static final int player2X = player1X*360 , player2Y = player1Y; 
    HumanPlayer player1;
    Player player2;
    Image arrow;
    private int arrowX= 0, arrowY= 100;
    private boolean iniciarArrow= false;
    
    
    public static void main (String args[]){
    	try {
			AppGameContainer app = new AppGameContainer(new GamePanel());
			app.setDisplayMode(500, 400, false);
			app.start();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   InputProviderTest t;
    	
    }
    
    public GamePanel(){
	super("BowAdventure");
    }
    
    public void init(GameContainer container) throws SlickException {
	player1 = new HumanPlayer(new Image("Animaciones/Bowman/arco.png",true));
	player2 = new ComputerPlayer(player1.getImg().getFlippedCopy(true,false));
    arrow = new Image("Animaciones/Bowman/flecha.png");
    }
    
    public void update (GameContainer container,int delta)throws SlickException{
    	
    	Input input = container.getInput();
        
    	if (input.isKeyPressed(input.KEY_UP) || input.isKeyPressed(input.KEY_DOWN) || input.isKeyPressed(input.KEY_SPACE)){
    		player1.makeMovement(container);
    	}
    		
   /* 	if(input.isKeyPressed(input.KEY_UP) && (player1.getImg().getRotation() > -90) ){	
    		player1.getImg().rotate(-10);
    	}else
    	if (input.isKeyPressed(input.KEY_DOWN) && (player1.getImg().getRotation() < 0)){
    		player1.getImg().rotate(10);
    		
    	}else if (input.isKeyPressed(input.KEY_SPACE)){
    		
    		iniciarArrow = true;
    	}*/
    }

    public void render(GameContainer container, Graphics g)
	throws SlickException {
	// TODO Auto-generated method stub
    	//player1.getImg().draw(player1X,player1Y);
    	player1.draw(player1X, player1Y);
    	player2.draw(player2X, player2Y);
    	//arrow.draw(300, 200);
    	if (iniciarArrow){
    	arrow.draw(arrowX++,arrowY);
    	}
    	
    	g.drawString(""+player1.getImg().getRotation(),200, 50);
    }

}
