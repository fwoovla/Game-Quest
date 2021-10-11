//cave world class


import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;


public class CaveWorld_1 extends World{
	public CaveWorld_1(Game game, Inventory i, String map_path) {
			super(game, i, map_path);
			
				
	}
	public void addEntities() {
		Random rand = new Random();
//x = x+TILEWIDTH
//y = y+TILEHEIGHT
		entityManager.addEntity(new Rock(game, this, 10*Tile.TILE_WIDTH, 13*Tile.TILE_HEIGHT));

	

	}
	
	public void addAreas() {
		areaManager.addArea(new ToOverEvent(game, this, (int)17 *Tile.TILE_WIDTH, (int)3*Tile.TILE_HEIGHT, 40, 40));
	}
	public void addItems() {
		//Item sword = new SwordItem(game, this,  "sword", 4);
		//sword.setPosition(12*Tile.TILE_WIDTH,12*Tile.TILE_HEIGHT);
		//itemManager.addItem(sword);
		
	}

}
