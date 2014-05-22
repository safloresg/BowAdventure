package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	/*ID de cada estado*/
	public static void main(String args[]){
		try {
			AppGameContainer app = new AppGameContainer(new Main("BowAdventure"));
			app.setDisplayMode(640, 480, false);
			//app.setFullscreen(true);
			
			
//			app.setFullscreen(true);
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
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new Menu(Estados.Menu.getNumberOfMenu()));
		addState(new GamePanel(Estados.Game.getNumberOfMenu()));
		
	}

}
