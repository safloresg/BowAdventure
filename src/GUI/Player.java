package GUI;

import org.newdawn.slick.Image;


public abstract class Player implements Renderizable {
	
	int contador;
	Flecha arrow;
	//Barra donde se carga la fuerza con que es lanzada una flecha
	LoadBar barra;
	//Coordenadas en x del arquero
	float coordinateX;
	//Coordenadas en y del arquero
	float coordinateY;
	//true si se esta cargando un ataque
	boolean loading;
	//true si se el arquero esta atacando
	boolean attacking;
	//Sprite de arquero
	Image img;
	//Estado en el que se encuentra el arquero(reposo,atacando,cargandoAtaque,Atacado)
	Estado estado;
	
	enum Estado{REPOSO,ATACANDO,CARGANDOATAQUE,ATACADO}
	
	public Image getImg(){
		return img;
	}

	
     
    
}
