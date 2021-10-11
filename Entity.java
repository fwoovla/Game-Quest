//Entity Class


import java.awt.Graphics;
import java.awt.Rectangle;
public abstract class Entity {
	
	
	protected Game game;
	protected World world;
	public static final int DEFAULT_HEALTH = 100;
	protected int health;
	protected float x,y;
	protected int width, height;
	protected boolean active = true;
	protected Rectangle bounds;
	public boolean hurting = false;

	public long lastAttackTime;
	public int attackCooldown = 100;
	public long currentAttackTime;
	
	public long lastHurtTimer;
	public int hurtCooldown = 100;
	public long currentHurtTime;
	
	public Entity(Game game, World w, float x, float y, int width, int height) {
		this.game = game;
		this.world = w;
		this.health = DEFAULT_HEALTH;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		bounds = new Rectangle(0,0, width, height);
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : world.getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
				return true;
		}
		return false;
	}
	
	public void hurt(Item i) {
		System.out.println("entity hurt");
		health -=i.strength;
		flashHurt();
		if (health <= 0) {
			active = false;
			die();
		}
	}
	public void hurt(int value) {
		health = health- value;
	}
	
	public void flashHurt() {
		hurting = true;
	}
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y +yOffset), bounds.width, bounds.height);
	}
//GETTERS SETTERS

	public boolean isActive(){
		return active;
	}
	public void setActive(boolean a) {
		active = a;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health = h;
	}
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setWidth(int _w) {
		this.width = _w;
	}
	
	public void setHeight(int _h) {
		this.height = _h;
	}
	
	public void setX(int _x) {
		this.x = _x;
	}
	
	public void setY(int _y) {
		this.y = _y;
	}
}

