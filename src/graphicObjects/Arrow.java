package graphicObjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Arrow {
	private Image img;
	public boolean isArrowThrowed; //Variable que nos dice si se hay una flecha en movimiento o no
	private float x=0,y=0;
	private int contador = 0;
	private float teta;
	private float velocidad;
	private float tiempoIni;
//	private float tiempo;
	public static final double GRAVEDAD = 9.8;
	
	
	public Arrow() throws SlickException{
		/* Constructor */
		img = new Image("Animaciones/Bowman/flecha.png");
		isArrowThrowed = false;
	}
	public Arrow(Image img){this.img = img;}
	
	public Arrow(Image img,float teta, float velocidad, float x, float y){
		this.y = y;
		this.x =x;
		this.teta = teta;
		this.img = img;
		
	}
	
	public Arrow (float teta, float velocidad , float x, float y) throws SlickException{
		img = new Image ("Animaciones/Bowman/flecha.png");
		this.x = x;
		this.y = y;
		this.teta = teta;
		this.velocidad = velocidad;
		
	}
	
	public void setImg(Image img){this.img = img;}
	
	public Image getImg(){return this.img;}
	
	public void draw (){
		isArrowThrowed = true;
		float vx = calcVx();
		float vy = calcVy();
		x = (float) (velocidad *Math.cos(Math.toRadians(teta))*contador);
		y = (float) (y+(-1*((Math.tan(Math.toRadians(teta))*x)-
				(GRAVEDAD/(2*Math.pow(velocidad,2)*Math.pow(Math.cos(Math.toRadians(teta)),2))*
						Math.pow(x, 2)))));
		
		//y = (float)(-1* (y+((velocidad * Math.sin(Math.toRadians(teta))*contador)-((GRAVEDAD*(Math.pow(contador, 2)))/2))));
		img.draw(x,y);
		img.setRotation((float) Math.atan2(y,x));

		contador++;
		
		if (this.x > 500 || this.y >500){
			isArrowThrowed = false;
			x =0;
			y =0;
			contador =0;
			
		}
		
	}
	
	
	public void setX(float x){this.x = x;}
	
	public float getX(){return  x;}
	
	public void setY (float y){this.y = y;}
	
	public float getY (){return y;}
	
	public void setTeta (float teta) {this.teta = teta;}
	
	private float getTeta (){return teta;}
	
	public void setVelocidad(float velocidad){this.velocidad = velocidad;}
	
	public void reinitContador(){
		contador=0;
	}
	
	
	
	private float calcVx(){
		/*calcular el vector de velocidad en x*/
		return (float) (velocidad*Math.cos(Math.toRadians(teta))) ;
	}
	
	private float calcTiempoTrans(){
		/**Calcula el tiempo transcurrido desde que  se llamo a draw()**/
		float tiempoActual = System.nanoTime();
		return 	 (tiempoActual - tiempoIni)/1000000000;
		
	}
	
	private float calcVy(){
		/*Calcular el vector de velocidad en y*/

		return  (float)((float)(velocidad*Math.sin(Math.toRadians(teta)))-(GRAVEDAD*calcTiempoTrans()));
	}
	

	
	
	
	public boolean isArrowThrowed(){return isArrowThrowed;}
	
	public void render(GameContainer container,StateBasedGame game,Graphics g){
		img.draw(x,y);
        System.out.println("render"+x+":"+y);

	

		
		
	}
	
	public void update (GameContainer container, StateBasedGame game , int delta){
		//float vx = calcVx();
		//float vy = calcVy();
		
		x = (float) (velocidad* Math.cos(Math.toRadians(teta)) * contador);
		y = (float) (y+(-1*((Math.tan(Math.toRadians(teta))*x)-
				(GRAVEDAD/(2*Math.pow(velocidad,2)*Math.pow(Math.cos(Math.toRadians(teta)),2))*
						Math.pow(x, 2)))));
		//y += (float)(-1* ((((velocidad * Math.sin(Math.toRadians(teta)))*contador)-((GRAVEDAD*(Math.pow(contador, 2)))/2))));
        contador++;
        System.out.println(x+":"+y);
	}
	
	

}
