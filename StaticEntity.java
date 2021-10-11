//static entity


import java.awt.Graphics;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity (Game game, World w, float x, float y, int width, int height) {
		super(game, w, x, y, width, height);
		
	}
	
	public void tick() {
		
	}
	
	public void render (Graphics g) {
		
	}
	
}
