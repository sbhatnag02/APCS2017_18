package net.mrpaul.pb050.ps11;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;

public class Ship extends Polygon implements KeyListener{

	int[] x, y;
	double xMoveIncrement, tempXMoveIncrement, tempYMoveIncrement;
	double yMoveIncrement;
	boolean forward = false, left = false, right = false;
	boolean decelerating = true, accelerating = true;
	boolean paintBullet = true;
	int screenHeight, screenWidth;
	double rotationOffset, accelerationMultiplier = 0.05;
	
	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		// TODO Auto-generated constructor stub
		x = new int[shape.length]; y = new int[shape.length];
		screenHeight = 600; screenWidth = 800;
		rotationOffset = inRotation;
	}
	
	public Ship(Point[] inShape, Point inPosition, double inRotation, int screenWidth, int screenHeight) {
		super(inShape, inPosition, inRotation);
		x = new int[shape.length]; y = new int[shape.length];
		this.screenHeight = screenHeight; this.screenWidth = screenWidth;
		rotationOffset = inRotation;
	}

	void paint(Graphics brush) {
		//Get the individual x and y points and then paint the ship
		Point[] p = this.getPoints();
		for(int i = 0; i < shape.length; i++) {
			x[i] = (int) p[i].x;
			y[i] = (int) p[i].y;
		}
		brush.setColor(Color.RED);
		brush.fillPolygon(x, y, 5);
	}
	
	public void move() {
		//Move forward if the up key is pressed
		if(forward) {
			//Accelerate ship by incrementing movement value
			if(accelerating) {
				xMoveIncrement = accelerationMultiplier * Math.cos(Math.toRadians(rotation-rotationOffset));
				yMoveIncrement = accelerationMultiplier * Math.sin(Math.toRadians(rotation-rotationOffset));
				
				super.position.x += xMoveIncrement;
				super.position.y += yMoveIncrement;
				
				if(super.position.x + xMoveIncrement > 800) {
					super.position.x = 0;
				}
				if(super.position.x + xMoveIncrement< 0) {
					super.position.x = 800;
				}
				if(super.position.y < 0) {
					super.position.y = 600;
				}
				if(super.position.y > 600) {
					super.position.y = 0;
				}
				
				accelerationMultiplier += 0.05;
				//Check if ship should stop accelerating
				if(accelerationMultiplier > 3.5) {
					accelerating = false;
				}
			//Move ship at normal increment	
			}else {
				xMoveIncrement = 4 * Math.cos(Math.toRadians(rotation-rotationOffset));
				yMoveIncrement = 4 * Math.sin(Math.toRadians(rotation-rotationOffset));
				
				super.position.x += xMoveIncrement;
				super.position.y += yMoveIncrement;
				
				if(super.position.x + xMoveIncrement > 800) {
					super.position.x = 0;
				}
				if(super.position.x + xMoveIncrement< 0) {
					super.position.x = 800;
				}
				if(super.position.y < 0) {
					super.position.y = 600;
				}
				if(super.position.y > 600) {
					super.position.y = 0;
				}
			}
			
			
		}
		//if key is released, decelerate the ship by slowing decreasing the move increment 
		else {
			accelerating = true;
			accelerationMultiplier = 0.05;
			if(Math.abs(tempXMoveIncrement) > 0.2 || Math.abs(tempYMoveIncrement) > 0.2) {
				tempXMoveIncrement *= 0.975;
				tempYMoveIncrement *= 0.975;
				super.position.x += tempXMoveIncrement;
				super.position.y += tempYMoveIncrement;
			}else {
				
			}
		}
		//if left key is pressed, rotate counterclockwise
		if(left) {
			this.rotate(-5);
		}
		//if right key is pressed, rotate clockwise
		if(right) {
			this.rotate(5);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
	    //Up is 38, Left is 37, Right is 39
		if(keyCode == 38) {
			forward = true;
			decelerating = false;
		}
		if(keyCode == 37) {
			left = true;
		}
		if(keyCode == 39) {
			right = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//Up is 38, Left is 37, Right is 39
		int keyCode = e.getKeyCode();
    		if(keyCode == 38 && forward) { //if up is released
    			forward = false;
    			if(!decelerating) {
    				tempXMoveIncrement = xMoveIncrement;
    				tempYMoveIncrement = yMoveIncrement;
    				decelerating = true;
    			}
    			accelerating = true;
    			accelerationMultiplier = 0.05;
    			
    		}
    		if(keyCode == 37 && left) { //if up is released
    			left = false;
    		}
    		if(keyCode == 39 && right) { //if up is released
    			right = false;
    		}
      
	}

}
