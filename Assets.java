//assets


import java.awt.image.BufferedImage;
import java.awt.Font;

public class Assets {
	
//screens
//entities
	public static BufferedImage tree, rock, house_1, floor_lamp, item_table, table;
	public static BufferedImage[] playerAni = new BufferedImage[4];
	
	
//NPCs / Mobs
	public static BufferedImage[] zombieAni = new BufferedImage[4];
	public static BufferedImage[] npc_1_Ani = new BufferedImage[4];
	
	
//items
	public static BufferedImage 
	hurtImg,
	sword_item,
	wood_item,
	axe_item, 
	rock_item;
//tiles
	public static BufferedImage 
	bg_grass, 
	grass_block_1, 
	grass_block_2, 
	grass_block_3, 
	wood_floor,
	sand_block,
	dirt_block_1, 
	boarder, 
	water_tile_1, 
	fountain;
//UIObjects
	public static BufferedImage start_button;
	
//backgrounds / screens
	public static BufferedImage title_bg, hudframe;
	public static BufferedImage inventoryScreen;

//fonts
	public static Font droid28, droid14;
	
	public static void init(){
//fonts
		droid28 = FontLoader.loadFont("res/fonts/TYPEWR__.ttf", 28);
		droid14 = FontLoader.loadFont("res/fonts/TYPEWR__.ttf", 14);
//screens and BGs
		title_bg = ImageLoader.loadImage("res/title_bg_1.jpg");		
		inventoryScreen = ImageLoader.loadImage("res/inventory_screen.png");		
		hudframe = ImageLoader.loadImage("res/hud_frame.png");
		start_button = ImageLoader.loadImage("res/start_button.png");
//characters
		hurtImg = ImageLoader.loadImage("res/textures/hit.png");
		
		playerAni[0] = ImageLoader.loadImage("res/textures/player/player_up.png");
		playerAni[2] = ImageLoader.loadImage("res/textures/player/player_down.png");
		playerAni[3] = ImageLoader.loadImage("res/textures/player/player_left.png");
		playerAni[1] = ImageLoader.loadImage("res/textures/player/player_right.png");

//NPCs /MOBS
		zombieAni[0] = ImageLoader.loadImage("res/textures/mobs/zombie_up.png");
		zombieAni[1] = ImageLoader.loadImage("res/textures/mobs/zombie_right.png");
		zombieAni[2] = ImageLoader.loadImage("res/textures/mobs/zombie_down.png");
		zombieAni[3] = ImageLoader.loadImage("res/textures/mobs/zombie_left.png");

		npc_1_Ani[0] = ImageLoader.loadImage("res/textures/npcs/npc_1_up.png");
		npc_1_Ani[1] = ImageLoader.loadImage("res/textures/npcs/npc_1_right.png");
		npc_1_Ani[2] = ImageLoader.loadImage("res/textures/npcs/npc_1_down.png");
		npc_1_Ani[3] = ImageLoader.loadImage("res/textures/npcs/npc_1_left.png");
	
//map tiles
		boarder = ImageLoader.loadImage("res/rock_tile.png");
		bg_grass = ImageLoader.loadImage("res/grass_bg.png");
		wood_floor = ImageLoader.loadImage("res/floor_tile.png");
		sand_block = ImageLoader.loadImage("res/sand_tile.png");
		grass_block_1 = ImageLoader.loadImage("res/Grass_block_1.png");
		grass_block_2 = ImageLoader.loadImage("res/Grass_block_2.png");
		grass_block_3 = ImageLoader.loadImage("res/Grass_block_3.png");
		dirt_block_1 = ImageLoader.loadImage("res/Dirt_block_1.png");
		water_tile_1 = ImageLoader.loadImage("res/water_tile_1.png");
		fountain = ImageLoader.loadImage("res/fountain_tile_1.png");
		
//map entities				
		tree = ImageLoader.loadImage("res/entities/tree_1.png");
		rock = ImageLoader.loadImage("res/entities/grey_rock.png");
		house_1 = ImageLoader.loadImage("res/entities/house_1.png");
		floor_lamp = ImageLoader.loadImage("res/entities/floor_lamp.png");
		item_table = ImageLoader.loadImage("res/entities/item_table.png");
		table = ImageLoader.loadImage("res/entities/table.png");
		
//items
		wood_item = ImageLoader.loadImage("res/entities/wood_item.png");
		rock_item = ImageLoader.loadImage("res/entities/rock_item.png");
		axe_item = ImageLoader.loadImage("res/entities/axe_item.png");
		sword_item = ImageLoader.loadImage("res/entities/sword_item.png");

	}
	
}
