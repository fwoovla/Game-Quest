//UI Manager

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class UIManager {
	
	private Game game;
	private ArrayList<UIObject> objects;
	//try: sepatrate gamemenuobjects and mainmenuobjects
	//in game set uimanager to null when playing, then to uimangaer to this when in menu
	
//constructor
	public UIManager (Game game) {
		this.game = game;
		objects = new ArrayList<UIObject>();
	}
	
	public void tick() {
		for(UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g) {
		for(UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e) {
		for(UIObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : objects)
			o.onMouseRelease(e);
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}
	
}
