package net.mrpaul.apcs.pb050.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!

import java.util.Random;
import java.util.Scanner;

/**
 * Scrambling.java
 * @author Sarthak Bhatnagar
 * 9/14/17
 */
public class Scrambling {

	/**           
	*Unscrambles or unscrambles an image
	*This program takes a picture (.png) from the user, and either unscrambles it to reveal the picture, or scrambles the image to hide the picture
	*<p>
	*APCS PS05: Foul Play
	*9/14/17
	*
	*@author Sarthak Bhatnagar
	*/
	public static void main(String[] args) {
		//Unscramble image
		unscramble("ps05 encoded.png");
		//Scramble image
		scramble("asecretmessage.png");

	}//end of main
	
		
	
	/**
	 * Unscrambles an image puzzle for ps05: Foul play.
	 * @author 
	 * @param fileName a String holding the file name of a .png file in the current working directory.  Example: "scrambled_image.png"
	 * Creates an APImage object out of the file called fileName
	 * <p>Renders the scrambled APImage
	 * <p>Goes through each Pixel in that APImage object and mutes Green and Blue
	 * <p>Pixel values while amplifying red values by a factor of 5.
	 * <p>Then renders the unscrambled (i.e. modified) APImage object
	 * <p>Then prompts the user to save the unscrambled image.
	 * <p>Assumes: valid filename ending in .png that exists in the directory
	 */
	public static void unscramble(String fileName){
		
		//Render the scrambled APImage
		APImage scrambledImage = new APImage(fileName);
		scrambledImage.draw();
		
		APImage unscrambledImage = scrambledImage.clone();
		int red, blue, green;
		Scanner input = new Scanner(System.in);
		
		//Go through each pixel in scrambledImage
		for(Pixel p : unscrambledImage){
			//Mute green and blue values
			p.setGreen(0);
			p.setBlue(0);
			//Amplify red values by a factor of 5
			red = p.getRed() * 5;
			if(red > 255){
				red = 255;
			}
			p.setRed(red);
		}
		
		
		//Render the unscrambled image
		System.out.println("Press enter to show the unscrambled image");
		input.nextLine();
		unscrambledImage.draw();
		
		//Prompt user to save
		System.out.println("Do you want to save this image? (y/n)");
		String save = input.nextLine();
		if(save.equals("y")){
			unscrambledImage.saveAs();
		}else{
			//do nothing
		}
		
	}//end of unscramble
	
	
	
	
	/**
	 * Scrambles an image for ps05.
	 * @author 
	 * @param fileName a String holding the file name of a .png file
	 * Creates an APImage object out of the file called fileName
	 * <p>Renders the regular APImage
	 * <p>Goes through each Pixel in that APImage object and randomizes the Green and Blue
	 * <p>Pixel values while diminishing red values by a factor of 10.
	 * <p>Then renders the scrambled (i.e. modified) APImage object
	 * <p>Then prompts the user to save the unscrambled image.
	 * <p>Assumes: valid filename ending in .png that exists in the directory
	 */
	public static void scramble(String fileName){

		//Render image
		APImage unscrambledImage = new APImage(fileName);
		unscrambledImage.draw();
		
		//Go through each pixel to randomize values
		Random random = new Random();
		APImage scrambledImage = unscrambledImage.clone();
		for(Pixel p : scrambledImage){
			int green = random.nextInt((255 - 0) + 1) + 255;
			int blue = random.nextInt((255 - 0) + 1) + 255;
			int red = p.getRed()/10;
			p.setRed(red);
			p.setGreen(green);
			p.setBlue(blue);
		}
		
		//Prompt user to show scrambled image
		Scanner input = new Scanner(System.in);
		System.out.println("Press enter to show scrambled image");
		input.nextLine();
		scrambledImage.draw();
		
		//Prompt user to save
		System.out.println("Do you want to save this image? (y/n)");
		String save = input.nextLine();
		if(save.equals("y")){
			scrambledImage.saveAs();
		}else{
			//do nothing
		}
		
	}//end of scramble

}
