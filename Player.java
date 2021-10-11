//Player class


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;


public class Player extends Creature {
	
	public static final int UP_DIR = 0;
	public static final int RIGHT_DIR = 1;	
	public static final int DOWN_DIR = 2;
	public static final int LEFT_DIR = 3;
	private int dir = 1;
	private boolean attack = false;
	
	private long lastAttackTime;
	private int attackCooldown = 200;
	Rectangle ar = new Rectangle();
	
	private Inventory inventory;
	public Item currentItem;
	public String hurtValue;
	public int cash = 0;


	public Player(Game game, Inventory i, World w, float x, float y) {
		super(game, w, x, y, 32, 32);
		
		//world = null;
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
		currentItem = new BareHandsItem(game, w, "bare hands", 0);
		inventory = i;
	}
	
	public void tick() {
		

	//movement
		getInput();
																														
		if(!inventory.isActive()) {
			move();
			}
		world.getGameCamera().centerOnEntity(this);
	//attack
		checkAttacks();

		inventory.tick();
	}
	
	private void checkAttacks() {
		if(inventory.isActive()) {
			return;
			}
		currentAttackTime = System.currentTimeMillis();
		
		if(currentAttackTime - lastAttackTime < attackCooldown) {
			attack = false;
			return;
		}else {			
			lastAttackTime = currentAttackTime;
		}		

		Rectangle cb = this.getCollisionBounds(0,0);
		
		int arSize = 20;
		ar.x = cb.x - 10;
		ar.y = cb.y - 10;
		ar.width = arSize;
		ar.height = arSize;			
		
		int xAttack,yAttack = 0;
		
		if(attack) {
			attack = false;
			
			
			if(dir == UP_DIR) {
				ar.x = cb.x + cb.width / 2 - arSize /2;
				ar.y = cb.y - arSize;
				
			}
			if(dir == DOWN_DIR) {
				ar.x = cb.x + cb.width / 2 - arSize /2;
				ar.y = cb.y + cb.height;
							
			}
			if(dir == LEFT_DIR) {
				ar.x = cb.x -cb.width;
				ar.y = cb.y + cb.height / 2 - arSize /2;
					
			}
			if(dir == RIGHT_DIR) {
				ar.x = cb.x + cb.width;
				ar.y = cb.y + cb.height / 2 - arSize /2;
				
			}		
			
		//check for attacks

			for(Entity e : world.getEntityManager().getEntities()) {
				if(e.equals(this)) 
					continue;
				if(e.getCollisionBounds(0,0).intersects(ar)) {
					System.out.println("hurting entity");
					e.hurt(currentItem);
				}	
			}
		}
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory (Inventory i) {
		inventory = i;
	}
	
	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up == true) { 
			yMove = -speed;
			dir = UP_DIR;
		}
		if(game.getKeyManager().down == true) {
			yMove = speed;
			dir = DOWN_DIR;
		}
		if(game.getKeyManager().left == true) {
			xMove = -speed;
			dir = LEFT_DIR;
		}
		if(game.getKeyManager().right == true) {
			xMove = speed;
			dir = RIGHT_DIR;		
		}
		
		if(game.getKeyManager().attack == true) {
			attack = true;
		}
			
		if(game.getKeyManager().menu == true) 
			State.setState(game.menuState);		
	}
		
	public void die() {
		System.out.println("player died");
	}
	public void hurt(int value) {
		health = health - value;
		hurtValue = Integer.toString(value);
		hurting = true;
	}
	
	public void render(Graphics g) {
		
		if(dir == UP_DIR) {
			g.drawImage(Assets.playerAni[UP_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
			g.drawImage(currentItem.getHoldingImage(),(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset() -20), 32, 32, null);
		}
		if(dir == DOWN_DIR) {
			g.drawImage(Assets.playerAni[DOWN_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
			g.drawImage(currentItem.getHoldingImage(),(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset() +20), 32, 32, null);
		}
		if(dir == LEFT_DIR) {
			g.drawImage(Assets.playerAni[LEFT_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
			g.drawImage(currentItem.getHoldingImage(),(int)(x - world.getGameCamera().getxOffset() -20), (int)(y - world.getGameCamera().getyOffset()), 32, 32, null);
		}
		if(dir == RIGHT_DIR) {
			g.drawImage(Assets.playerAni[RIGHT_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
			g.drawImage(currentItem.getHoldingImage(),(int)(x - world.getGameCamera().getxOffset() + 20), (int)(y - world.getGameCamera().getyOffset()), 32, 32, null);
		}
		
		
		currentHurtTime = System.currentTimeMillis();
		
		if(currentHurtTime - lastHurtTimer > hurtCooldown) { // time to display hurt info
			hurting = false;
			lastHurtTimer = currentHurtTime;
		}
		
		if (hurting) {
			Text.drawString(g, hurtValue , (int)(x- world.getGameCamera().getxOffset()), (int)(y- world.getGameCamera().getyOffset()),false,Color.YELLOW, Assets.droid28);
		}
		
		//g.setColor(Color.blue); //draw attack box
		//g.drawRect((int)(ar.x  + bounds.x - world.getGameCamera().getxOffset()),(int)(ar.y + bounds.y - world.getGameCamera().getyOffset()), ar.width, ar.height);		
		
		//g.setColor(Color.red); //hit box
		//g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);

		inventory.render(g);
	
	}
	public void postRender(Graphics g) {
		inventory.render(g);
	}
	public void setCurrentItem(Item i) {
		currentItem = i;
	}
	public Item getCurrentItem() {
		return currentItem;
	}

}
