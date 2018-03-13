package net.mrpaul.ads.lecture.L0503;

import TurtleGraphics.Pen;

public class Rect implements Shape {

   private double xPos, yPos;
   private double height, width;
   private final int sideCount = 4;

   public Rect() {
      xPos = 0;
      yPos = 0;
      height = 1;
      width = 1;
   }

   public Rect (double xLoc, double yLoc, double w, double h) {
      xPos = xLoc;
      yPos = yLoc;
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

   public double getXPos() {
      return xPos;
   }

   public double getYPos() {
      return yPos;
   }

   public void move (double xLoc, double yLoc) {
      xPos = xLoc;
      yPos = yLoc;
   }

   public void stretchBy (double factor) {
      height *= factor;
      width *= factor;
   }
   
   public int getSideCount() {
	   return sideCount;
   }

   public String toString() {
      String str = "RECTANGLE\n"
                 + "Width & Height: " + width + " & " + height +"\n"
                 + "(X,Y) Position: (" + xPos + "," + yPos + ")\n" 
                 + "Area: " + area();
      return str;
   }
}

