//Tile class


import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grass_block_1 = new GrassBlock(0);
	public static Tile dirt_block_1 = new DirtBlock(1);
	public static Tile wood_floor = new WoodFloorBlock(3);
	public static Tile boarder = new BoarderBlock(4);
	public static Tile water = new WaterBlock(5);
	public static Tile fountain = new FountainBlock(6);
	public static Tile sand_block = new SandBlock(7);
	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
//constructor
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null); 
	}
	
	public boolean isSolid() {
		return false;
	}
	public int getId() {
		return id;
	}
	
	
}
