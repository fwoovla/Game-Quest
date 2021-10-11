// Game Camera
	


public class GameCamera {
	
	private float xOffset, yOffset;
	public World world;
	public Game game;
	
	public GameCamera(Game g, World w, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.world = world;
		this.game = g;
		//System.out.println(game.getHeight() + "  " + world.getHeight());
	}
	
	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > 40 * Tile.TILE_WIDTH - 800) { //HARDCODED  FIX!!!!
			xOffset = 40 * Tile.TILE_WIDTH - 800;
		}
		if (yOffset < 0) {
			yOffset = 0;
		}else if (yOffset >40 * Tile.TILE_HEIGHT - 600){
			yOffset = 40 * Tile.TILE_HEIGHT - 600;
		}
		
	}
	
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - game.getWidth() /2 + e.getWidth() /2;
		yOffset = e.getY() - game.getHeight() /2 + e.getHeight() /2;
		checkBlankSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}
	public float getyOffset() {
		return yOffset;
	}
	public void setxOffset(float _offset) {
		xOffset = _offset;
	}
	public void setyOffset(float _offset) {
		yOffset = _offset;
	}
	
}
