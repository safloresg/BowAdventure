package GUI;

import javax.management.timer.Timer;

public class Reloj {
	
	private double tiempoIni=0;
	private double tiempo=0;
	
	public void iniciar(){
		tiempoIni = System.nanoTime();
		tiempo = 0;
		
	}
	
	public float getTiempo(){
		tiempo = System.nanoTime()-tiempoIni;
		
		return (float) tiempo/1000000000;
	}
	
	
	
	

}
