//key manager class


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left,right = false;
	public boolean attack = false;
	public boolean quit, menu, game = false;

	public KeyManager(){
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick() {
		for (int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			}else if (justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}	
		}
		
		if(keyJustPressed(KeyEvent.VK_I)) {
			System.out.println("Inventory");
		}
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		attack = keys[KeyEvent.VK_SPACE];
		
		quit = keys[KeyEvent.VK_P];
		menu = keys[KeyEvent.VK_M];
		game = keys[KeyEvent.VK_G];
	}
	
	public boolean keyJustPressed(int keyCode) {
		if(keyCode < 0 || keyCode > keys.length)
			return false;
		return justPressed[keyCode];
		
	}
		
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length)
			return;
			
		keys[e.getKeyCode()] = true;
		
	}
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	public void keyTyped(KeyEvent e) {
	}
}
