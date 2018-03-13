package net.mrpaul.pb050.ps11;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Asteroid extends Polygon{

	int[] x, y;
	int screenHeight, screenWidth, direction;
	double rotationOffset;
	Random r;
	
	public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		 x = new int[shape.length]; y = new int[shape.length];
		screenHeight = 600; screenWidth = 800;
		rotationOffset = inRotation;
		r = new Random();
		direction = r.nextInt(4);
	}
	//Get individual x and y points and pain the asteroid
	void paint(Graphics brush) {
		Point[] p = this.getPoints();
		for(int i = 0; i < shape.length; i++) {
			x[i] = (int) p[i].x;
			y[i] = (int) p[i].y;
		}
		brush.setColor(Color.GRAY);
		brush.fillPolygon(x, y, 5);
	}
	
	public void move() {
		//Depending on the direction randomly chosen when the asteroid was constructed, it will use different values for increments
		switch(direction) {
		//Positive x and y increments
			case 0:
				super.position.x += 0.5;
				super.position.y += 0.5;
				if(super.position.x > screenWidth + 150) {
					super.position.x = 0;
				}
				if(super.position.x < 0 - 150) {
					super.position.x = screenWidth;
				}
				if(super.position.y > screenHeight + 150) {
					super.position.y = 0;
				}
				if(super.position.y < 0 - 150) {
					super.position.y = screenHeight;
				}
				break;
				//Negative x increment, positive y increment
			case 1:
				super.position.x += -0.5;
				super.position.y += 0.5;
				if(super.position.x > screenWidth + 150) {
					super.position.x = 0;
				}
				if(super.position.x < 0) {
					super.position.x = screenWidth;
				}
				if(super.position.y > screenHeight + 150) {
					super.position.y = 0;
				}
				if(super.position.y < 0 - 150) {
					super.position.y = screenHeight;
				}
				break;
			//Positive x increment, negative y increment
			case 2:
				super.position.x += 0.5;
				super.position.y += -0.5;
				if(super.position.x > screenWidth + 150) {
					super.position.x = 0;
				}
				if(super.position.x < 0 - 150) {
					super.position.x = screenWidth;
				}
				if(super.position.y > screenHeight + 150) {
					super.position.y = 0;
				}
				if(super.position.y < 0 - 150) {
					super.position.y = screenHeight;
				}
				break;
			//negative x increment, negative y increment				
			case 3:
				super.position.x += -0.5;
				super.position.y += -0.5;
				if(super.position.x > screenWidth + 150) {
					super.position.x = 0;
				}
				if(super.position.x < 0 - 150) {
					super.position.x = screenWidth;
				}
				if(super.position.y > screenHeight + 150) {
					super.position.y = 0;
				}
				if(super.position.y < 0 - 150) {
					super.position.y = screenHeight;
				}
				break;
		}
	}

}
