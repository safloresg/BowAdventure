package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Arrow {
	private Image img;
	private boolean isArrowThrowed; //Variable que nos dice si se hay una flecha en movimiento o no
	private double vel0;
	private int x , y;
	
	
	
	public Arrow() throws SlickException{
		/* Constructor */
		img = new Image("Animaciones/Bowman/flecha.png");
		isArrowThrowed = false;
	}
	public Arrow(Image img){
		this.img = img;
		
	}
	
	public void setImg(Image img){
		this.img = img;
	}
	
	public Image getImg(){
		
		return this.img;
	}
	
	public void draw(int x, int y){
		this.x = x ;
		this.y = y ;
		img.draw(x,y);
		
		isArrowThrowed = true;
		
	}
	
	public boolean isArrowThrowed(){
		return isArrowThrowed;
		
	}

}
