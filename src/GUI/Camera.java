package GUI;

import org.newdawn.slick.tiled.TiledMap;

public class Camera 
{
	int worldWidth;
	int worldHeight;
	
	public Camera(TiledMap map,int mapWidth,int mapHeight)
	{
		worldWidth = map.getWidth();
		worldHeight = map.getHeight();
	}

	public static void translate(Player[] jugador)
	{
		if (jugador[1].getX()+jugador[1].getBounds().getWidth() > 640)
		{
			jugador[0].getFlecha().setX(-20);
			for(Player player: jugador )
			{
				player.setX(player.getX()-20);
			}
			
			
		} 
		/*
		jugador[1].getFlecha().setX(jugador[1].getArrowBounds().x - 200);
		for(Player player: jugador )
		{
			player.setX(player.getX()-200);
		}*/
	}
	
	

	public static void translate2(Player[] jugador)
	{
		
		if (jugador[0].getX()-jugador[0].getBounds().getWidth() < 0)
		{

			jugador[1].getFlecha().setX(+20);

			for(Player player: jugador )
			{
				player.setX(player.getX()+20);
			}
			
			
		} 
		/*
		jugador[1].getFlecha().setX(jugador[1].getArrowBounds().x - 200);
		for(Player player: jugador )
		{
			player.setX(player.getX()-200);
		}*/
	}
	
	
	
	public static boolean isOnCamera(Player jugador)
	{
		if ( jugador.getX() > 0 && jugador.getX() < 460)
		{
			return true;
		}
		else {return false;}
	}
}
