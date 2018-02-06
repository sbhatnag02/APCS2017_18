// 05_04: Draw a circle and a wheel

package net.mrpaul.ads.lecture.L0504;

import TurtleGraphics.*;

public class TestShapes {

   public static void main (String[] args) {

      // Declare and instantiate a pen, a circle and a wheel
      Pen p = new StandardPen();
      Shape s1 = new Circle (20, 20, 20);
      Shape s2 = new Wheel (-20, -20, 20, 6);
      
      // Draw the circle and wheel
      s1.draw (p);
      s2.draw (p);
   }

}

