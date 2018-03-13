//Shape.java: Behavior common to all shapes
package net.mrpaul.ads.lecture.L0503;

import TurtleGraphics.Pen;

public interface Shape {
   public double area();
   public void   draw (Pen p);
   public double getXPos();
   public double getYPos();
   public void   move (double xLoc, double yLoc);
   public void   stretchBy (double factor);
   public int getSideCount();
   public String toString();
}

