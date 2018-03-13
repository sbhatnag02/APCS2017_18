package net.mrpaul.pb050.ps11;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class Asteroids extends Game {
	//Lives counter
	static int counter = 1;
	//Random object to generate asteroid points
	Random pointGenerator = new Random();
	//Ship and asteroid object
	private Ship ship;
	private Asteroid[] asteroid;
	//Arrays to hold the shape of the asteroids and ship
	private Point[] shipPoints = {new Point(0, 0), new Point(20, -2), new Point(0, 15), new Point(7, 4), new Point(-6, 0)};
	private Point[][] asteroidPoint = {
			{new Point(0, 0), new Point(40, -50), new Point(80, -20), new Point(50, 50), new Point(20, 34)},
			{new Point(0, 0), new Point(40, -50), new Point(80, -20), new Point(50, 50), new Point(20, 34)},
			{new Point(0, 0), new Point(40, -50), new Point(80, -20), new Point(50, 50), new Point(20, 34)},
			{new Point(0, 0), new Point(40, -50), new Point(80, -20), new Point(50, 50), new Point(20, 34)},
			{new Point(0, 0), new Point(40, -50), new Point(80, -20), new Point(50, 50), new Point(20, 34)},
			{new Point(0, 0), new Point(40, -50), new Point(80, -20), new Point(50, 50), new Point(20, 34)}

		};
	//Generate the starting position of the asteroids
	private Point[] asteroidStartingPoints = {
			new Point(pointGenerator.nextInt(700), pointGenerator.nextInt(500)), new Point(pointGenerator.nextInt(700), pointGenerator.nextInt(500)), 
				new Point(pointGenerator.nextInt(700), pointGenerator.nextInt(500)), new Point(pointGenerator.nextInt(700), pointGenerator.nextInt(500)), 
				new Point(pointGenerator.nextInt(700), pointGenerator.nextInt(500)), new Point(pointGenerator.nextInt(700), pointGenerator.nextInt(500))
	};
	//Rotate each asteroid
	private int[] asteroidRotations = {0, 45, 56, 29, 33, 80};
	//Store screen width and height
	private int screenWidth = 800, screenHeight = 600;
	private boolean checkCollision = true, gameOver = false;

	//Constructor for game
	//Creates ship and asteroids
	public Asteroids() {
		super("Asteroids!",800,600);
		this.setFocusable(true);
		this.requestFocus();
		Point shipPos = new Point(400, 300);
		double shipRotation = 18.0;
		ship = new Ship(shipPoints, shipPos, shipRotation, screenWidth, screenHeight);
		asteroid = new Asteroid[6];
		for(int i = 0; i < asteroid.length; i++) {
			asteroid[i] = new Asteroid(asteroidPoint[i], asteroidStartingPoints[i], asteroidRotations[i]);
		}
		this.addKeyListener(ship);
	}
  
	//Paint the different objects on the screen
	public void paint(Graphics brush) {
	    	brush.setColor(Color.black);
	    	brush.fillRect(0,0,width,height);
	    	
	    	// sample code for printing message for debugging
	    	// counter is incremented and this message printed
	    	// each time the canvas is repainted
	    	brush.setColor(Color.white);
	    	brush.drawString("Lives: " + counter,10,10);
	 
	    	if(!gameOver) {
	    		//Draw spaceship
		    	ship.paint(brush);
		    	ship.move();
		    	
		    	//Draw asteroids and check for collisions
		    	for(int i = 0; i < asteroid.length; i++) {
		    		asteroid[i].paint(brush);
		    		asteroid[i].move();
		    		if(ship.collides(asteroid[i]) && checkCollision) {
		    			if(counter > 0) {
		    				counter--;
		    			}
		    			checkCollision = false;
		    		}else {
		    			checkCollision = true;
		    		}
		    	}
		    	if(counter <= 0) {
    				gameOver = true;
    			}
		    	//check if user has lost all lives
	    	}else {
	    		brush.setColor(Color.white);
		    	brush.drawString("GAME OVER",400,300);
	    	}
	    
	    
  }
  
	public static void main (String[] args) {
   		Asteroids a = new Asteroids();
		a.repaint();
  }
}