package net.mrpaul.pb050.ps11;

import java.awt.*;

public class Ship extends Polygon {

	Point position;
	int[] x, y;
	double size;
	double xMoveIncrement;
	double yMoveIncrement;
	boolean forward = true, left = false, right = false;
	
	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		x = new int[shape.length]; y = new int[shape.length];
		shape = this.getPoints();
	}
	
	void paint(Graphics brush) {
		for(int i = 0; i < shape.length; i++) {
			x[i] = (int) shape[i].x;
			y[i] = (int) shape[i].y;
		}
		brush.setColor(Color.RED);
		brush.fillPolygon(x, y, 5);
	}
	
	public void move() {
		if(forward) {
			xMoveIncrement = 2;
			yMoveIncrement = -0.5;
			for(int i = 0; i < shape.length; i++) {
				if(shape[i].x > 790 || shape[i]. x < 10 || shape[i].y > 550) {
					forward = false;
					break;
				}else {
					shape[i].x += xMoveIncrement;
					shape[i].y += yMoveIncrement;
				}
				
			}
		}
	}

}
