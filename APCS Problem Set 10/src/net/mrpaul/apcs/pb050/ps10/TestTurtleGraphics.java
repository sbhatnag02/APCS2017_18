package net.mrpaul.apcs.pb050.ps10;

import TurtleGraphics.Pen;
import TurtleGraphics.SketchPadWindow;
import TurtleGraphics.StandardPen;

public class TestTurtleGraphics {

	public static void main(String[] args) {
		
		//Specify window
		SketchPadWindow win = new SketchPadWindow(1920, 1080);
		
		//Pass window size into new standard pen
		Pen p = new StandardPen(win);
		
		//Move to center
		p.up();
		p.home();
		
		int startingAngle1 = 30;
		int startingAngle2 = 150;
		int startingAngle3 = -90;
		
		//Draw triangles
		p.setWidth(10);
		for(int i = 0; i < 13; i++) {
			drawTriangle(500, p, startingAngle1, startingAngle2, startingAngle3);
			startingAngle1+=30;
			startingAngle2+=30;
			startingAngle3+=30;
		}
		
		
		
	}
	
	public static void drawTriangle(int sideLength, Pen p, int angle1, int angle2, int angle3) {
		p.down();
		p.setDirection(angle1);
		p.move(sideLength);
		p.setDirection(angle2);
		p.move(sideLength);
		p.setDirection(angle3);
		p.move(sideLength);
	}
	
}
