//Item

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public abstract class Item {

	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	public static final int DEFAULT_STRENGTH = 0;
		
	public Game game;
	public World world;
	public GameCamera camera;
	protected String name;
	protected final int id;
	public Random rand;
	protected Rectangle bounds;
		
	protected int x, y, count;
	protected boolean pickedUp = false;
	public int strength;
	
	
//constructor
	public Item(Game game, World w, String name, int id) {
		this.game = game;
		this.world = w;
		this.name = name;
		this.id = id;
		this.strength = DEFAULT_STRENGTH;
		rand = new Random();

		count = 1;
		
		//items[id] = this;
		
		bounds = new Rectangle(x,y, ITEMWIDTH, ITEMHEIGHT);
	}
	
	public abstract void tick();
		
	public abstract void render(Graphics g);
		
	public abstract void render(Graphics g, int x, int y);
	
	public abstract BufferedImage getHoldingImage();
		
	public void setPosition(int _x, int _y) {
		this.x = _x;
		this.y = _y;
		bounds.x = x;
		bounds.y = y;
	}
	
//GETTERS SETTERS

	public boolean isPickedUp() {
		return pickedUp;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getCount() {
		return count;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setX(int _x) {
		x = _x;
	}
	public void setY(int _y) {
		y = y;
	}
	public void setCount(int _c) {
		count = _c;
	}
	public void setName(String _name) {
		name = _name;
	}
	public void setPickedUp(boolean value) {
		pickedUp = value;
	}
	
		
}
