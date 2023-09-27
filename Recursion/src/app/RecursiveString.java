package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecursiveString {

	public RecursiveString() throws FileNotFoundException {
		//get file
		File file = new File("input.txt");
		//scanner
		Scanner scnr = new Scanner(file);
		//get int from file for String array
		String str = scnr.next();
		int initiator = Integer.parseInt(str);
		//instantiate String[] and initialize with initiator
		String[] array = new String[initiator]; //O(n)

		System.out.println("Input Data = " + initiator);
		//populates String[] with input file and prints to console
		for(int i = 0; i < initiator; i++) { //T = O(n)
			str = scnr.next();
			array[i] = str;
			System.out.println(str);
		}

		System.out.println();
		System.out.println("SLOPS OUTPUT");
		//iterate through String[] array pass to isSlop
		for(int i = 0; i < initiator; i++) { //T = O(n)
			isSlop(array[i]);
		}
		System.out.println("END OF OUTPUT");
			scnr.close();
	}

	//	isSlip recursively determines if str is Slip
	public boolean isSlip(String str) { // T = O(n * logn)
		//base condition
		if(str.length() == 0) //O(1)
			return false;
		
		int i = 0;
		//turn str to char array
		char[] array = str.toCharArray(); //O(n)
		
		char character = array[i];
		//checks if str contains G and is last element
		if(character == 'G' && str.length() == 1) //O(1)
			return true;
		//subs string and calls isSlip recursively
		else { //O(1)
			str = str.substring(++i);
			return isSlip(str);
		}

	}
//	isSlap recursively determines if str is Slap
	public boolean isSlap(String str) { // T = O(n * logn)
		//base condition
		if(str.length() == 0) //O(1)
			return false;
		
		int i = 0;
		//turn str to char array
		char[] array = str.toCharArray(); //O(n)
		
		char character = array[i];
		//checks if first character is A and subs string by one then calls isSlap
		if(character == 'A') { //O(1)
			str = str.substring(++i);
			 return isSlap(str);
		}
		else if(character == 'H' || character == 'C') //O(1)
			return true;
		//subs string by one then calls isSlap
		else { //O(1)
			str = str.substring(++i);
		 	return isSlap(str);
		}

	}
	
//	isSlop checks if str is First Slap then Slip, if so then it is Slop
	public boolean isSlop(String str) { //T = O(1)
		
		if(isSlap(str))
			if(isSlip(str)) {
				System.out.println("Yes");
				return true;
			}
		System.out.println("No");
		return false;
	}
	
}
