package net.mrpaul.apcs.pb050.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * FoulPlay.java
 * @author Sarthak Bhatnagar
 * 9/12/17
 */

public class FoulPlay {

	/**           
	*Use methods from APImage and Pixel classes
	*This program takes modifies a picture from the user using the methods in the APImage and Pixel class
	*<p>
	*APCS PS05: Foul Play
	*9/12/17
	*
	*@author Sarthak Bhatnagar
	*/
	public static void main(String[] args) {
		/* 
		 * The reason we can call topicExercses() like this without an object
		 * or a class name is that it is a static method in the same class as the method call.
		 * If we wanted to call topicExercises() from a different class, we'd have to write
		 * FoulPlay.topicExercises();
		 */
		topicExercises();			


	}//end of main
	
	
	/**
	 * Modifies pictures using APImage and Pixel classes
	 * @author Sarthak Bhatnagar
	 */
	public static void topicExercises(){
		//instantiate a new APImage object
		String fileName = "doge.png";
		int red, blue, green;
		
		APImage image = new APImage(fileName);
		
		//Use a Scanner object (and its nextLine() method) to trigger your APImage's draw() method
		Scanner input = new Scanner(System.in);
		System.out.println("Press enter to draw image");
		input.nextLine();
		image.draw();
	
		
		//Print the width and the height of your APImage object in pixels in the form, "W: # px\tH: # px"
		System.out.println("W: " + image.getWidth() + "\tH: " + image.getHeight());
		
		//Print the R, G, and B values of the Pixel object at (10, 17)
		Pixel p = image.getPixel(10, 17);
		red = p.getRed(); blue = p.getBlue(); green = p.getGreen();
		System.out.println("Pixel at (10, 17):\tR: " + red + "\tG: " + green +"\tB: " + blue);
		
		//Iterate through each pixel in the image using a regular for loop; print R, G, and B in
		//the form: "Pixel at (<x>, <y>):\tR: #\tG: #\tB: #"
		//example: Pixel at (42, 53):	R: 10	G: 65	B: 157
		//Note that the console output is limited, so if you print enough stuff, the earlier stuff you printed disappears.
		for(int y = 0; y<image.getHeight(); y++){
			for(int x = 0; x<image.getWidth(); x++){
				Pixel pix = image.getPixel(x, y);
				red = pix.getRed(); blue = pix.getBlue(); green = pix.getGreen();
				System.out.println("Pixel at (" + x + ", " + y + "):\tR: " + red + "\tG: " + green +"\tB: " + blue);
			} 
		}
		
		
		//Rewrite your code from the last exercise so it uses an enhanced for loop.  You may omit the indices.
		for(Pixel pix2 : image){
			red = pix2.getRed(); green = pix2.getGreen(); blue = pix2.getBlue();
			System.out.println("Pixel: \tR: " + red + "\tG: " + green +"\tB: " + blue);
		}
		
		//Set every Pixel in each even column to white and every odd column to black.
		APImage imageClone = image.clone();
		for(int x = 0; x<imageClone.getHeight(); x++){
			if(x%2 == 1){
				for(int y = 0; y<imageClone.getWidth(); y++){
					Pixel pClone = imageClone.getPixel(x, y);
					pClone.setRed(0); pClone.setGreen(0); pClone.setBlue(0);
				}
			}else{
				for(int y = 0; y<imageClone.getWidth(); y++){
					Pixel pClone = imageClone.getPixel(x, y);
					pClone.setRed(255); pClone.setGreen(255); pClone.setBlue(255);
				}
			}
		}
		//Prompt user to see new image
		System.out.println("Press enter to see new image");
		input.nextLine();
		imageClone.draw();
		imageClone.saveAs();
		
		//Adjust the brightness: multiply each Pixel's values by a constant and constrain values to 255
		int brightnessFactor = 2;
		APImage imageClone2 = image.clone();
		for(int x = 0; x<imageClone2.getHeight(); x++){
			for(int y = 0; y<imageClone2.getWidth(); y++){
				Pixel pClone = imageClone2.getPixel(x, y);
				red = pClone.getRed() * brightnessFactor;
				green = pClone.getGreen() * brightnessFactor;
				blue = pClone.getBlue() * brightnessFactor;
				if(red > 255){
					red = 255;
				}
				if(blue > 255){
					blue = 255;
				}
				if(green > 255){
					green = 255;
				}
				pClone.setRed(red); pClone.setGreen(green); pClone.setBlue(blue);
			}
		}
		//Prompt user to see new image
		System.out.println("Press enter to see new image");
		input.nextLine();
		imageClone2.draw();
		System.out.println("Enter a file name");
		String brightDogeName = input.nextLine();
		imageClone2.setName(brightDogeName);
		imageClone2.saveAs();
		System.exit(0);
		
	}//end of topicExercises
	

}//end of class FoulPlay
