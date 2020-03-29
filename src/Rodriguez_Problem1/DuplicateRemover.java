package Rodriguez_Problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DuplicateRemover {
	static String[] uniqueWords = new String[20];
	static int counter = 0;
	
	
	public static void remove(String dataFile) {
		File f = new File(dataFile);
		Scanner scan;
		try {
			scan = new Scanner(f);
			String fileContent = "";
			while(scan.hasNextLine()) {
				fileContent = scan.next();
				int truthHolder = 0;
				for(int i = 0; i <= counter; i++) {
					if(counter == 0) {
						truthHolder = 0;
						break;
					}
					else if(fileContent.equalsIgnoreCase(uniqueWords[i])) {
						truthHolder = 1;
						break;
					}
					else {
						truthHolder = 0;
					}
				}
				if(truthHolder == 0) {
					uniqueWords[counter] = fileContent;
					counter++;
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error with openning");
			e.printStackTrace();
		}
	}
	public static void write(String outputFile) {
		try {
			FileWriter writer = new FileWriter(outputFile);
			for(int i = 0; i < counter; i++) {
				writer.write(uniqueWords[i] + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Error with openning");
			e.printStackTrace();
		} 
	}
}
