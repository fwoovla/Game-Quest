//Npc seller creature

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.util.Random;

public class NpcSeller extends Creature {
	Random rand = new Random();
	
	public static final int UP_DIR = 0;
	public static final int RIGHT_DIR = 1;	
	public static final int DOWN_DIR = 2;
	public static final int LEFT_DIR = 3;
	private int dir = 1;
	private int steps = 0;
	public Entity target = null;
	
	public String message[] = {"Hi there", "I'll lost my sword at the beach."}; 
	
	public int mesgIndex = 0;
	
	private Rectangle radar;

	public NpcSeller(Game game, World w, float x, float y) {
		super(game, w, x, y, 32, 32);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 32;
		bounds.height = 32;
		
		radar = new Rectangle();
		radar.x = -50;
		radar.y = -50;
		radar.width = 132;
		radar.height = 132;
		
		this.speed = 1f;
	}
	
	public void tick() {
		
		currentHurtTime = System.currentTimeMillis();
		
		calculateMove();
		checkRadar();
		if (target == null) {
			move();
		}
		
		if(target != null){
			//do something
		}
		
	}
	
	public void checkRadar() {
		//target = null;
		//System.out.println(world.getEntityManager().getPlayer().getCollisionBounds(0,0));
		if(getRadarBounds(0,0).intersects(world.getEntityManager().getPlayer().getCollisionBounds(0,0))){
			target = world.getEntityManager().getPlayer();
			System.out.println("How are you today?");
			
			float targetX = target.getX();
			float targetY = target.getY();
			
		//face target
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
			//Text.drawString(g, "Hi there.", x, y,false,Color.WHITE, Assets.droid28);
		}else target = null;
		if(target == null)
			mesgIndex = 0;
	}
	public Rectangle getRadarBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (x + radar.x + xOffset), (int) (y + radar.y +yOffset), radar.width, radar.height);
	}
	
	public void calculateMove() {
		if(steps > 100){
			dir = rand.nextInt(4);
			xMove = 0;
			yMove = 0;
			steps = 0;	
		}
		if(dir == UP_DIR)
			yMove = -1;
		if(dir == DOWN_DIR)
			yMove = 1;
		if(dir == LEFT_DIR)
			xMove = -1;
		if(dir == RIGHT_DIR)
			xMove = 1;
		steps++;
	}
	
	public void die() {
		System.out.println("npc died");
	}
	
	public void hurt(Item i) {
		startConversation();
	}
	public void startConversation() {
		mesgIndex = 1;
	}
	
	public void render(Graphics g) {
		
		if(dir == UP_DIR) {
			g.drawImage(Assets.npc_1_Ani[UP_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		if(dir == DOWN_DIR) {
			g.drawImage(Assets.npc_1_Ani[DOWN_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		if(dir == LEFT_DIR) {
			g.drawImage(Assets.npc_1_Ani[LEFT_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		if(dir == RIGHT_DIR) {
			g.drawImage(Assets.npc_1_Ani[RIGHT_DIR],(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
		}
		
		//g.setColor(Color.red);
		
		//g.fillRect((int)(x - (health / 8) - world.getGameCamera().getxOffset()), (int)(y + bounds.y + bounds.height - world.getGameCamera().getyOffset()), health /2, 5);
		
		//g.drawRect((int)(x + bounds.x - world.getGameCamera().getxOffset()),(int)(y + bounds.y - world.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
		//g.setColor(Color.BLUE);
		//g.drawRect((int)(x + radar.x - world.getGameCamera().getxOffset()),(int)(y + radar.y - world.getGameCamera().getyOffset()), radar.width, radar.height);


		if(currentHurtTime - lastHurtTimer > hurtCooldown) {
			//System.out.println("resting");
			hurting = false;
			lastHurtTimer = currentHurtTime;
			//return;
		}
		if(hurting) {
			g.drawImage(Assets.hurtImg,(int)(x - world.getGameCamera().getxOffset()), (int)(y - world.getGameCamera().getyOffset()), width, height, null);
			hurting = false;
		}
		
		if(target != null) {
			Text.drawString(g, message[mesgIndex], (int)(x- world.getGameCamera().getxOffset()), (int)(y- world.getGameCamera().getyOffset()),false,Color.WHITE, Assets.droid14);
		}

	}
}
