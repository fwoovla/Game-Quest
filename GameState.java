//Game State



import java.awt.Graphics;

public class GameState extends State {
	
	public World thisWorld;
	public World overworld_1;
	public World home;
	public World caveworld;
	public Inventory globalInventory;

	private static final int MAP1 = 0, HOUSE = 1;
	public int mapSelected;

	public GameState(Game game) {
		super(game);
		
		globalInventory = new Inventory(game);
		
		overworld_1 = new OverWorld_1(game, globalInventory ,"res/Maps/overworld1.txt");
		home = new HomeWorld(game, globalInventory ,"res/Maps/house_map.txt");
		caveworld = new CaveWorld_1(game, globalInventory, "res/Maps/cave_map_1.txt");
		setWorld(home);
		

	}
	
	public void tick() {
		thisWorld.tick();
		//overworld_1.tick();
		game.getKeyManager().tick();
			
		if(game.getKeyManager().menu == true) {
			State.setState(game.menuState);
				
		}
	}
	
	public void render(Graphics g) {
		thisWorld.render(g);

	}
	public void setWorld(World w) {
		thisWorld = w;
	}
	public void setWorldTo(World w) {
		setWorld(w);
	}
	public World getWorld() {
		return thisWorld;
	}
	public void setWorldToHome() {
		thisWorld = home;
		thisWorld.getEntityManager().getPlayer().setX((int)thisWorld.getEntityManager().getPlayer().getX() + Tile.TILE_WIDTH);
		thisWorld.getEntityManager().getPlayer().setX((int)thisWorld.getEntityManager().getPlayer().getY() + Tile.TILE_HEIGHT);
	}
	public void setWorldToOver() {
		thisWorld = overworld_1;
		thisWorld.getEntityManager().getPlayer().setX((int)thisWorld.getEntityManager().getPlayer().getX() + Tile.TILE_WIDTH);
		thisWorld.getEntityManager().getPlayer().setX((int)thisWorld.getEntityManager().getPlayer().getY() + Tile.TILE_HEIGHT);
	}
	public void setWorldToCave() {
		thisWorld = caveworld;
		thisWorld.getEntityManager().getPlayer().setX((int)thisWorld.getEntityManager().getPlayer().getX() + Tile.TILE_WIDTH);
		thisWorld.getEntityManager().getPlayer().setX((int)thisWorld.getEntityManager().getPlayer().getY() + Tile.TILE_HEIGHT);
	}
	public Inventory getInventory() {
		return globalInventory;
	}
}
