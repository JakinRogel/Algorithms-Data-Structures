import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DLinkedList<Thing extends Comparable<Thing>> {
	
	public static void main(String[] args) throws FileNotFoundException {
		// Making two DoublyLinkedLists:
		DLinkedList<String> lst1 = new DLinkedList<>();
		DLinkedList<String> lst2 = new DLinkedList<>();
		// Scanning the file text1.in
		Scanner fin = new Scanner(new File("text1.in"));
		// Making a loop to scan each word and adding them to the 1st list.
		String str;
		while (fin.hasNext()) {
			str = fin.next();
			str = cleanUp(str);
			lst1.insertOrderUnique(str);
			
		}
		fin.close();
		// Scanning the file text2.in. Then, making a loop to scan each word and adding them to the 2nd list.
		fin = new Scanner(new File("text2.in"));
		while (fin.hasNext()) {
			str = fin.next();
			str = cleanUp(str);
			lst2.insertOrderUnique(str);
		}
		// Testing Remove function:
		lst1.remove("baby");
		System.out.println("List 1:  " + lst1);
		System.out.println("List 2:  " + lst2);
		// Merge function being tested out. The new merged list is stored in the list "combined".
		DLinkedList combined = lst1.merge(lst2);
		
		System.out.println("\nAFTER MERGE");
		System.out.println("List 1:  " + lst1);
		System.out.println("List 2:  " + lst2);
		System.out.println("\n" + combined);
	}
	
	/**
	 * ASSIGNED
	 * @param str
	 * @return str in all lower case with LEADING and TRAILING non-alpha 
	 * chars removed
	 */
	public static String cleanUp(String str) { // T= O(n)
		
		// Converting the string to a Lower Case
		str = str.toLowerCase();
		int size = str.length();
		// Taking off non-Alpha characters in the front.
		int i = 0;
		while(i < size) {
			// Filtering the starting part of the word to see if they are alphabetic.
		if (Character.isAlphabetic(str.charAt(i))) {
			str = str.substring(i);
			break;
			}
		i++;
		}
		//taking off non-Alpha characters from the back
		i = str.length();
		while(i > 0) {
			if(Character.isAlphabetic(str.charAt(i-1))) {
				str = str.substring(0, i);
				break;
			}
			i--;
		}
		
		return str;
	}
	
	//inner DNode class: Provided
	private class DNode { //T = O(1)
		private DNode next, prev;
		private Thing data;
		
		private DNode(Thing val) {
			this.data = val;
			next = prev = this;
		}
	}
	
	//DLinkedList fields:  PROVIDED
	private DNode header;
	
	//create an empty list:  PROVIDED
	public DLinkedList() {
		header = new DNode(null);
	}
	
	/**
	 * PROVIDED add
	 * 
	 * @param item return ref to newly inserted node
	 */
	public DNode add(Thing item) { //T= O(1)
		//make a new node
		DNode node = new DNode(item);
		//update newNode
		node.prev = header;
		node.next = header.next;
		//update surrounding nodes
		header.next.prev = node;
		header.next = node;
		return node;
	}
	
	//PROVIDED
	public String toString() { //T= O(n)
		String str = "[";
		DNode curr = header.next;
		while (curr != header) {
			str += curr.data + " ";
			curr = curr.next;
		}
		str = str.substring(0, str.length() - 1);
		return str + "]";
	}
	
	/**
	 * ASSIGNED
	 * remove val from the list
	 * 
	 * @param val
	 * @return true if successful, false otherwise
	 */
	public boolean remove(Thing val) {// T= O(n)
		
		DNode curr = header.next;
		boolean success = false;
		while(curr != header) {
			if(curr.data.equals(val)) {
				// connecting nodes surrounding curr. curr gets garbage collected.
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
				//success is true if this happens at least once
				success = true;
				break;
			}
			curr = curr.next;
		}
		return success;
	}
	
	/**
	 * ASSIGNED
	 * 
	 * @param item
	 */
	public void insertOrder(Thing item) { //T = O(n)
		//make a new node
		DNode node = new DNode(item);
		if(header.next == header)
			add(item);
		else {
			DNode curr = header.next;
			while(curr != header) {
				if(node.data.compareTo(curr.data) < 0|| node.data.compareTo(curr.data) == 0) {
					// add Node behind the current curr node.
					node.next = curr;
					node.prev = curr.prev;
					curr.prev.next = node;
					curr.prev = node;
					break;
				}
				else if (curr.next == header && node.data.compareTo(curr.data) > 0) {
					// to add in the end header.
					node.prev = curr;
					node.next = curr.next;
					curr.next.prev = node;
					curr.next = node;
					break;
				}
				curr = curr.next;
			}
		}
	}
	
	/**
	 * ASSIGNED
	 * 
	 * @param item
	 */
	public boolean insertOrderUnique(Thing item) { // T = O(1)
		// Check if any node has this item already.
		if (header.next == header) {
			insertOrder(item);
			return false; 
		}
		else
		{
			// if header.next is not equal to header, then there is at least one node that has data.
			DNode curr = header.next;
			while (curr != header)
			{
				// checking if item matches one of the nodes' data.
				if (item.equals(curr.data))
					return true;
				curr = curr.next;
			}
		}
		insertOrder(item);
		return false;
		
		
	}
	
	/**
	 * ASSIGNED
	 * PRE: this and rhs are sorted lists
	 * @param rhs
	 * @return list that contains this and rhs merged into a sorted list
	 * POST:  returned list will not contain duplicates
	 */
	public DLinkedList merge(DLinkedList rhs) { //T = O(n)
		// Make a list that stores in the new merged result.
		DLinkedList result = new DLinkedList();
		DNode curr = result.header.next;
		// Make a node that reads through the first list.
		DNode node = header.next;
		// Make a second node that reads through the second list (this case, rhs)
		DNode node2 = rhs.header.next;
		
		while(node != header && node2 != rhs.header) {
			// inserting value from either node or node2 depending on whichever has a smaller value.
			if(node.data.compareTo(node2.data) < 0) {
				// move node into result
				node.prev.next = node.next;
				node.next.prev = node.prev;
				
				node.next = result.header;
				node.prev = result.header.prev;
				
				result.header.prev.next = node;
				result.header.prev = node;
				// update node's position
				node = header.next;
			}
			// checking to see if value from node equals to node2, so that it can skip this value in node.
			else if(node.data.equals(node2.data))
				node = node.next;
			// The following code in 'else' is if node2's value > node's value.
			else {
				// move node2 into result
				node2.prev.next = node2.next;
				node2.next.prev = node2.prev;

				node2.next = result.header;
				node2.prev = result.header.prev;

				result.header.prev.next = node2;
				result.header.prev = node2;
				// update node2's position
				node2 = rhs.header.next;
			}
		}
		// Making a while loop to keep adding all the values of node without checking for node2, 
		// since node2 can now be null. (If the 2nd list has been completely scanned).
		while (node != header)
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;

			node.next = result.header;
			node.prev = result.header.prev;

			result.header.prev.next = node;
			result.header.prev = node;
			// move nodes, update A
			node = header.next;
		}
		// Making a while loop to add words from node2 when node gets null since the 1st list is empty now.
		while (node2 != rhs.header)
		{
			node2.prev.next = node2.next;
			node2.next.prev = node2.prev;

			node2.next = result.header;
			node2.prev = result.header.prev;

			result.header.prev.next = node2;
			result.header.prev = node2;
			node2 = rhs.header.next;
		}
		return result;
	}
	
	
}