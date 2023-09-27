package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String str = "";
		//input file to read
		File file = new File("input.txt");
		Scanner fileScnr = new Scanner(file);
		
		HashTable table = new HashTable();
		//reads file in and creates key value pairs
		while(fileScnr.hasNext()) {
		str = fileScnr.next();
		int total = 0;
		char[] array = str.toCharArray();
		
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		//adds key value pair to hashtable
		table.put(total, str);

		}

		fileScnr.close();
		
		Scanner scnr = new Scanner(System.in);
		System.out.println("Input a Search Word or -1 to Quit: ");
		str = scnr.next();
		//search words dynamically, -1 to quit
		while(str.compareTo("-1") != 0) {
			if (table.get(str) != null) 
				System.out.println("Word was located");
			else
				System.out.println("Word was not located");
			
			System.out.println();
			System.out.println("Input a Search Word or -1 to Quit: ");
			str = scnr.next();
			
		}

		
		scnr.close();
		
	}
	
	

}
