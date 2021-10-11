//Entity Manager


import java.awt.Graphics;
import java.util.ArrayList;
import java. util. Iterator;

public class EntityManager {
	
	private Game game;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityManager(Game game, Player player) {
		this.game = game;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			e.tick();
			if(!e.isActive()) {
				it.remove();
			}
		}
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		player.postRender(g);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void setPlayer(Player p) {
		this.player = player;
	}
	public void setEntities(ArrayList<Entity> elist) {
		this.entities = elist;
	}
	public Player getPlayer() {
		return player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
}

