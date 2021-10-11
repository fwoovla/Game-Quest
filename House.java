//House Static Object


import java.awt.Graphics;
import java.awt.Color;

public class House extends StaticEntity {
	
	public House(Game game, World w, float x, float y) {
		super(game, w, x, y, Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 3  ); 
		
		//collision box
		bounds.x = 30;
		bounds.y = 30;
		bounds.width = 130;
		bounds.height = 130;
	}
	
	public void tick() {
		
	}
	
	public void die() {
		
	}
	
	public void hurt(int value) {
		System.out.println("You cant hurt a house");
	}
	public void render(Graphics g) {
		
		g.drawImage(Assets.house_1,(int) (x - world.getGameCamera().getxOffset()),(int) (y - world.getGameCamera().getyOffset()), width, height, null);
		
		g.setColor(Color.red);
		g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);

		if(currentHurtTime - lastHurtTimer > hurtCooldown) {
			//System.out.println("resting");
			hurting = false;
			lastHurtTimer = currentHurtTime;
			//return;
		}
		if(hurting) {
			g.drawImage(Assets.hurtImg,(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
			hurting = false;
		}

	}
}
