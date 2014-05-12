package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LoadBar{
	//Imagen de la barra de carga
	 private Image barImg ;
	 //Imagen de la barrita blanca que oscila
	 private Image whiteBarImg;
	 //Coordenadas en x de la barra de carga
	 private float xCoordinate;
	 //Coordenadas en y de la barra de carga
	 private float yCoordinate;
	 //Coordenadas en x de la barra chica
	 private float whiteBarX;
	 //Coordenadas en y de la barra chica
	 private float whiteBarY;
	 
	 private boolean direccion;
	 
	 public void init(float xCoordinate , float yCoordinate){
		 this.xCoordinate = xCoordinate;
		 this.yCoordinate = yCoordinate;
		 
		 direccion = true;		
		 try {	 
			barImg = new Image("Animaciones/Bowman/barra.png");
			whiteBarImg = new Image("Animaciones/Bowman/white_bar.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		 whiteBarX = barImg.getCenterOfRotationX();
		 whiteBarY = yCoordinate;
	 }
	 
	 public void render(){
		barImg.draw(xCoordinate, yCoordinate);
		whiteBarImg.draw(whiteBarX, whiteBarY);
	 }
	 
	 public void update(){
		
		float rightLimit = xCoordinate +barImg.getWidth();
		float leftLimit = xCoordinate;
		if (direccion)
		{
			if (whiteBarX < rightLimit)
			{
				whiteBarX+=5;
				
				
			}else direccion = false;
		}
		else
		{
			if (whiteBarX > leftLimit)
			{
				whiteBarX-=5;
			}
			else 
			{
				direccion = true;
			}
			
		}
		 
		 
	 }
	
	
}