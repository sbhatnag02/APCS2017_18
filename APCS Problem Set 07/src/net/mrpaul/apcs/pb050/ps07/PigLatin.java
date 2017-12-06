package net.mrpaul.apcs.pb050.ps07;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * PigLatin.java
 * Has behaviors/methods to convert Engligh words to Pig Latin
 * @author Sarthak B
 *11/14/17
 */
public class PigLatin {
	
	/**
	 * Finds first consonant cluster and its starting index given a String
	 * <p>
	 * @param word String entered by user
	 * @return index where first consonant cluster is found
	 */
	public static int startOfFirstConsonantCluster(String word) {
		//Initialize counters and conditions
		int index = 0;
		boolean foundConsonant = false;
		//While the first cluster has not been found -- first consonant has not been found
		while(!foundConsonant && index < word.length()) {
			//Try to convert String to number
			 try  
			  {  
				//If String is number, return -1
			    int i = Integer.parseInt(word);
			    return -1;
			  }  
			  catch(NumberFormatException nfe)  
			  {  
			    //If string is not number, catch Integer Parse error and continue through method
			  }  
			//Check if character at current index is a vowel. If it's a vowel or other character, continue. If character is a consonant, stop 
			if(word.toLowerCase().charAt(index) == 'a' || word.toLowerCase().charAt(index) == 'e' || word.toLowerCase().charAt(index) == 'i'
					|| word.toLowerCase().charAt(index) == 'o' || word.toLowerCase().charAt(index) == 'u' ) {
				index++;
			}else if (word.toLowerCase().charAt(index) >= 97 && word.toLowerCase().charAt(index) <= 122){
				foundConsonant = true;
			}else {
				index++;
			}
		}
		//Check if any consonants have been found
		if(!foundConsonant) {
			index = -1;
		}
		return index;
	}
	/**
	 * Finds the end of the first consonant cluster and return the index
	 * <p>
	 * @param word A String entered by the user
	 * @return int index. The index at which the fist cluster ends
	 */
	public static int endOfFirstConsonantCluster(String word) {
		//Find where first cluster starts 
		int index = startOfFirstConsonantCluster(word);
		//If there is no cluster, return negative one and end method
		if(index == -1) {
			return -1;
		}else {
			//Initialize condition
			boolean foundEnd = false;
			//While the end of the cluster has not been found, and the end of the word has not been reached
			while(!foundEnd && index < word.length()) {
				//If a vowel is found, the end of the cluster has been found
				if(word.toLowerCase().charAt(index) == 'a' || word.toLowerCase().charAt(index) == 'e' || word.toLowerCase().charAt(index) == 'i'
						|| word.toLowerCase().charAt(index) == 'o' || word.toLowerCase().charAt(index) == 'u' ) {
					foundEnd = true;
				}
				//Conditions to check if character is y
				else if (word.toLowerCase().charAt(index) == 'y') { 
					if(index == 0) { //If it's the first letter, it's a consonant
						index++;
					}else if (index == word.length()-1) { //If it's the last letter, it's a vowel
						foundEnd = true;
					}else if (!(isVowel(word, index-1) && isVowel(word, index+1))){ //If there is a consonant on either side, it's a vowel
						foundEnd = true;
					}else if((isVowel(word, index-1) && isVowel(word, index+1))){ //If there is a vowel on either side, it's a consonant
						index++;
					}
				}else { //If it's a consonant, end of cluster has not been found
					index++;
				}
			}
			return index-1; //Account for index off-by-one error
		}
	}
	/**
	 * Converts a regular word into pig latin
	 * <p>
	 * @param word String user wants to convert into pig latin
	 * @return word in pig latin in the form of a String
	 */
	public static String wordToPigLatin(String word) {
		//Remove white space from word
		word = word.trim();
		//Create variable to store word translated to pig latin
		String pigLatinWord = null;
		
		//Find start of first consonant cluster
		int cutOffIndex = startOfFirstConsonantCluster(word);
		
		//Breakdown and rearrange word depending on location of first consonant cluster
		if(cutOffIndex == 0) { //First letter is a consonant
			int endIndex = endOfFirstConsonantCluster(word);
			pigLatinWord = (word.substring(endIndex+1, word.length()) + word.substring(cutOffIndex, endIndex+1) + "ay");
			return pigLatinWord;
		}else if (isVowel(word, 0)){ //First letter is a vowel
			pigLatinWord = word+"way";
			return pigLatinWord;
		}else { //If none of the conditions of the word are met, return the original word
			return word;
		}
		
	}
	
	/**
	 * Helper method that checks a character at an index in a string, and determines whether that character is a vowel
	 * <p>
	 * @param word String entered by user
	 * @param index Character to check
	 * @return true if vowel, false if not a vowel
	 */
	private static boolean isVowel(String word, int index) {
		//Check if character at certain index of a String is a vowel
		if(word.toLowerCase().charAt(index) == 'a' || word.toLowerCase().charAt(index) == 'e' || word.toLowerCase().charAt(index) == 'i'
				|| word.toLowerCase().charAt(index) == 'o' || word.toLowerCase().charAt(index) == 'u' ) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Finds the start of the first punctuation sequence at the end of a word (or string)
	 * <p>
	 * @param word String to look for punctuation in
	 * @return index of the beginning o the ending punctuation sequence
	 */
	public static int findStartOfEndingPuncSeq(String word) {
		//Initialize counters and conditions
		int index = -1;
		boolean foundEndPunc = false;
		
		//Loop through word to find starting punctuation sequence
		for(int i = 0; i < word.length(); i++) {
			if((word.toLowerCase().charAt(i) >= 97 && word.toLowerCase().charAt(i) <= 122 || (word.toLowerCase().charAt(i) <= 57 && word.toLowerCase().charAt(i) >= 48))){
				//If a letter has been found, end punctuation has not been found
				foundEndPunc = false;
			}else {
				if(!foundEndPunc) {
					if(i < word.length()-1 && (word.toLowerCase().charAt(i+1) >= 97 && word.toLowerCase().charAt(i+1) <= 122)) {
					}else {
						foundEndPunc = true;
						index = i;
					}
				}
			}
		}
		
		return index;
	}
	/**
	 * Converts the words from a text file into pig latin, and writes pig latin to new text file
	 * <p>
	 * @param fileName File to convert text to pig latin
	 * @throws IOException If file is not found or scanner throws an exception
	 */
	public static void textToPigLatin(String fileName) throws IOException {
		//Create file objects to read from and to write to
		File fileToWrite = new File(fileName+"_PL.txt");
		Scanner sc = new Scanner(new File(fileName + ".txt"));
		//Create BufferedWrite to write pig latin words to new file
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite));
		String[] wordsToPigLatin = new String[1000];
		int i = 0;
		//Go through each word in text file, and store words and punctuation in a string array
		while(sc.hasNext()) {
			String word = sc.next();
			int puncIndex = findStartOfEndingPuncSeq(word);
			if(puncIndex == -1) {
				wordsToPigLatin[i] = wordToPigLatin(word);
				i++;
			}else {
				String wordWOPunc = word.substring(0, puncIndex);
				String punc = word.substring(puncIndex);
				try {
					wordsToPigLatin[i] = wordToPigLatin(wordWOPunc);
				}catch (Exception e) {
					wordsToPigLatin[i] = " ";
				}
				wordsToPigLatin[i+1] = punc;
				i+=2;
			}
		}
		//Start writing 
		writer.write(wordsToPigLatin[0]);
		writer.append(' ');
		i = 1;
		while(i < wordsToPigLatin.length && wordsToPigLatin[i] != null) {
			writer.append(wordsToPigLatin[i]);
			if(wordsToPigLatin[i+1] != null) {
			if((findStartOfEndingPuncSeq(wordsToPigLatin[i+1]) == -1)) {
				writer.append(' ');
			}
			}
			i++;
		}
		writer.close();
		sc.close();
	}
	
	
	public static void main(String[] args) throws IOException {
	}

}
