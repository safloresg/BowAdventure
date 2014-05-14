package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Flecha implements Renderizable{
	
	private static final float GRAVEDAD = 9.8f;
	//Imagen de la flecha
	private Image img;
	//largo de la pantalla
	private float scrWidth;
	//ancho de la pantalla
	private float scrHeight;
	//posicion de la flecha en x
	private float x;
	//posicion de la flecha en y
	private float y;
	//posicion inicial de la flecha en y
	private float yIni;
	//posicion inicial de la flecha en x
	private float xIni;
	//Angulo con que es lanzado la flecha
	private float teta;
	//Velocidad con que es lanzada la fleca
	private float velocidad;
	//Velocidad en y de la flecha
	private float velocidadY;
	//tiempo transcurrido desde que es lanzada la flecha
	private float tiempo;
	//true si la flecha esta lanzada
	private boolean throwed;
	
	public void init(GameContainer gc,float x, float y , float teta , float velocidad){
		//se inicializan las variables
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
		   
		   

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		img.setRotation(-teta);

		
		
	}
	
	
	
	private void calcX(){
	x = (float)(xIni+((velocidad * Math.cos(Math.toRadians(teta)))*tiempo));
	//x = velocidad * tiempo;
	}
	
	private void calcY(){
		calcVelocidadY();
		//System.out.print("Veolocidad y="+velocidadY);
		y = (float)(yIni-((((velocidadY * Math.sin(Math.toRadians(teta)))*tiempo)-((GRAVEDAD*Math.pow(tiempo, 2))))));
	}
	
	public boolean isThrowed(){
		return throwed;
	}
	
	public void calcVelocidadY(){
		velocidadY = (float) (velocidad * Math.sin(Math.toRadians(teta)) - (GRAVEDAD * tiempo));		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame stateGame, Graphics g) {
		// TODO Auto-generated method stub
		img.draw(x,y);
		img.rotate((float) (Math.PI + Math.atan2(velocidad,velocidadY)));
		//img.setRotation((float) (Math.PI + Math.atan2(velocidadY,velocidad)));
	//	System.out.println(Math.toDegrees(img.getRotation()));
		//System.out.println("render x="+x+" y="+y+"tiempo= "+tiempo+" Angulo= "+img.getRotation());
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame stateGame,
			int delta) {
		// TODO Auto-generated method stub
		if (x <= scrWidth && y <= scrHeight){
			   calcX();
			   calcY();	
			  // System.out.println("update x="+x+" y="+y+"Tiempo= "+tiempo);
			   //render();
			   
			   tiempo+=.2;
		   }
		   else {throwed = false;}
		
	}
	
	
	
	 
	
}
