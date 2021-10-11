//Transition state


import java.awt.Graphics;
import java.awt.Color;

public class TransitionState extends State {

	public long initialTime;
	public long thisTime;
	public int transitionTimer = 1000;
	
	public int colorMod = 0;
	private boolean initialized = false;
	
	public TransitionState(Game game) {
		super(game);
		initialTime = System.currentTimeMillis();

	}
	
	public void tick() {
		if(!initialized) {
			initialTime = System.currentTimeMillis();
			initialized = true;
		}
		thisTime = System.currentTimeMillis();

		System.out.println(thisTime + " - " + initialTime + " = " + (thisTime - initialTime) + "  " + transitionTimer);
		if(thisTime - initialTime > transitionTimer) {
			initialized = false;
			State.setState(game.gameState);
			
							
		}
	}
	
	public void render(Graphics g) {
		colorMod+=3;
		g.setColor(new Color(colorMod%254,colorMod%254,colorMod%254));
		g.fillRect(0,0,game.getWidth(), game.getHeight());
		Text.drawString(g, "transition", 300, 300,false,Color.WHITE, Assets.droid28);

	}
	public void setInitialTime() {
		initialTime = System.currentTimeMillis();
	}
	public void setWorldToOver() {
	}
	public void setWorldToHome() {
	}
	
}
