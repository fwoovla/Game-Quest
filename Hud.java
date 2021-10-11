//HUD class

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class Hud {
	
	public Game game;
	private BufferedImage item;
	private String health;
	public String cash;
	
	public Hud(Game game) {
		this.game = game;
	}
	
	public void tick() {

	}
	
	public void render(Graphics g) {
		
	//first set the correct item
		if(game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name == "axe") {
			item = Assets.axe_item;			
		}
		if(game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name == "wood") {
			item = Assets.wood_item;
		}
		if(game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name == "rock") {
			item = Assets.rock_item;
		}
		if(game.getState().getWorld().getEntityManager().getPlayer().getCurrentItem().name == "sword") {
			item = Assets.sword_item;
		}
	//item
		g.drawImage(Assets.hudframe, 5, 5, 64, 64, null);
		g.drawImage(item, 5, 5, 64, 64, null);
		Text.drawString(g, "Item", 40, 85,true,Color.WHITE, Assets.droid28);
	//health	
		health = Integer.toString(game.getState().getWorld().getEntityManager().getPlayer().health);
		g.drawImage(Assets.hudframe,200 ,5 , 64, 64, null);
		Text.drawString(g, health, 230, 35,true,Color.WHITE, Assets.droid28);
		Text.drawString(g, "Health", 250, 85,true,Color.WHITE, Assets.droid28);
	//cash
		cash = Integer.toString(game.getState().getWorld().getEntityManager().getPlayer().cash);
		g.drawImage(Assets.hudframe, 400, 5, 64, 64, null);
		Text.drawString(g, cash, 430, 35,true,Color.WHITE, Assets.droid28);
		Text.drawString(g, "Cash", 450, 85,true,Color.WHITE, Assets.droid28);
	}
}
