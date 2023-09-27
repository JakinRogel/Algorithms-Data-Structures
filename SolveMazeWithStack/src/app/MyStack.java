package app;

import java.awt.Point;


public class MyStack {
	private Point[] array = new Point[16];
	private int index = 0;
	
	
	public MyStack() { //T= O(1)
		
	}
	//adding Maze Obj to Point Array
	public void push(MazeCell obj) { //T= O(1)
		
		Point temp = new Point(obj.getRow(), obj.getCol());
		
		array[index] = temp;
		index++;
	}
	
	public int size() { //T= O(1)
		return index;
	}
	
	public boolean empty() { //T= O(1)
		return index == 0;
	}
	
	public Point top() { //T= O(1)
		return array[--index];
	}
	
	public void pop() { //T= O(1)
		array[index] = null;
		index--;
	}
	
	public Point[] sort() { //T= O(n^2)
		//Bubble Sort x in Array
        for (int i = 0; i < index - 1; i++)
            for (int j = 0; j < index - i - 1; j++)
                if (array[j].x > array[j + 1].x) {
                    // swap arr[j+1] and arr[j]
                    var temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        //Bubble Sort y if x is 0, 1, 2, & 3
        for (int i = 0; i < index - 1; i++)
            for (int j = 0; j < index - i - 1; j++)
            	//Bubble Sort y if x is 0
            	if((array[j].x == 0 && array[j+1].x == 0)) {
                if (array[j].y > array[j + 1].y) {
                    // swap arr[j+1] and arr[j]
                    var temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            	}
        		//Bubble Sort y if x is 1
            	else if((array[j].x == 1 && array[j+1].x == 1)) {
                    if (array[j].y > array[j + 1].y) {
                        // swap arr[j+1] and arr[j]
                        var temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            	}
        		//Bubble Sort y if x is 2
            	else if((array[j].x == 2 && array[j+1].x == 2)) {
                    if (array[j].y > array[j + 1].y) {
                        // swap arr[j+1] and arr[j]
                        var temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            	}
        		//Bubble Sort y if x is 3
            	else if((array[j].x == 3 && array[j+1].x == 3)) {
                    if (array[j].y > array[j + 1].y) {
                        // swap arr[j+1] and arr[j]
                        var temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            	}
		return array;
	}
	
	@Override
	public String toString() { //T= O(1)
		String str = "";
		
		for(int i = 0; i < index; i++) 
		str +=  "(" + array[i].x + "," + array[i].y + ")";

		
		return str;
	}
	//Finds path to end from start
	public Point[] path(MazeCell start) { //T= O(n^2)
		int index2 = 0;
		Point[] arrayPath = new Point[16];
		Point start2 = new Point(start.getRow() ,start.getCol());
		arrayPath[0] = start2;
		//Bubble Sort Row 0 if y is adjacent 
		for(int i = 0; i < index; i++) 
		if(array[i].x==0) {
			if(array[i].y == start2.y+1) {
				Point next = array[i];
				arrayPath[++index2] = next;
				start2 = next;
			}
		}
		//Bubble Sort Row 1 if y is adjacent 
		else if(array[i].x==1) {
			if(array[i].y == start2.y) {
				Point next = array[i];
				arrayPath[++index2] = next;
				start2 = next;
			}
		}
		//Bubble Sort Row 2 if y is adjacent 
		else if(array[i].x==2) {
			if(array[i].y == start2.y || array[i].y == start2.y-1 || array[i].y == start2.y + 1 ) {
				Point next = array[i];
				arrayPath[++index2] = next;
				start2 = next;
			}
		}
		//Bubble Sort Row 3 if y is adjacent 
		else if(array[i].x==3) {
			if(array[i].y == start2.y || array[i].y == start2.y-1 || array[i].y == start2.y + 1 ) {
				Point next = array[i];
				arrayPath[++index2] = next;
				start2 = next;
			}
		}
		index2++;
		index = index2;
		array = arrayPath;
		start2 = array[5];
		array[5] = array[6];
		array[6] = start2;
		
		return array;
		
	}

}
