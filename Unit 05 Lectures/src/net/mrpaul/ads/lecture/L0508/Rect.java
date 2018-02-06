// No additional comments are needed in this class. All the important
// points have already been made.

package net.mrpaul.ads.lecture.L0508;

import TurtleGraphics.Pen;

public class Rect extends AbstractShape {

   private double height, width;

   public Rect() {
      super();
      height = 1;
      width = 1;
   }

   public Rect (double xLoc, double yLoc, double w, double h) {
      super (xLoc, yLoc);
      height = h;
      width = w;
   }
 
   public double area() {
      return height * width;
   }

   public void draw (Pen p) {
      p.up();
      p.move (xPos, yPos);
      p.down();
      p.setDirection (0); p.move (width);
      p.turn (-90); p.move (height);
      p.turn (-90); p.move (width);
      p.turn (-90); p.move (height);
   }

   public void stretchBy (double factor) {
      height *= factor;
      width *= factor;
   }

   public String toString() {
      String str = "RECTANGLE\n"
                 + "Width & Height: " + width + " & " + height +"\n"
                 + super.toString();
      return str;
   }
}

