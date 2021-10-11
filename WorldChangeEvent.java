//World change event

//


import java.awt.Graphics;
import java.awt.Color;

public class ToOverEvent extends EventArea {
	

	public ToOverEvent(Game game, World w, float x, float y, int width, int height) {
		super(game, w, x, y, width, height);
	}

	
	public void tick() {
		if(world.getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(getCollisionBounds(0,0))) {
			isOver = true;
			System.out.println("going to overworld");
			
			//this is how to switch scenes from here
			//State.getState().setWorldToHome();
			//System.out.println(State.getState()); //.setWorldToHome();
		} else {
			isOver = false;
		}
	}	
	
	public void render(Graphics g) {
		render(g,(int)(x - world.getGameCamera().getxOffset()),(int)(y - world.getGameCamera().getyOffset()));
	}
		
	public void render(Graphics g, int x, int y) {
		//g.setColor(Color.red);
		//g.drawRect(x, y, bounds.width, bounds.height);
		//g.drawRect((int)(x - world.getGameCamera().getxOffset()),(int)(y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);
		//g.drawImage(Assets.wood_item,x,y,AREAWIDTH,AREAHEIGHT,null);
	}
	
}
