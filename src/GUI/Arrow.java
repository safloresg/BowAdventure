package GUI;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
		x = 10 *contador;
		y = (float) (y+(-1*((Math.tan(Math.toRadians(teta))*x)-
				(GRAVEDAD/(2*Math.pow(velocidad,2)*Math.pow(Math.cos(Math.toRadians(teta)),2))*
						Math.pow(x, 2)))));
		img.draw(x,y);
		contador++;
		
		if (this.x > 500 || this.y >500){
			isArrowThrowed = false;
			x =0;
			y =0;
			contador =0;
			
		}
		
	}
	
	public void draw(float teta,float velocidad,float x,float y){
		isArrowThrowed = true;
		if (this.x == 0 && this.y ==0){
			
			
			this.x = x;
			this.y = y;
			this.velocidad = velocidad;
			tiempoIni =System.currentTimeMillis();
			this.teta =teta;
			System.out.println("this.x"+this.x+"y"+this.y);
		}
		float vx = calcVx();
		float vy = calcVy();
		float tiempo = calcTiempoTrans();
		System.out.println(tiempo);

		this.x = 10 *contador;
		this.y = (float) (y+(-1*((Math.tan(Math.toRadians(this.teta))*this.x)-(GRAVEDAD/(2*Math.pow(this.velocidad,2)*Math.pow(Math.cos(Math.toRadians(this.teta)),2))*Math.pow(this.x, 2)))));
		System.out.print("yCalculada:"+this.y);
		img.draw(this.x,this.y);
        contador++;
		if (this.x > 500 || this.y >500){
			isArrowThrowed = false;
			this.x =0;
			this.y =0;
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
	
	
	
	private float calcVx(){
		/*calcular el vector de velocidad en x*/
		return (float) (velocidad*Math.cos(Math.toRadians(teta))) ;
	}
	
	private float calcTiempoTrans(){
		/**Calcula el tiempo transcurrido desde que  se llamo a draw()**/
		float tiempoActual = System.currentTimeMillis();
		return 	 (tiempoActual - tiempoIni);
		
	}
	
	private float calcVy(){
		/*Calcular el vector de velocidad en y*/
		return  (float)((float)(velocidad*Math.sin(Math.toRadians(teta)))-(GRAVEDAD*calcTiempoTrans()));
	}
	
	public boolean isArrowThrowed(){return isArrowThrowed;}

}
