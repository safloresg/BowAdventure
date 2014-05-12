package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Flecha {
	private static final float GRAVEDAD = 9.8f;
	private Image img;
	private float scrWidth;
	private float scrHeight;
	private float x;
	private float y;
	private float yIni;
	private float xIni;
	private float teta;
	private float velocidad;
	private float velocidadY;
	private float tiempo;
	private boolean throwed;
	
	public void init(GameContainer gc,float x, float y , float teta , float velocidad){
		this.x = x;
		this.y = y;
		this.yIni = y;
		this.xIni = x;
		this.teta = teta;
		this.velocidad = velocidad;
		this.scrHeight = gc.getHeight();
		this.scrWidth = gc.getWidth();
		tiempo = 0;
		throwed = true;
		try {
			img = new Image("Animaciones/Bowman/flecha.png");
		   img.setRotation((float) Math.toRadians(40));

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update(GameContainer gc){
	   if (x <= scrWidth && y <= scrHeight){
		   calcX();
		   calcY();	
		   System.out.println("update x="+x+" y="+y+"Tiempo= "+tiempo);
		   //render();
		   
		   tiempo+=.2;
	   }
	   else {throwed = false;}
	}

	public void render(){
		img.draw(x,y);
		img.rotate((float) (Math.PI - Math.atan2(velocidadY,velocidad)));
		//img.setRotation((float) (Math.PI + Math.atan2(velocidadY,velocidad)));
		System.out.println(Math.toDegrees(img.getRotation()));
		//System.out.println("render x="+x+" y="+y+"tiempo= "+tiempo+" Angulo= "+img.getRotation());
	}
	
	private void calcX(){
	x = (float)(xIni+((velocidad * Math.cos(Math.toRadians(teta)))*tiempo));
	//x = velocidad * tiempo;
	}
	
	private void calcY(){
		calcVelocidadY();
		System.out.print("Veolocidad y="+velocidadY);
		y = (float)(yIni-((((velocidadY * Math.sin(Math.toRadians(teta)))*tiempo)-((GRAVEDAD*Math.pow(tiempo, 2))))));
	}
	
	public boolean isThrowed(){
		return throwed;
	}
	
	public void calcVelocidadY(){
		velocidadY = (float) (velocidad * Math.sin(Math.toRadians(teta)) - (GRAVEDAD * tiempo));		
	}
	
	
	
	 
	
}
