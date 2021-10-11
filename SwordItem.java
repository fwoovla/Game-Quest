//Sword Item
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class SwordItem extends Item {
	
	public SwordItem(Game game, World w, String name, int id) {
		super(game, w, name, id); 
		
		//collision box
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;		
		
		strength = 20;
	}
	
	public void tick() {
		if(world.getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(bounds)) {
			pickedUp = true;
			world.getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}

	public void render(Graphics g) {
		render(g,(int)(x - world.getGameCamera().getxOffset()),(int)(y - world.getGameCamera().getyOffset()));
	}
		
	public void render(Graphics g, int x, int y) {
		//g.setColor(Color.red);
		//g.drawRect(x, y, bounds.width, bounds.height);
		g.drawImage(Assets.sword_item,x,y,ITEMWIDTH,ITEMHEIGHT,null);
	}
	public BufferedImage getHoldingImage() {
		return Assets.sword_item;
	}
}
