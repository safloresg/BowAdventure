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
	
	
	
	public boolean isOnCamera(Player jugador)
	{
		return true;
	}
}
