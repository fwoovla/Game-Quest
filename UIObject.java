//UI Object

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public abstract class UIObject {
	
	protected float x, y;
	protected int width, height;
	protected boolean hovering = false;
	protected Rectangle bounds;
	
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int)x, (int)y, (int)width, (int) height);
	}
//Abstract methods	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void onClick();	
	
	
	public void onMouseMove(MouseEvent e) {
		if(bounds.contains(e.getX(),e.getY())) {
			hovering = true;
			//System.out.println("hovering");
		}
		else
			hovering = false;
	}
	public void onMouseRelease(MouseEvent e) {
		if(hovering = true)
			onClick();
	}
	
	public float getX() {
		return x;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setX(float _x) {
		x = _x;
	}
	public void setY(float _y) {
		y = _y;
	}
	public void setWidth(int _w) {
		width = _w;
	}	
	public void setHeigh(int _h) {
		height = _h;
	}
}
