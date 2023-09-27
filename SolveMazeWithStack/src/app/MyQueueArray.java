package app;

public class MyQueueArray {
	private MazeCell[] array = new MazeCell[16];
	private int rear = 0;
	private int count;
	private int front;
	

	
	
	public MyQueueArray() {
		
	}
	
	public MyQueueArray(MazeCell obj) { //T= O(n)
		this.array[0] = obj;
		
		front = 0;
		rear = 1;
		count++;
	}
	

	public void push(MazeCell obj) {
		array[rear++] = obj; 
		count++;

	}
	
	public void pop() {
		if(front == rear-2) {
			array[front] = null;
		count--;
		}
		array[front] = null;
		front++;
		count--;
	}
	
	public boolean empty() {
		return count == 0;
	}
	
	public int size() {
		return 0;
	}
	
	public MazeCell front() {
		return array[front];
	}
	
	
	@Override
	public String toString() { //T= O(1)
		String str = "";
		
		for(int i = front; i < rear; i++) 
		str += array[i].toString();
		
		return str;
	}

}
