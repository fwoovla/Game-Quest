//Handler class


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Handler {
	
	private Game game;
	private World world;

	
	public Handler(Game game) {
		this.game = game;
	}
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	public int getWidth() {
		return game.getWidth();
	}
	public int getHeight() {
		return game.getHeight();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	public Game getGame() {
		return game;
	}
	public World getWorld() {
		return world;
	}
	public void setGame(Game g) {
		this.game = g;
	}
	public void setWorld(World w) {
		this.world = w;
	}
}
