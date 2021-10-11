//Creature class



public abstract class Creature extends Entity{
	
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;

	protected float speed;
	protected float xMove, yMove = 0;
	
	public Creature(Game game, World w,float x, float y, int width, int height) {
		super(game, w, x, y, width, height);
		this.speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
	}
	
	public void move() {
		
		if (!checkEntityCollisions(xMove, 0f))
			moveX(); //move and check collision
		if(!checkEntityCollisions(0f, yMove))
			moveY(); //move and check collision
	}
	
	public void moveX() {
		
		if (xMove > 0) {//moving right check
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			
			if (!collisionWithTile(tx, (int) (y + bounds.y) /Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y +bounds.height) /Tile.TILE_HEIGHT)){
				x += xMove;
				
			}else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
			
		}else if(xMove < 0) {//moving left check
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			
			if (!collisionWithTile(tx, (int) (y + bounds.y) /Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y +bounds.height) /Tile.TILE_HEIGHT)){
				x += xMove;
			} else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
	}
	
	public void moveY() { //moving up check
		if(yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) /Tile.TILE_HEIGHT;
			
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
			
		}else if(yMove > 0) { //moving down check
			int ty = (int) (y + yMove + bounds.y +bounds.height) /Tile.TILE_HEIGHT;
			
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height -1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		//if (handler.getWorld().getObject(x,y).isSolid()) {
			//return true;
		//}
		if (world.getTile(x,y).isSolid()) {
			return true;
		}
				
		return false;
		
	}
	
	public void setSpeed(float _s) {
		this.speed = _s;
	}
	
	public void setHealth(int _h) {
		this.health = _h;
	}
	
	public float getSpeed() {
		return speed;
	}
	
	public int getHealth() {
		return health;
	}
	
	public float getXmove(){
		return xMove;
	}
	
	public float getYmove() {
		return yMove;
	}
	
	public void setXmove(float _xm) {
		this.xMove = _xm;
	}
	
	public void setYmove(float _ym) {
		this.yMove = _ym;
	}
	
}
