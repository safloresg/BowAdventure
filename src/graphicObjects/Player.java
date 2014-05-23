package graphicObjects;

import java.awt.Rectangle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import GUI.Flecha;
import GUI.Renderizable;


public abstract class Player implements Renderizable {
	
	protected int contador;
	protected int puntos;
	protected Flecha arrow;
	//Barra donde se carga la fuerza con que es lanzada una flecha
	protected LoadBar barra;
	//Coordenadas en x del arquero
	protected float coordinateX;
	//Coordenadas en y del arquero
	protected float coordinateY;
	//true si se esta cargando un ataque
	protected boolean loading;
	//true si se el arquero esta atacando
	protected boolean attacking;
	//Sprite de arquero
	protected Image img;
	//Estado en el que se encuentra el arquero(reposo,atacando,cargandoAtaque,Atacado)
	protected Estado estado;
	// true si el jugador hizo algun ataque.
	protected boolean isMoveMaked;
	// Imagen de la flecha
	protected Image flechaImg;
	// Direccion hacia la que ataque el jugador creado
	protected boolean direccion;
	
	protected float angulo;
	
	enum Estado{REPOSO,ATACANDO,CARGANDOATAQUE,ATACADO}
	public Player(){}
	public Player(Image img,int x,int y,Image flechaImg,boolean direccion){
		puntos = 0;
		this.img = img;
		coordinateX = x;
    	coordinateY = y;
    	attacking = false;
		barra = new LoadBar();
		estado = Estado.REPOSO;
		this.flechaImg = flechaImg;
		arrow = new Flecha(flechaImg,direccion);
		this.direccion = direccion;
	}
	
	public Image getImg(){
		return img;
	}
	
    public void init ()
    {
    	estado = Estado.REPOSO;
    }
    
    public void render(GameContainer gc, StateBasedGame stateGame, Graphics g ){
		img.draw(coordinateX,coordinateY);
		
    	g.drawString(""+img.getRotation(), 200, 20);	
    	
    	switch(estado){
		case ATACADO:
			break;
		case ATACANDO:
			arrow.render(gc, stateGame, g);
			break;
		case CARGANDOATAQUE:
			barra.render();
			break;
		case REPOSO:
			break;
		default:
			break;
    	 
    	
    	}
	}
    

	public void update(GameContainer gc,StateBasedGame stateGame, int delta){
		Input input = gc.getInput();
		
        switch(estado){
        
        case REPOSO :
        	if (input.isKeyDown(Input.KEY_SPACE) )
        	{
            	estado = Estado.CARGANDOATAQUE;
            	barra.init(coordinateX, coordinateY);
        	}
        	break;
        case CARGANDOATAQUE :
        	if (input.isKeyDown(Input.KEY_SPACE))
        	{
        		barra.update();
        		//estado = Estado.ATACANDO;        		
        	}else
        	{
        		estado = Estado.ATACANDO;
				arrow.init(gc, coordinateX, coordinateY,getAngle(), barra.getVelocidad());
        	}
        	break;
        case ATACANDO :
        	// Si hay un ataque en curso se actualiza el juego , si no, se cambia el estado a REPOSO
        	if (arrow.isThrowed())
        	{
        		arrow.update(gc, stateGame, delta);
        	}else
        		estado = Estado.ATACADO;
        	break;
		case ATACADO:
			break;
		default:
			break;
        }
     
        	if (input.isKeyPressed(Input.KEY_UP) && getAngle() < 90)
        	{
        		if (direccion)
        		img.rotate(-5);
        		else 
        		img.rotate(5);
        	}
		
        	if (input.isKeyPressed(Input.KEY_DOWN) && getAngle() > 0)
			{
        		if (direccion)
        		img.rotate(5);
        		else img.rotate(-5);
			}
        
		
	}
	
	
	
	public boolean isMoveMaked(){
		if (estado == Estado.ATACADO) 
		return true;
		else
		return false;
	}
	

	public void setFlechaImg(Image img){
		this.flechaImg = img;
		
	}
	
	public void setFlechaDireccion (boolean direccion)
	{
		this.direccion = direccion;
	}
	
	public float getAngle ()
	{
		if (direccion)
		{
			return img.getRotation()*-1;
		}else
		return img.getRotation();
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)coordinateX,(int)coordinateY,img.getWidth(),img.getHeight());
	} 
	
	public Rectangle getArrowBounds(){
		return arrow.getBounds();
	}
	
	public boolean collision(){
		return getBounds().intersects(arrow.getBounds());
	}
	
	public void addPunto(){
		puntos++;
	}
	
	public int getPuntos(){
		return puntos;
		
	}
	
	public float getX(){
		return coordinateX;
	}
	
	public float getY(){
		return coordinateY;
	}
	
	public void setX(float x){
		this.coordinateX = x;
	}
	
	public void setY(float y)
	{
		this.coordinateY = y;
	}
	
	public Flecha getFlecha()
	{
		return arrow;
	}
    
}
