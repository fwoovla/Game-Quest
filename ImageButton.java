//UI ImageButtton

import java.awt.Graphics;
import java.awt.Color;

public class ImageButton extends UIObject {
	
	private ClickListener clicker;
	
	public ImageButton(float x, float y, int width, int height, ClickListener clicker) {
		super(x,y,width,height);
		this.clicker = clicker;
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		g.drawImage(Assets.start_button, (int)x, (int)y, width, height, null);
		g.setColor(Color.red);
		g.drawRect((int)(bounds.x),(int)(bounds.y), bounds.width, bounds.height);		
	}
	
	public void onClick() {
		clicker.onClick();
	}
	
}
