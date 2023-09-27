package app;

 
// A class to represent a queue
// The queue, front stores the front node of LL and rear
// stores the last node of LL
public class MyQueue {
	
	int size;
    QNode front, rear;
 
    public MyQueue() {  //T= O(1)
    	this.front = this.rear = null; 
    	}
 
	// Method to add a key to the queue.
    void push(MazeCell obj) //T= O(1)
    {
 
        // Create a new LL node
        QNode temp = new QNode(obj);
 
        // If queue is empty, then new node is front and
        // rear both
        if (this.front == null) {
            this.front = this.rear = temp;
            return;
        }
        
        // Add the new node at the end of queue and change
        // rear
        this.rear.next = temp;
        this.rear = temp;
        
        size++;
    }
 
    // Method to remove an key from queue.
    void pop() //T= O(1)
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;
 
        // Store previous front and move front one node
        // ahead
        QNode temp = this.front;
        this.front = this.front.next;
 
        // If front becomes NULL, then change rear also as
        // NULL
        if (this.front == null)
            this.rear = null;
        
        size--;
    }
    
    public int size() { //T= O(1)
    	return size;
    }
    
    public boolean empty() { //T= O(1)
    	return size == 0;
    }
    
    public QNode front() { //T= O(1)
    	return this.front;
    }

    
    @Override
    public String toString() { //T= O(n)
    	String str = "";
    	
    	QNode temp = front;
    	
    	while(temp.next != null) {
    		str += temp.key;
    		temp = temp.next;
    	}
    	
    	return str;
    }
    

    class QNode { //T= O(1)
    	MazeCell key;
    	QNode next;
 
    // constructor to create a new linked list node
    	public QNode(MazeCell obj) //T= O(1)
    {
        this.key = obj;
        this.next = null;
    }
}
}