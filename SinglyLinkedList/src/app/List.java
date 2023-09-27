package app;


public class List {

	private Node first;
	private Node last;
	private int size;
	
	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) { //T = O(1)
			this.value = value;
		}
	}

	//default constructor
	public List() { //T = O(1)
		
		this.first = this.last = null;

	}
	
	//copy constructor - myList(aList)
	public List(List list) { //T = O(n)
		
		this.size = 0;
		
		Node curr = list.first;
		
		while (curr != null) {
			
			this.insert(curr.value);
			
			curr = curr.next;

		
		}
		
		
		
		
	}

	
	//access to first element - myList.front()
	public int front() { //T = O(1)
		return this.first.value;
	}
	//access to last element - myList.back()
	public int back() { //T = O(1)
		return this.last.value;
	}
	
	
	//insert value - myList.insert(val)
	public void insert(int item) { //T = O(1)
		var node = new Node(item);
		
		if (first == null) 
			first = last = node;
		else {
			last.next = node;
			last = node;
		}
		size++;
	}
	
	//remove value at front - myList.pop_front()
	public void pop_front() { //T = O(1)
		
		var temp = this.first.next;
		this.first.next = null;
		this.first = temp;
		size--;
		
	}
	//remove value at tail - myList.pop_back()
	public void pop_back() { //T = O(n)
		
		var temp = this.first;
		
		if(first == last) 
			first = last = null;
		else {
			while (temp != null) {
				if(temp.next == this.last) break;
				temp = temp.next;
			}
			
			last = temp; 
			
			last.next = null;
		}
		
		size--;
		
	}
	//return true if list is empty - myList.empty()
	public boolean empty() { //T = O(1)
		return size <= 0;
	}
	//return # of elements 
	public int size() { //T = O(1)
		return size;
	}
	
	//reverse order of elements in list - myList.reverse()
	public void reverse() { //T = O(n)
		
		var last = this.first;
		var temp = this.first;
		Node prev = null;
		Node next = null;
		
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		
		this.first = prev;
		
		this.last = last;
		
	}
	
	//merge another ordered list - myList.merge(aList)
	public void merge(List list) { //T = O(n)
		
		Node curr = list.first;
		
		while(curr != null) {
			this.insert(curr.value);
			curr = curr.next;
		}
	}
	
	//order the list into ascending order
	public void orderAscending() { //T = O(n^2)
        // Node current will point to head
        Node current = this.first, index = null;
 

        int temp;

            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
 
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data between them
                    if (current.value < index.value) {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }
 
                    index = index.next;
                }
                current = current.next;
            }
            
        }
	
	public void print() { //T = O(n)
		
		var temp = this.first;
		
        while (temp != null) {
            // Prints each node by incrementing pointer
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
 
        System.out.println();
    }
	
}
