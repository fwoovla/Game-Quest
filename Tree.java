//Tree 
//static object

import java.awt.Graphics;
import java.awt.Color;

public class Tree extends StaticEntity {
	
	public Tree(Game game, World w, float x, float y) {
		super(game, w, x, y, Tile.TILE_WIDTH *2 , Tile.TILE_HEIGHT *2 ); 
		
		//collision box
		bounds.x = 20;
		bounds.y = 20;
		bounds.width = 80;
		bounds.height = 80;
	}
	
	public void tick() {
		currentHurtTime = System.currentTimeMillis();
	}

	public void die() {
		Item drop = new WoodItem(game, world, "wood", 2);
		drop.setPosition((int)x+32, (int)y+32);
		world.getItemManager().addItem(drop);
		System.out.println("health gone");
	}
	
	public void hurt(Item i) {
		if(i.name != "axe") {
			System.out.println("wrong item");
			return;
		}
		System.out.println("entity hurt");
		health -=i.strength;
		flashHurt();
		if (health <= 0) {
			active = false;
			die();
		}
	}
		
	public void render(Graphics g) {
		
		g.drawImage(Assets.tree,(int) (x - world.getGameCamera().getxOffset()),(int) (y - world.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.red);
		//g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);

		if(currentHurtTime - lastHurtTimer > hurtCooldown) {
			//System.out.println("resting");
			hurting = false;
			lastHurtTimer = currentHurtTime;
			//return;
		}
		if(hurting) {
			g.drawImage(Assets.hurtImg,(int)(x+32 - world.getGameCamera().getxOffset()), (int)(y+32 - world.getGameCamera().getyOffset()), 64, 64, null);
		}

	}
}
