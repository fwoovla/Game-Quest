//Item Manager
//manages all items in world

import java.awt.Graphics;
import java.util.ArrayList;
import java. util. Iterator;

public class ItemManager {
	
	private Game game;
	private ArrayList<Item> items;
	
	public ItemManager(Game game) {
		this.game = game;
		items = new ArrayList<Item>();
		
	}
	
	public void tick() {
		
		Iterator<Item> it = items.iterator();
		while(it.hasNext()) {
			Item i = it.next();
			i.tick();
			if(i.isPickedUp())
				it.remove();
		}
	}
	
	public void render(Graphics g) {
			for(Item i : items)
				i.render(g);
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
}
