//EventArea Class


import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class EventArea {
	
	public Rectangle bounds;
	protected Game game;
	protected World world;
	protected float x,y;
	protected int width, height;
	protected boolean active = true;
	protected  boolean isOver = false;
	public static final int AREAWIDTH = 32, AREAHEIGHT = 32;
	
	public EventArea(Game game, World w, float x, float y, int width, int height) {
		this.game = game;
		this.world = w;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		bounds = new Rectangle(0,0, width, height);
		
	}
	public abstract void tick();
	
	public abstract void render(Graphics g);
		
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : world.getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
				return true;
		}
		return false;
	}
		

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y +yOffset), bounds.width, bounds.height);
	}

	public boolean isActive(){
		return active;
	}
	public void setActive(boolean a) {
		active = a;
	}
	public boolean getIsOver() {
		return isOver;
	}
	public void setIsOver(boolean value) {
		isOver = value;
	}

}
