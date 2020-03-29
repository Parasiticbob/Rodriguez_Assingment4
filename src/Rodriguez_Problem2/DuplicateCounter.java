package Rodriguez_Problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DuplicateCounter {
	//Class wide variables
	public static String[] uniqueWords = new String[20];
	public static int[] uniqueCount = new int[20];
	public static int counter = 0;//keeps track of how many words are in the arrays
	
	//Read method that will also add new words to uniqueWords array and increment its count each time it is found
	public static void count(String dataFile) {
		//Opening file and scanner
		File f = new File(dataFile);
		Scanner scan;
		try {
			scan = new Scanner(f);

			//While loop that will read the file
			String fileContent = "";
			while(scan.hasNextLine()) {
				
				fileContent = scan.next();
				int truthHolder = 0; //This is a check for if a word is present in uniqueWords or not
				
				//For loop that will check for words being in uniqueWords or not
				for(int i = 0; i < counter; i++) {
					
					//if the array is empty just add the word
					if(counter == 0) {
						truthHolder = 0;
						break;
					}
					
					//checks to see if the current uniqueWords index is the same word as what is in the file
					else if(fileContent.equalsIgnoreCase(uniqueWords[i])) {
						truthHolder = 1;
						uniqueCount[i] = uniqueCount[i] + 1;
						break;
					}
					
					//If the words cannot be found in the array, add it to the array
					else {
						truthHolder = 0;
					}
				}
				
				//This will add the word to the array is it isn't already there
				if(truthHolder == 0) {
					uniqueWords[counter] = fileContent;
					uniqueCount[counter] = uniqueCount[counter] + 1;
					counter++;
				}
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error with openning");
			e.printStackTrace();
		}
	}
	
	//Method that prints out all the arrays' info into outputFile
public static void write(String outputFile) {
		
		//Opening/Creating the file to write out to
		FileWriter writer;
		try {
			writer = new FileWriter(outputFile);
			
			//for loop that does all the printing to outputFile
		for(int i = 0; i < counter; i++) {
			writer.write("The word '"+ uniqueWords[i] + "' appears " + uniqueCount[i] + " times\n");
		}
		writer.close();
		} catch (IOException e) {
			System.out.println("Error with openning");
			e.printStackTrace();
		}
	}
}
