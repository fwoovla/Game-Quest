//to cave event

//World change event

//


import java.awt.Graphics;
import java.awt.Color;

public class ToCaveEvent extends EventArea {
	

	public ToCaveEvent(Game game, World w, float x, float y, int width, int height) {
		super(game, w, x, y, width, height);
	}

	
	public void tick() {
		if(world.getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(getCollisionBounds(0,0))) {
			isOver = true;
			System.out.println("going to cave");
			
			//this is how to switch scenes from here
			State.getState().setWorldToCave();
			State.setState(game.transitionState);
		} else {
			isOver = false;
		}
	}	
	
	public void render(Graphics g) {
		render(g,(int)(x - world.getGameCamera().getxOffset()),(int)(y - world.getGameCamera().getyOffset()));
	}
		
	public void render(Graphics g, int x, int y) {
		g.setColor(Color.red);
		g.drawRect(x, y, bounds.width, bounds.height);
		//g.drawRect((int)(x - world.getGameCamera().getxOffset()),(int)(y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);
		//g.drawImage(Assets.wood_item,x,y,AREAWIDTH,AREAHEIGHT,null);
	}
	
}
