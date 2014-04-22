package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Arrow {
	private Image img;
	public boolean isArrowThrowed; //Variable que nos dice si se hay una flecha en movimiento o no
	private float x=0,y=0;
	private int contador = 0;
	/*------------------------------------------------------------------*
	 * 					CONSTANTES FISICA                                *
	 * -----------------------------------------------------------------*/
	public static final double GRAVEDAD = 9.8;
	
	/*------------------------------------------------------------------*/
	
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
	
	public void draw(double teta,double velocidad,float x,float y){
		if (!isArrowThrowed){
		this.x =x;
		this.y = y;

		}
		//System.out.println("this.x="+this.x+"this.y:"+this.y);
		img.draw(this.x,this.y);

		this.x = (float)((x + (velocidad*Math.cos(Math.toRadians(teta))*contador)));
		this.y = (float)( (y + ((velocidad*Math.sin(Math.toRadians(teta)))*contador)-(.5*GRAVEDAD*contador)));
		if (this.y >480 || this.x > 500){
			isArrowThrowed =false;
			this.x = 0;this.y=0;
			contador =0;
			
		}else{
		isArrowThrowed = true;}
		contador++;
		
	}
	
	public boolean isArrowThrowed(){
		return isArrowThrowed;
		
	}

}
