//home world

//world class


import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;

public class HomeWorld extends World{
	public HomeWorld(Game game, Inventory i, String map_path) {
			super(game, i, map_path);
				
	}
	public void addEntities() {
		entityManager.addEntity(new FloorLamp(game, this, 12*Tile.TILE_WIDTH, 4*Tile.TILE_HEIGHT));
		entityManager.addEntity(new ItemTable(game, this, 4*Tile.TILE_WIDTH, 6*Tile.TILE_HEIGHT));
		entityManager.addEntity(new Table(game, this, 10*Tile.TILE_WIDTH, 6*Tile.TILE_HEIGHT));
		entityManager.addEntity(new Axe(game, this, 10*Tile.TILE_WIDTH, 5*Tile.TILE_HEIGHT));
		
	}
	public void addAreas() {
		areaManager.addArea(new ToOverEvent(game, this, 704, 576, 40, 40));
	}
	
	public void addItems() {

	}

}
