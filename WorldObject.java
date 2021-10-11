//World Objects  
//use just like Tile class
//
//unused!


import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class WorldObject {
	
	public static WorldObject[] tiles = new WorldObject[256];
	public static WorldObject none_object = new NoneObject(4);
	public static WorldObject rock = new Rock(1);
	public static WorldObject tree = new Tree(2);
	public static WorldObject house_1 = new House_1(3);
	
	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
//constructor
	public WorldObject(BufferedImage texture, int id) {
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

