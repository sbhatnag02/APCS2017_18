package net.mrpaul.ads.lecture.L0501;

import java.awt.Color;
import java.util.Scanner;

import TurtleGraphics.*;

public class TurtlesTest {

	public static void main(String[] args){

		SketchPadWindow win = new SketchPadWindow(400,400);

		Pen pen1 = new StandardPen(win);

		Pen pen2 = new StandardPen(win);

		pen1.up();
		pen1.move(150,0);
		pen1.down();

		pen2.up();
		pen2.setColor(Color.red);
		pen2.move(-150,0);
		pen2.down();

		for(int i = 0; i < 10; i++){

			pen1.move(2);
			pen1.turn(15);


		}
		
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		
		for(int i = 0; i < 10; i++){


			pen2.move(2);
			pen2.turn(-15);

		}

	}


}
