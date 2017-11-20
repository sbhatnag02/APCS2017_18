package net.mrpaul.apcs.pb050.ps05;
import images.APImage;
import images.Pixel;

public class JewelDetection {

	public static void main(String[] args){
		String file = "jewels.png";
		APImage image = new APImage(file);
		image.draw();
		image = (APImage) isolateJewels(image);
		image.draw();
	}
	
	public static Object isolateJewels(APImage image){
		for(Pixel p : image){
			if(!(p.getBlue() > 150 || p.getRed() > 150)){
				p.setRed(0); p.setBlue(0); p.setGreen(0);
			}
		}
		
		return image;
	}
	
}
