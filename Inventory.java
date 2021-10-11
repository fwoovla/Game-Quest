//inventory

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class Inventory{
	
	private Game game;
	private boolean active = false;
	
	
	private ArrayList<Item> inventoryItems;
	private int index = 0;
	
	public Inventory(Game game) {
		this.game = game;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void tick() {
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_I)) {
			active = !active;
		}
		
		if(!active)
			return;
		
		
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_1)) {
			if(inventoryItems.size() > 0) {
				game.getState().getWorld().getEntityManager().getPlayer().setCurrentItem(inventoryItems.get(0));
				System.out.println("selected " +game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name);
				active = !active;
			}
		}
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_2)) {
			if(inventoryItems.size() > 1) {
				game.getState().getWorld().getEntityManager().getPlayer().setCurrentItem(inventoryItems.get(1));
				System.out.println("selected " +game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name);
				active = !active;

			}
		}
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_3)) {
			if(inventoryItems.size() > 2) {
				game.getState().getWorld().getEntityManager().getPlayer().setCurrentItem(inventoryItems.get(2));
				System.out.println("selected " +game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name);
				active = !active;

			}
		}
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_4)) {
			if(inventoryItems.size() > 3) {
				game.getState().getWorld().getEntityManager().getPlayer().setCurrentItem(inventoryItems.get(3));
				System.out.println("selected " +game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name);
				active = !active;

			}
		}
		if(game.getKeyManager().keyJustPressed(KeyEvent.VK_5)) {
			if(inventoryItems.size() > 4) {
				game.getState().getWorld().getEntityManager().getPlayer().setCurrentItem(inventoryItems.get(4));
				System.out.println("selected " +game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name);
				active = !active;

			}
		}
		//if(inventoryItems.size() > 0) {	
			//if(game.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
				//index-=1;
				//if(index <  0) {
					//index = inventoryItems.size()-1;
					//System.out.println(inventoryItems.get(index).getName());
				//}
			//}
			//if(game.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
				//index+=1;
				//if(index > inventoryItems.size()-1) {
					//index = 0;
					//System.out.println(inventoryItems.get(index).getName());
				//}
			//}
		
		
		//for(Item i : inventoryItems) {
			//System.out.println(i.getName() + "  " + i.getCount());
		//}
	}
	public void render(Graphics g) {
		
		if(!active)
			return;	

		g.drawImage(Assets.inventoryScreen, 200, 200, 400, 600, null);
		
		int line = 1;
		for(Item i : inventoryItems) {
			
			String count = Integer.toString(i.getCount());
			Text.drawString(g, Integer.toString(line)+ ":", 250, (line*50) + 300,false,Color.WHITE, Assets.droid28);
			Text.drawString(g, i.getName(), 300, (line*50) + 300,false,Color.WHITE, Assets.droid28);
			Text.drawString(g, count, 400, (line*50) + 300,false,Color.WHITE, Assets.droid28);
			//System.out.println(i.getName() + "  " + i.getCount());
			line++;
		}
		//Text.drawString(g, "Rocks", 300,300,false,Color.WHITE, Assets.droid28);
	}
	
	
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	public void removeAllItems(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(0);
				return;
			}
		}
		inventoryItems.remove(item);	
	}
	public boolean isActive() {
		return active;
	}
	
}
