//AreaManager class

import java.awt.Graphics;
import java.util.ArrayList;
import java. util. Iterator;

public class AreaManager {
	
	private Game game;
	private Player player;
	private ArrayList<EventArea> areas;
	
	public AreaManager(Game game) {
		this.game = game;
		areas = new ArrayList<EventArea>();	
	}
	
	public void tick() {
		Iterator<EventArea> it = areas.iterator();
		while(it.hasNext()){
			EventArea e = it.next();
			e.tick();
			if(e.isOver) {
				System.out.println("In Area");
				//it.remove();
			}
		}
	}
	public void render(Graphics g) {
		for (EventArea e : areas) {
			e.render(g);
		}
	}
	public void addArea(EventArea e) {
		areas.add(e);
	}
	
	public void setPlayer(Player p) {
		this.player = player;
	}
	public void setAreas(ArrayList<EventArea> alist) {
		this.areas = alist;
	}
	public Player getPlayer() {
		return player;
	}
	public ArrayList<EventArea> getAreas() {
		return areas;
	}
	
}


