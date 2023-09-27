package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//starter code for MazeSolver
//CST-201

public class Driver {
	/** 
	 *  @param start 
	 *   @param end 
	 *   find a path through the maze 
	 *    if found, output the path from start to end
	 *     if not path exists, output a message stating so 
	 *      
	 */
	 // implement this method
	 public static void depthFirst(MazeCell start, MazeCell end) throws FileNotFoundException {
		 //instantiate stack and queue push start
		MyQueue queue = new MyQueue();
		MyStack stack = new MyStack();
		queue.push(start);
		stack.push(start);
		// System.out.println(testQ.toString());
		 
		 //create the Maze from the file
		 Scanner fin = new Scanner(new File("Maze.in"));
		 //read in the rows and cols
		 int rows = fin.nextInt();
		 int cols = fin.nextInt();
		 //create the maze
		 int [][] grid = new int[rows][cols];
		 //read in the data from the file to populate
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < cols; j++) {
				 grid[i][j] = fin.nextInt();
				 }
			 }

		 //make a 2-d array of cells
		 MazeCell[][] cells = new MazeCell[rows][cols];
		 //populate with MazeCell obj - default obj for walls
		 MazeCell next = new MazeCell();
		 //iterate over the grid, make cells and set coordinates
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < cols; j++) {
				 //make a new cell
				 cells[i][j] = new MazeCell();
				 //if it isn't a wall, set the coordinates
				 if (grid[i][j] != 0) {
					 cells[i][j].setCoordinates(i, j);
					 //look for the paths
					 if (grid[i][j] == 1 || grid[i][j] == 4) {
						 next = cells[i][j];
						 queue.push(next);
						 stack.push(next);
					 }
					 }
				 }
			 }

		queue.push(end);
		//Printing Queue and Stack
		System.out.println();
		System.out.println("Printing Queue");
		System.out.println(queue.toString());
		System.out.println();
		System.out.println("Printing Stack");
		System.out.println(stack.toString());
		System.out.println();
		//Sorting Stack
		System.out.println("Sorting Stack");
		stack.sort();
		System.out.println(stack.toString());
		System.out.println();
		//Printing Path
		System.out.println("Creating Path");
		stack.path(start);
		System.out.println(stack.toString());
		System.out.println();
		
		
	 }
	 
	 public static void main(String[] args) throws FileNotFoundException {
		 //create the Maze from the file
		 Scanner fin = new Scanner(new File("Maze.in"));
		 //read in the rows and cols
		 int rows = fin.nextInt();
		 int cols = fin.nextInt();
		 //create the maze
		 int [][] grid = new int[rows][cols];
		 //read in the data from the file to populate
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < cols; j++) {
				 grid[i][j] = fin.nextInt();
				 }
			 }
		 //look at it
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < cols; j++) {
				 if (grid[i][j] == 3)
					 System.out.print("S ");
				 else if (grid[i][j] == 4)
					 System.out.print("E ");
				 else
					 System.out.print(grid[i][j] + " ");
				 }
			 System.out.println();
			 }
		 //make a 2-d array of cells
		 MazeCell[][] cells = new MazeCell[rows][cols];
		 //populate with MazeCell obj - default obj for walls
		 MazeCell start = new MazeCell(), end = new MazeCell();
		 //iterate over the grid, make cells and set coordinates
		 for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < cols; j++) {
				 //make a new cell
				 cells[i][j] = new MazeCell();
				 //if it isn't a wall, set the coordinates
				 if (grid[i][j] != 0) {
					 cells[i][j].setCoordinates(i, j);
					 //look for the start and end cells
					 if (grid[i][j] == 3)
						 start = cells[i][j];
					 if (grid[i][j] == 4)
						 end = cells[i][j];
					 }
				 }
			 }
		 //testing
		 System.out.println("start:"+start+" end:"+end);
		 //solve it!
		 depthFirst(start, end);
		 }
	 }
				 
			 
		 
