package net.mrpaul.apcs.pb050.ps07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class VoterFileRecovery {
	/**
	 * This method finds the nth instance of a substring in a larger string line.
	 * It returns the value that is the index of that item in the string, or -1 if it doesn't appear n times
	 * <p>
	 * @param n -- Number of instances
	 * @param sub -- Substring to search for
	 * @param line -- String to search in
	 * @return -- Return index as an integer
	 */
	public static int nthInstance(int n, String sub, String line) {
		//Initialize counters and tracking variables
		int lastIndex = -1;
		int begin = 0;
		int end;
		int count = 0;
		boolean cond = true;
		//Loop through string
		while(cond) {
			end = line.indexOf(sub, begin);
			//If sub is found in line
			if(end!= -1) {//Loop through again
				begin = end+1;
				lastIndex = end;
				count++;
			}else {//Stop looping
				cond = false;
			}
			//If sub has been found n times, stop loop
			if(count == n) {
				cond = false;
			}
		}
		//if sub is not in line n times, return -1	
		if(n > count) {
			lastIndex = -1;
		}
		return lastIndex;
	}
	/**
	 * Reads pipe delimited text file and reads voter information. The method will write specific pieces of information (First/Last Name, City
	 * Phone Number, LastID, and number of times the person voted in the past 8 years)
	 * <p>
	 * @param filename File to read information from
	 * @throws IOException In case file user entered is not found
	 */
	public static void generatePhoneList(String filename) throws IOException {
		//Create file objects to read and write to
		File voterFile = new File(filename);
		File phoneList = new File("PB050_phoneList.txt");
		Scanner reader = new Scanner(voterFile);
		String[] voterInformation = new String[6];
		//Instantiate Print Writer
		PrintWriter pw = new PrintWriter(new FileWriter(phoneList));
		//Write Headers
		//Write headers using format specifiers to allocate correct space
		pw.printf("%-16s", "FIRST NAME");
		pw.printf("%-16s", "LAST NAME");
		pw.printf("%-22s", "CITY");
		pw.printf("%-16s", "PHONE NUMBER");
		pw.printf("%19s", "LAST ID");
		pw.printf("%15s", "VOTING HISTORY");
		//New Line
		pw.println();
		while(reader.hasNextLine()) { //Loop through each line/entry in the voter file
			try {
			//Read the line in the register file
			String line = reader.nextLine();
			//Create array to hold information that will be written to new file
			String[] lineInfo = new String[6];
			
			lineInfo[0] = line.substring(nthInstance(1, "|", line) + 1, nthInstance(2, "|", line)); //Get First Name
			lineInfo[1] = line.substring(nthInstance(2, "|", line) + 1, nthInstance(3, "|", line)); //Get Last Name
			lineInfo[2] = line.substring(nthInstance(4, "|", line) + 1, nthInstance(5, "|", line)); //Get City
			lineInfo[3] = line.substring(nthInstance(7, "|", line) + 1, nthInstance(8, "|", line)); //Get Phone
			lineInfo[4] = line.substring(nthInstance(8, "|", line) + 1, nthInstance(9, "|", line)); //Get Last ID
			
			//Get number of times person voted in the past 8 elections
			int numElections = 0;
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(9, "|", line)+1, nthInstance(10, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(10, "|", line)+1, nthInstance(11, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(11, "|", line)+1, nthInstance(12, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(12, "|", line)+1, nthInstance(13, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(13, "|", line)+1, nthInstance(14, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(14, "|", line)+1, nthInstance(15, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(15, "|", line)+1, nthInstance(16, "|", line))));
			numElections += Integer.parseInt((String) (line.subSequence(nthInstance(16, "|", line)+1, nthInstance(17, "|", line))));
			lineInfo[5] = String.valueOf(numElections);
			
			//Write information under corresponding headers
			//Write information using format specifiers
			pw.printf("%-16s", lineInfo[0]);
			pw.printf("%-16s", lineInfo[1]);
			pw.printf("%-22s", lineInfo[2]);
			pw.printf("%-16s", lineInfo[3]);
			pw.printf("%19s", lineInfo[4]);
			pw.printf("%15s", lineInfo[5]);
			//New Line
			pw.println();
			
			}catch(Exception e) {
				//Do nothing
			}
			
		}
		//Save file and closer print writer
		pw.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		generatePhoneList("Recovered Voterfile Pipe Delimited.txt");
	}

}
