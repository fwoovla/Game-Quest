//State


import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;

	public State(Game game) {
		this.game = game;
	}	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
		
	public Game game;
	

	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	public abstract World getWorld();
	public abstract void setWorldToHome();
	public abstract void setWorldToOver();
	public abstract void setWorldToCave();
}
