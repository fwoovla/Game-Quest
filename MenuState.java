//Menu State


import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager(game);
		game.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new ImageButton(300,300,100,100, new ClickListener(){ 	
			public void onClick() {
				State.setState(game.gameState);} 
		}));
	}
	
	public void tick() {
		uiManager.tick();
	}
	
	public void render(Graphics g) {

//draw bg first
		g.drawImage(Assets.title_bg,0,0, 800, 600, null);

		uiManager.render(g);
		g.setColor(Color.BLUE);
		g.fillRect(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY(), 8, 8);
	}
}
