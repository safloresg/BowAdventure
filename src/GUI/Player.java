package GUI;

import org.newdawn.slick.Image;


public abstract class Player implements Renderizable {
	
	protected int contador;
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
	
	
	
	enum Estado{REPOSO,ATACANDO,CARGANDOATAQUE,ATACADO}
	
	public Image getImg(){
		return img;
	}
	
	
	public boolean isMoveMaked(){
		if (estado == Estado.ATACADO) 
		return isMoveMaked;
		else
		return isMoveMaked;
	}
	

	
     
    
}
