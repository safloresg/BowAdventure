package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LoadBar{
	 private Image barImg ;
	 private Image whiteBarImg;
	 private float xCoordinate;
	 private float yCoordinate;
	 private boolean loading;
	 
	 public void init(float xCoordinate , float yCoordinate){
		 this.xCoordinate = xCoordinate;
		 this.yCoordinate = yCoordinate;
		 loading = true;		
		 try {	 
			barImg = new Image("Animaciones/Bowman/barra.png");
			whiteBarImg = new Image("Animaciones/Bowman/white_bar.png");
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	 }
	 
	 public void render(){
		barImg.draw(xCoordinate, yCoordinate);
		whiteBarImg.draw(barImg.getCenterOfRotationX(), yCoordinate);
		 	 
	 }
	 
	 public void update(){
		 
	 }
	
	
}