package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public abstract class Player {
	protected String playerName;
	protected int playerNumber;
	protected int hitPoints;
	protected int missPoints;
	protected Image img= null;

   
    
    public String getPlayerName() {
	
	return playerName;
		
    }
    
    public void setPlayerName(String playerName){
	this.playerName = playerName;
    }
    public int getplayerNumber(){
	return playerNumber;
    }
    public void setPlayerNumber(int playerNumber){
	this.playerNumber = playerNumber;
    }
    public void addHitPoint(){}

    public void addMissPoint(){}

    public int getHitPoints(){
	return hitPoints;
    }
    public int getMissPoints(){
	return missPoints;
    }
    
    public void setImg(Image img){
	this.img = img;
    }
    
    public Image getImg(){
	return this.img;
    }
    public void draw(int x, int y){
    	img.draw(x,y);    	
    }

    public abstract void makeMovement(int delta);
    
}
