//table entity

import java.awt.Graphics;
import java.awt.Color;

public class Table extends StaticEntity {
	
	public Table(Game game, World w, float x, float y) {
		super(game, w, x, y, Tile.TILE_WIDTH *2, Tile.TILE_HEIGHT); 
		
		//collision box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 128;
		bounds.height = 64;
	}
	
	public void tick() {
		
	}

	public void die() {
		Item drop = new WoodItem(game, world, "wood", 1);
		drop.setPosition((int)x +width/3, (int)y+height/2);
		world.getItemManager().addItem(drop);
		System.out.println("health gone");
	}
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.table,(int) (x - world.getGameCamera().getxOffset()),(int) (y - world.getGameCamera().getyOffset()), width, height, null);
		
		g.setColor(Color.red);
		g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);

		if(currentHurtTime - lastHurtTimer > hurtCooldown) {
			//System.out.println("resting");
			hurting = false;
			lastHurtTimer = currentHurtTime;
			//return;
		}
		if(hurting) {
			g.drawImage(Assets.hurtImg,(int)(x - world.getGameCamera().getxOffset()), (int)(y+height/2 - world.getGameCamera().getyOffset()), 64, 64, null);
			hurting = false;
		}

	}
}
