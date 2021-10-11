//Rock Static Entity


import java.awt.Graphics;
import java.awt.Color;

public class Rock extends StaticEntity {
	
	public Rock(Game game, World w, float x, float y) {
		super(game, w, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT); 
		
		//collision box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 64;
		bounds.height = 64;
	}
	
	public void tick() {
		currentHurtTime = System.currentTimeMillis();

	}

	public void hurt(Item i) {
		if(i.name != "pickaxe") {
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
	public void die() {
		Item drop = new RockItem(game, world, "rock", 1);
		drop.setPosition((int)x +width/3, (int)y+height/3);
		world.getItemManager().addItem(drop);
		System.out.println("health gone");
	}
	
	
	public void render(Graphics g) {
		
		g.drawImage(Assets.rock,(int) (x - world.getGameCamera().getxOffset()),(int) (y - world.getGameCamera().getyOffset()), width, height, null);
		
		//g.setColor(Color.red);
		//g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
		if(currentHurtTime - lastHurtTimer > hurtCooldown) {
			//System.out.println("resting");
			hurting = false;
			lastHurtTimer = currentHurtTime;
			//return;
		}
		if(hurting) {
			g.drawImage(Assets.hurtImg,(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}

	}
}
