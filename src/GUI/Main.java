package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	/*ID de cada estado*/
	private static final int Menu = 2;
	private static final int Game = 1;
	
	public static void main(String args[]){
		try {
			AppGameContainer app = new AppGameContainer(new Main("BowAdventure"));
			app.setDisplayMode(640, 480, false);
		//    app.setFullscreen(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		
	}

	public Main(String name) {
		super(name);
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new Menu(Menu));
		addState(new GamePanel(Game));
		
	}

}
