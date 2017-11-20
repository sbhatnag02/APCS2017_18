package net.mrpaul.apcs.pb050.ps05;

import images.APImage;
import images.Pixel;

public class Filters {
	
	public static void main (String[] args){
		String filename = "samplefilterimage.png";
		APImage image = (APImage) hudsonFilter(new APImage(filename));
		image.draw();
	}
	
	public static Object amaroFilter(APImage image){
		image.draw();
		
		APImage amaro = image.clone();
		int red, green, blue, redDif, greenDif, blueDif;

		//Increase brightness
		double brightnessFactor = 1.2;
		for(Pixel p : amaro){
			red = (int) (p.getRed() * brightnessFactor);
			if(red > 255){
				red = 255;
			}
			green = (int) (p.getGreen() * brightnessFactor);
			if(green > 255){
				green = 255;
			}
			blue = (int) (p.getBlue() * brightnessFactor);
			if(blue > 255){
				blue = 255;
			}
			p.setRed(red); p.setGreen(green); p.setBlue(blue);
		}
		
		//Apply yellow layer
		double yellowLayerFactor = 0.2;
		for(Pixel p : amaro){
			red = p.getRed();
			redDif = (int) ((red - 244) * yellowLayerFactor);
			red -= redDif;
			if(red > 255){
				red = 255;
			}else if (red < 0){
				red = 0;
			}
			p.setRed(red);
			
			green = p.getGreen();
			greenDif = (int) ((green - 234) * yellowLayerFactor);
			green -= greenDif;
			if(green > 255){
				green = 255;
			}else if (green < 0){
				green = 0;
			}
			p.setGreen(green);
			
			blue = p.getBlue();
			blueDif = (int) ((blue - 189) * yellowLayerFactor);
			blue -= blueDif;
			if(blue > 255){
				blue = 255;
			}else if (blue < 0){
				blue = 0;
			}
			p.setBlue(blue);
		}
		
		//Apply blue tint
		double blueTintFactor = 1.25;
		for(Pixel p : amaro){
			blue = p.getBlue();
			blue = (int) (blue*blueTintFactor);
			if(blue > 255){
				blue = 255;
			}
			p.setBlue(blue);
		}
		
		//Decrease brightness
		brightnessFactor = 0.875;
		for(Pixel p : amaro){
			red = (int) (p.getRed() * brightnessFactor);
			if(red > 255){
				red = 255;
			}
			green = (int) (p.getGreen() * brightnessFactor);
			if(green > 255){
				green = 255;
			}
			blue = (int) (p.getBlue() * brightnessFactor);
			if(blue > 255){
				blue = 255;
			}
			p.setRed(red); p.setGreen(green); p.setBlue(blue);
		}
		
		return amaro;
	}
	
	public static Object hudsonFilter(APImage image){
		APImage hudson = image.clone();
		image.draw();
		int red, green, blue;
		
		//Apply blue tint
		double blueTintFactor = 1.15;
		double reductionFactor = 0.9;
		for(Pixel p : hudson){
			blue = p.getBlue();
			blue = (int) (blue*blueTintFactor);
			if(blue > 255){
				blue = 255;
			}
			p.setBlue(blue);
			
			green = p.getGreen();
			green = (int)(green * reductionFactor);
			p.setGreen(green);
			
			red = p.getRed();
			red = (int)(red * reductionFactor);
			p.setRed(red);
		}
		
		return hudson;
	}

}
