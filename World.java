//world class


import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;

public abstract class World {
	public Game game;
	public int width, height = 0;
	public int spawnX, spawnY;
	
	public int[][] map;
	
	private GameCamera gameCamera;
	public EntityManager entityManager;
	public ItemManager itemManager;
	public AreaManager areaManager;
	public Hud hud;
	
	
	public World(Game game, Inventory i, String map_path) {
		this.game = game;
		entityManager = new EntityManager(game, new Player(game, i, this,0,0));
		itemManager = new ItemManager(game);
		areaManager = new AreaManager(game);
		hud = new Hud(game);
		gameCamera = new GameCamera(game,this,0,0);
		
		map = loadWorld(map_path);
		
		
	//add entities
		addEntities();
	//add items
		addItems();
	//add areas
		addAreas();
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

	}

//parse through files
	private int[][] loadWorld(String map_path) {
		
		int tiles[][];
		String map_file = Utills.loadFileAsString(map_path);
		String[] map_tokens = map_file.split("\\s+");
		
		
		width = Utills.parseInt(map_tokens[0]);
		height = Utills.parseInt(map_tokens[1]);
		spawnX = Utills.parseInt(map_tokens[2]);
		spawnY = Utills.parseInt(map_tokens[3]);
		
		String tokens = map_tokens.toString();
		//System.out.print(tokens);
		tiles = new int[width][height];
		
		for (int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				tiles[x][y] = Utills.parseInt(map_tokens[(x + y * width) +4]);
			}
		}

		return tiles;
	}
	
	public void tick() {
		itemManager.tick();
		entityManager.tick();
		areaManager.tick();
		hud.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int)Math.max(0,getGameCamera().getxOffset() /Tile.TILE_WIDTH); //set visible area to draw
		int xEnd = (int)Math.min(width, (getGameCamera().getxOffset() + game.getWidth())/ Tile.TILE_WIDTH +1);
		int yStart = (int)Math.max(0,(getGameCamera().getyOffset()) /Tile.TILE_HEIGHT);
		int yEnd = (int)Math.max(height,(getGameCamera().getyOffset()) /Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x,y).render(g, (int)(x*64 - getGameCamera().getxOffset()), (int)(y*64 - getGameCamera().getyOffset()));
				//getTile(x,y).render(g, (int)(x*64 - game.getCamera().getxOffset()), (int)(y*64 - game.getCamera().getyOffset()));
			}
		}
	//draw
		itemManager.render(g);
		entityManager.render(g);
		areaManager.render(g);
		hud.render(g);
	//end draw
	}
	
	public Tile getTile(int x, int y) {
		
		if(x<0 || y < 0 || x >= width || y >= height)
			return Tile.grass_block_1;
			
		Tile t = Tile.tiles[map[x][y]];
		if (t == null) 
			return Tile.grass_block_1;
		return t;
	}
	
	//public WorldObject getObject(int x, int y) {
		
		//if(x<0 || y < 0 || x >= width || y >= height)
			//return WorldObject.none_object;
			
		//WorldObject o = WorldObject.tiles[objects[x][y]];
		//if (o == null) 
			//return WorldObject.none_object;
		//return o;
	//}
	
	public int getSpawnX() {
			return spawnX;
	}
	
	public int getSpawnY() {
		return spawnY;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public ItemManager getItemManager() {
		return itemManager;
	}
	public AreaManager getAreaManager() {
		return areaManager;
	}
	public GameCamera getGameCamera() {
		return gameCamera;
	}
		
	public abstract void addEntities();

	public abstract void addAreas(); 
		

	public abstract void addItems();

}
