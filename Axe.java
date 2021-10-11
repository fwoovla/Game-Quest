//axe static entity


import java.awt.Graphics;
import java.awt.Color;

public class Axe extends StaticEntity {
	
	public Axe(Game game, World w, float x, float y) {
		super(game, w, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT); 
		health = 1;
		//collision box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
		width = 32;
		height = 32;
	}
	
	public void tick() {
		

	}

	public void die() {
		
			Item drop = new AxeItem(game, world, "axe", 3);
			world.getEntityManager().getPlayer().getInventory().addItem(drop);
		
		}
	
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.axe_item,(int) (x - world.getGameCamera().getxOffset()),(int) (y - world.getGameCamera().getyOffset()), width, height, null);
		
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
