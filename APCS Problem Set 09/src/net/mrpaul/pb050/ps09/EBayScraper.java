package net.mrpaul.pb050.ps09;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class EBayScraper {
	
	public static void main(String[] args) throws IOException {
        File ebayFile = new File("ebay_urls.txt");
        Scanner fileReader = new Scanner(ebayFile);
		String urlString = fileReader.nextLine();

		Scanner lineCounter = new Scanner(ebayFile);
		String line = lineCounter.nextLine();
		int lineCount = 0;
		while(line != null) {
			lineCount++;
			try {
			line = lineCounter.nextLine();
			}catch(Exception e) {
				break;
			}
		}
		
		
        String inputLine;
        String[][] bidItems = new String[lineCount][4];
        int bidCount = 0;
        boolean firstBidRead = false;
        while(urlString != null) {
            URL url = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            firstBidRead = false;
	        	while (in.readLine() != null) {
	        		inputLine = in.readLine();
	    			if(inputLine != null && inputLine.indexOf("<span id=\"vi-lkhdr-itmTitl\" class=\"u-dspn\">") > 0) {
	    				inputLine = inputLine.trim();
	    				String name = inputLine.substring(43, inputLine.length()-7);
	    				if(inputLine.indexOf("bid") > 0) {
	    					bidItems[bidCount][0] = Integer.toString(bidCount);
		    				bidItems[bidCount][1] = name;
	    				}
	    				System.out.println(name);
	    			}
	    			if(inputLine != null && inputLine.indexOf("bidPrice") > 0 && !firstBidRead && inputLine.indexOf("<span id=\"vi-lkhdr-itmTitl\" class=\"u-dspn\">") > 0) {
	    				bidCount++;
	    				firstBidRead = true;
	    			}
	        }
	        	try{
	        		urlString = fileReader.nextLine();
	        	}catch(Exception e) {
	        		urlString = null;
	        	}
        }
        
        System.out.println(bidCount);
        System.out.println(lineCount);
        System.out.println(bidItems[0][1]);

	}

}
