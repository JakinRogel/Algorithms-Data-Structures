package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Array {
	
	private static int count = 0;

	public static void main(String[] args) {
		
		File file = new File("text.txt");
		
		String[] array = new String[10000];
		
		try {
			Scanner scnr = new Scanner(file);
			
			int i = 0;
			//populates String[] with text file
			while(scnr.hasNext()) {
				array[i] = scnr.next();
				i++;
			}
			
			scnr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//prints the non-null values in array
		for(int i = 0; i < array.length-1; i++) {
			
			if(array[i] != null) {
		System.out.print(array[i] + " ");
		//increments count to determine how many non-null values are held in String[]
		count++;
			}

		}
		
		System.out.println();
		System.out.println();
		
		bubbleSort(array);

		//prints String[] all non-null values
		for(int i = 0; i < array.length-1; i++) {
			
			if(array[i] != null)
		System.out.print(array[i] + " ");
			
		}

		Scanner scnr = new Scanner(System.in);

		String input = scnr.next();
		
		//used to stop while loop
		int num = 1;
		//attempts to parse string to int 
		try {
			num = Integer.parseInt(input);
		} catch(NumberFormatException e) {}
			
		
		
		while(num != 0) {
			
			System.out.println(binarySort(array, input));
			
			input = scnr.next();
			//attempts to parse string to int 
			try {
				num = Integer.parseInt(input);
			} catch(NumberFormatException e) {}
		}
		

		System.out.println("Program end...");
		


	}
	
	/*when given a string, returns either the index 
	  of the string or a -1 to indicate the string was not found in the array. */
	public static int binarySort(String[] array, String input) {
		
        int low = 0;
        //count is created when populating String array and incremented with each filled item
        int high = count;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            //determines if input is before or after value at mid
            if (array[mid].compareTo(input) < 0) {
            	//since input is after mid index reset low 
                low = mid + 1;
             //determines if input is before or after value at mid
            } else if (array[mid].compareTo(input) > 0) {
            	//since input is before mid index reset high
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
	
	//method that sorts through string array alphabetically
	public static void bubbleSort(String[] array) {
		//temporary placeholder String variable
		String t;
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				//checks to make sure the index value is not null
				if(array[j] != null && array[j+1] != null) {
					//compares the index values and returns int higher if further in alphabet
				if(array[j].compareTo(array[j+1]) > 0) {
					//store index string value in temporary placeholder
					t = array[j];
					//sets value at index to the value at the index to the right
					array[j] = array[j+1];
					//index to the right is set to temporary placeholder for next iteration
					array[j+1] = t;
					}
				}
			}
		}
	}

}
