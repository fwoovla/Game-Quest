//Game class
//Game Quest


import java.awt.image.*;
import java.awt.Graphics;


public class Game implements Runnable{

	private Display display;
	
	//thread
	private Thread thread;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//
	private int width, height;
	public String title;
	private boolean isRunning = false;
	
	//Camera
	//private GameCamera gameCamera;
	
	//handler
	//private Handler handler;
	//graphics
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	public State transitionState;

//constructor
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
//init	
	private void init() {
		display = new Display(title, width, height);  	//create new window
		
		
		display.getFrame().addKeyListener(keyManager);	//key listner
		display.getCanvas().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();    								//load assets

		
		gameState = new GameState(this);				//gamestates
		menuState = new MenuState(this);
		transitionState = new TransitionState(this);
		
		State.setState(menuState);   					//initialize state
		
	}
//tick	
	private void tick(){
		//keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
//render	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		//clear
		g.clearRect(0,0,width,height);
		
		//draw here
		if (State.getState() != null) {
			State.getState().render(g);
		}
		//end draw
		
		bs.show();
		g.dispose();
	}
	
//run	
	public void run(){
		init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        long now = 0;
        boolean canRend = false;

        while(isRunning) {

            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                tick();
                updates++;
                delta-=1;
                canRend = true;
            }

            if(canRend) {
            render();
            frames++;
            canRend = false;
            }

            //if(System.currentTimeMillis() - timer > 1000) {
            //    timer += 1000;
                //System.out.println("FPS: " + frames + " TICKS: " + updates);
            //    frames = 0;
            //    updates = 0;
            //}
        }
	}
	
	public synchronized void start(){
		if (isRunning) {
			return;
		}
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	public synchronized void stop(){
		if (!isRunning) {
			return;
		}
		isRunning = false;
		try{
			thread.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}

	//public GameCamera getGameCamera() {
		//return gameCamera;
	//}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public State getState() {
		return State.getState();
	}
	
	public void setState (State s) {
		State.setState(s);
	}	

}
