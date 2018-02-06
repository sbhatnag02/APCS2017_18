// 05_02: Draw squares with three types of pens - with helper method
package net.mrpaul.ads.lecture.L0502;

import TurtleGraphics.*;

public class TestPens2{
   public static void main(String[] args){
      // Declare three variables of the interface type called Pen.
      StandardPen p1, p2, p3;

      // Instantiate three different types of pens and 
      // associate them with the Pen variables.
      p1 = new StandardPen();
      p2 = new WigglePen();
      p3 = new RainbowPen();

      // Draw a square with the standard pen.
      drawSquare(p1);
     
      // Draw a square with the wiggle pen.
      drawSquare(p2);
     
      // Draw a square with the rainbow pen.
      drawSquare(p3);
   }
   
   public static void drawSquare(Pen p){
	   //Draw a square with any pen
	   for(int i = 1; i <= 4; i++){
		   p.move(50);
		   p.turn(90);
	   }
   }
}//end of TestPens2 class
