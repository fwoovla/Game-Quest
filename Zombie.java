//Zombie Creature

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

public class Zombie extends Creature {
	Random rand = new Random();
	
	public static final int UP_DIR = 0;
	public static final int RIGHT_DIR = 1;	
	public static final int DOWN_DIR = 2;
	public static final int LEFT_DIR = 3;
	private int dir = 1;
	private int steps = 0;
	public Entity target = null;
	public float targetX, targetY;
	
	private long lastAttackTime;
	private int attackCooldown = 1000;
	private long currentTime;
	private boolean attack = true;
	public int strength = 10;
	public String hurtValue;

	Rectangle ar = new Rectangle();

	private Rectangle radar;

	public Zombie(Game game, World w, float x, float y) {
		super(game, w, x, y, 32, 32);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
		
		radar = new Rectangle();
		radar.x = -100;
		radar.y = -100;
		radar.width = 232;
		radar.height = 232;
		
		this.speed = .5f;
	}
	
	public void tick() {
		
		currentHurtTime = System.currentTimeMillis();
		
		calculateMove();
		checkRadar();
		move();
		
		currentTime = System.currentTimeMillis();
		
		if(currentTime - lastAttackTime < attackCooldown) {
			//System.out.println("resting");
			attack = false;
			return;
		}else {			
			lastAttackTime = currentTime;
			attack = true;
		}		

		if(attack && target != null){
			attack();
		}
		
	}
	
	public void checkRadar() {
		
		  
		//System.out.println(world.getEntityManager().getPlayer().getCollisionBounds(0,0));
		if(getRadarBounds(0,0).intersects(world.getEntityManager().getPlayer().getCollisionBounds(0,0))){
			target = world.getEntityManager().getPlayer();
			System.out.println("i see the player");
		}else target = null;
	}
	public Rectangle getRadarBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + radar.x + xOffset), (int) (y + radar.y +yOffset), radar.width, radar.height);
	}
	
	public void calculateMove() {
		if(target == null) {
			if(steps > 100){
				dir = rand.nextInt(4);
				xMove = 0;
				yMove = 0;
				steps = 0;	
			}
			if(dir == UP_DIR)
				yMove = -speed;
			if(dir == DOWN_DIR)
				yMove = speed;
			if(dir == LEFT_DIR)
				xMove = -speed;
			if(dir == RIGHT_DIR)
				xMove = speed;
			steps++;
		}
		if(target != null) {
			
			targetX = target.getX();
			targetY = target.getY();
			
			if(targetX > x && targetY < y) {  //quad 1
				if(x - targetX > targetY - y) {
					dir = UP_DIR;
				} else dir = RIGHT_DIR;
			}
			else if(targetX > x && targetY > y) {  //quad 2
				if(targetX - x > targetY - y) {
					dir = RIGHT_DIR;
				} else dir = DOWN_DIR;	
			}
			else if(targetX < x && targetY > y) {  //quad 3
				if(targetX - x < y - targetY) {
					dir = LEFT_DIR;
				} else dir = DOWN_DIR;
			}
			else if(targetX < x && targetY < y) {  //quad 4
				if(targetX - x < targetY - y) {
					dir = LEFT_DIR;
				} else dir = UP_DIR;
			}
			
			
			if(targetX < x) {
				xMove = -speed;
				//dir = LEFT_DIR;
			}
			if(targetX > x) {
				xMove = speed;
				//dir = RIGHT_DIR;
			}
			if(targetY < y) {
				yMove = -speed;
				//dir = UP_DIR;
			}
			if(targetY > y) {
				yMove = speed;
				//dir = DOWN_DIR;
			}
		}
	}
	
	private void attack() {


		Rectangle cb = this.getCollisionBounds(0,0);
		
		int arSize = 20;
		ar.x = cb.x - 10;
		ar.y = cb.y - 10;
		ar.width = arSize;
		ar.height = arSize;			
		
		int xAttack,yAttack = 0;
		
		if(attack) {
			System.out.println("attacking");
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

			//for(Entity e : world.getEntityManager().getEntities()) {
				//if(e.equals(this)) 
					//continue;
				if(world.getEntityManager().getPlayer().getCollisionBounds(0,0).intersects(ar)) {
					System.out.println("enemy attacking");
					world.getEntityManager().getPlayer().hurt(strength);
				}	
			//}
		}
	}

	public void hurt(Item i) {
		System.out.println("entity hurt");
		health -=i.strength;
		hurtValue = Integer.toString(i.strength);
		flashHurt();
		if (health <= 0) {
			active = false;
			die();
		}
	}
	public void die() {
		System.out.println("zombie died");
	}
	
	public void render(Graphics g) {
		
		if(dir == UP_DIR) {
			g.drawImage(Assets.zombieAni[UP_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		if(dir == DOWN_DIR) {
			g.drawImage(Assets.zombieAni[DOWN_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		if(dir == LEFT_DIR) {
			g.drawImage(Assets.zombieAni[LEFT_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		if(dir == RIGHT_DIR) {
			g.drawImage(Assets.zombieAni[RIGHT_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		
		//g.setColor(Color.red);
		g.fillRect((int)(x - (health / 8) - world.getGameCamera().getxOffset()), (int)(y + bounds.y + bounds.height - world.getGameCamera().getyOffset()), health /2, 5);
		
		//g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
		//g.setColor(Color.BLUE);
		//g.drawRect((int)(x + radar.x - world.getGameCamera().getxOffset()),(int)(y + radar.y - world.getGameCamera().getyOffset()), radar.width, radar.height);


		if(currentHurtTime - lastHurtTimer > hurtCooldown) { // time to display hurt info
			hurting = false;
			lastHurtTimer = currentHurtTime;
		}
		
		//g.setColor(Color.blue); //draw attack box
		//g.drawRect((int)(ar.x  + bounds.x - world.getGameCamera().getxOffset()),(int)(ar.y + bounds.y - world.getGameCamera().getyOffset()), ar.width, ar.height);		
		
		if(hurting) {
			Text.drawString(g, hurtValue , (int)(x- world.getGameCamera().getxOffset()), (int)(y- world.getGameCamera().getyOffset()),false,Color.RED, Assets.droid28);

		}
		if(target != null) {
			//Text.drawString(g, "GRRR!!!", (int)(x- world.getGameCamera().getxOffset()), (int)(y- world.getGameCamera().getyOffset()),false,Color.WHITE, Assets.droid28);
		}

	}
}
