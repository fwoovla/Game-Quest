//world class


import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;


public class OverWorld_1 extends World{
	public OverWorld_1(Game game, Inventory i, String map_path) {
			super(game, i, map_path);
			
				
	}
	public void addEntities() {
		Random rand = new Random();
//x = x+TILEWIDTH
//y = y+TILEHEIGHT
	
	//trees
		//for(int num = 0; num < 40; num++) {
			//int spotX = rand.nextInt(20);
			//int spotY = rand.nextInt(10); 
			//entityManager.addEntity(new Tree(game, this, (spotX+2)*Tile.TILE_WIDTH, (spotY+2)*Tile.TILE_HEIGHT));

		//}
		
	//rocks
		for(int num = 0; num < 40; num++) {
			int spotX = rand.nextInt(8);
			int spotY = rand.nextInt(8); 
			entityManager.addEntity(new Rock(game, this, (spotX+28)*Tile.TILE_WIDTH, (spotY+30)*Tile.TILE_HEIGHT));

		}

	//houses	
		entityManager.addEntity(new House(game,this, 13*Tile.TILE_WIDTH, 21*Tile.TILE_HEIGHT));
		entityManager.addEntity(new House(game,this, 13*Tile.TILE_WIDTH, 25*Tile.TILE_HEIGHT));
		entityManager.addEntity(new House(game,this, 22*Tile.TILE_WIDTH, 21*Tile.TILE_HEIGHT));
	//NPCs	
		entityManager.addEntity(new Zombie(game,this, 32*Tile.TILE_WIDTH,11*Tile.TILE_HEIGHT));
		entityManager.addEntity(new NpcSeller(game,this, 12*Tile.TILE_WIDTH,20*Tile.TILE_HEIGHT));
		entityManager.addEntity(new NpcBeachBum(game,this, 2*Tile.TILE_WIDTH,37*Tile.TILE_HEIGHT));
		entityManager.addEntity(new NpcDoctor(game,this, 18*Tile.TILE_WIDTH,20*Tile.TILE_HEIGHT));
		entityManager.addEntity(new NpcWoodBuyer(game,this, 10*Tile.TILE_WIDTH,10*Tile.TILE_HEIGHT));
		entityManager.addEntity(new NpcMiner(game,this, 36*Tile.TILE_WIDTH,34*Tile.TILE_HEIGHT));


	}
	
	public void addAreas() {
		areaManager.addArea(new FairySpawner(game, this, (int)20 *Tile.TILE_WIDTH, (int)20*Tile.TILE_HEIGHT, 40, 40));
		areaManager.addArea(new ToCaveEvent(game, this, (int)15 *Tile.TILE_WIDTH, (int)15*Tile.TILE_HEIGHT, 40, 40));
	}
	public void addItems() {
		//Item sword = new SwordItem(game, this,  "sword", 4);
		//sword.setPosition(12*Tile.TILE_WIDTH,12*Tile.TILE_HEIGHT);
		//itemManager.addItem(sword);
		
	}

}

