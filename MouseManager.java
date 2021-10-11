//Mouse Manager

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY = 0;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UIManager um) {
		this.uiManager = um;
	}
	
//getters
	public boolean isLeftPressed() {
		return leftPressed;
	}
		
	public boolean isRightPressed() {
		return rightPressed;
	}
		
	public int getMouseX() {
		return mouseX;
	}
		
	public int getMouseY() {
		return mouseY;
	}

//override methods
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if (e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;	
			
		if(uiManager != null)	
			uiManager.onMouseRelease(e);
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			System.out.println("leftPressed");
			leftPressed = true;
		}
		else if (e.getButton() == MouseEvent.BUTTON3){
			System.out.println("rightPressed");
			rightPressed = true;
		}
		//if(uiManager != null)
			//uiManager.onMousePressed(e);
	}	
	
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
	}
	
	
	public void mouseClicked(MouseEvent e) {
		
	}	

	public void mouseExited(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}
	
}
