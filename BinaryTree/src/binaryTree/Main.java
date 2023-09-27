 package binaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
    	String input = "";
    	
    	Tree tree = new Tree();
        
        File file = new File("input.txt");
        Scanner scnr = new Scanner(file);
        
        while(scnr.hasNext()) 
        	tree.insert(scnr.next());
        scnr.close();
        
        Scanner scnr2 = new Scanner(System.in);

        tree.traverseInOrder();
        System.out.println();
        
        
        System.out.println("Enter string, enter -1 to quit: ");
        
        input = scnr2.next();
        
        while(input.compareTo("-1") != 0) {
        if(tree.find(input)) {
            System.out.println("Inspected " + tree.getInspected() + " elements");
        	System.out.println(input + " was found");
        }
        else
        	System.out.println(input + " not found");
        
        System.out.println();
        
        System.out.println("Enter string, enter -1 to quit: ");
        
        input = scnr2.next();
        
        }

        System.out.println("Enter string to remove: ");
        
        input = scnr2.next();
        
        while(input.compareTo("-1") != 0) {
        if(tree.find(input)) {
        	tree.remove(tree.getRoot(), input);
        	tree.traverseInOrder();
        }
        else
        	System.out.println(input + " not found");
        
        System.out.println();
        
        System.out.println("Enter string to remove: ");
        
        input = scnr2.next();
        }
        
    }
}

