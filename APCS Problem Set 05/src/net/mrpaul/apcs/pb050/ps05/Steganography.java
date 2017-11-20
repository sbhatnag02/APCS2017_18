package net.mrpaul.apcs.pb050.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * Steganography.java
 * @author Sarthak Bhatnagar
 * 9/14/17
 */
public class Steganography {

	/**           
	*Decodes and encodes images to determine/hide message
	*This program takes a picture (.png) from the user, and either decodes the message in the image, or encodes the image with a hidden message.
	*<p>
	*APCS PS05: Foul Play
	*9/14/17
	*
	*@author Sarthak Bhatnagar
	*/
	public static void main(String[] args) {
		//example calls:
		
		/* generate black and white
		 */
		generateBW("batman.png");
		
		
		
		/*
		 * shave destination
		 */
		shaveImage("flowers.png");
		
		
		/*
		 * encode your black and white message into your shaven destination
		 */
		encode("batmanbw.png", "flowersshaved.png");
		
		
		
		/*
		 * decode your encoded image
		 */
		decode("flowersencoded.png");
		


	}//end of main
	
	
	/**
	 * Takes an encoded image, and decodes it to reveal hidden picture/message
	 * @author Sarthak Bhatnagar
	 * @param fileName -> String value for .png file
	 */
	public static void decode(String fileName){
		
		Scanner input = new Scanner(System.in);
		//Render image
		APImage image = new APImage(fileName);
		image.draw();
		
		//Create new image to hold decoded pixels
		APImage decodedImage = new APImage(image.getWidth(), image.getHeight());
		
		//Iterate through each pixel to decode message
		for(int y = 0; y<image.getHeight(); y++){
			for(int x = 0; x < image.getWidth(); x++){
				Pixel p = image.getPixel(x, y);
				if(p.getRed() % 2 == 1){	//If black
					Pixel pDecoded = decodedImage.getPixel(x, y);
					pDecoded.setRed(0); pDecoded.setGreen(0); pDecoded.setBlue(0);
				}else{
					Pixel pDecoded = decodedImage.getPixel(x, y);
					pDecoded.setRed(255); pDecoded.setGreen(255); pDecoded.setBlue(255);
				}
			}
		}
		
		//Render decoded image
		System.out.println("Press enter to see the decoded image");
		input.nextLine();
		decodedImage.draw();
		
		//Prompt user to save image
		System.out.println("Would you like to save this image (y/n)");
		String answer = input.nextLine();
		if(answer.equals("y")){
			decodedImage.saveAs();
		}else{
			//do nothing
		}
		
	}//end of decode
	
	/**
	 * Takes and image and coverts it to black and white
	 * @author Sarthak Bhatnagar
	 * @param fileName -> String value for .png file
	 */
	public static void generateBW(String fileName){
		
		//Render image
		APImage image = new APImage(fileName);
		image.draw();
		Scanner input = new Scanner(System.in);
		System.out.println("Press enter to convert picture to black and white");
		input.nextLine();
		
		//Convert pixels from color to black and white
		for(Pixel p : image){
			double averageRGB = (p.getRed()+p.getGreen()+p.getBlue())/3;
			if(averageRGB > 127){
				p.setRed(255); p.setGreen(255); p.setBlue(255);
			}else if (averageRGB < 127){
				p.setRed(0); p.setGreen(0); p.setBlue(0);
			}
		}
		//Render B&W image
		image.draw();
		
		//Prompt user to save image
		System.out.println("Would you like to save this image (y/n)");
		String answer = input.nextLine();
		if(answer.equals("y")){
			image.saveAs();
		}else{
			//do nothing
		}
		
	}//end of generateBW
	
	/**
	 * Shaves the red values for each pixel down to the nearest tenth (157 -> 150)
	 * @author Sarthak Bhatnagar
	 * @param fileName -> String value for .png file
	 */
	public static void shaveImage(String fileName){
		
		//Render image
		APImage image = new APImage(fileName);
		image.draw();
		Scanner input = new Scanner(System.in);
		System.out.println("Press enter to shave image");
		input.nextLine();
		
		//Go through each pixel and shave the red value down to the tenth
		for(Pixel p : image){
			long red = p.getRed();
			System.out.println(red);
			red -= red%10;
			System.out.println(red);
			p.setRed((int) red);
		}
		image.draw();
		
		//Prompt user to save image
		System.out.println("Would you like to save this image (y/n)");
		String answer = input.nextLine();
		if(answer.equals("y")){
			image.saveAs();
		}else{
			//do nothing
		}
		
	}//end of shaveImage
	
	/**
	 * Encodes a picture with a hidden message (from another picture)
	 * @author Sarthak Bhatnagar
	 * @param fileName -> String value for .png file
	 */
	public static void encode(String messageFileName, String destinationFileName){
		
		//Render destination image, instantiate message image
		APImage message = new APImage(messageFileName);
		APImage destination = new APImage(destinationFileName);
		destination.draw();
		Scanner input = new Scanner(System.in);
		System.out.println("Press enter to being encoding");
		input.nextLine();
		
		//encode message by iterating through pixels to adjust red values
		for(int y = 0; y < message.getHeight(); y++){
			for(int x = 0; x < message.getWidth(); x++){
				Pixel p = message.getPixel(x, y);
				if(p.getRed() == 0 && p.getGreen() == 0 && p.getBlue() == 0){
					Pixel pDestination = destination.getPixel(x, y);
					pDestination.setRed(pDestination.getRed() + 1);
				}
			}
		}
		
		//Prompt user to save image
		System.out.println("Would you like to save this image (y/n)");
		String answer = input.nextLine();
		if(answer.equals("y")){
			destination.saveAs();
		}else{
			//do nothing
		}
		
	}//end of encode

}//end of class Steganography
