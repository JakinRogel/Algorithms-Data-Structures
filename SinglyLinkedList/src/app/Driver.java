package app;

public class Driver {

	public static void main(String[] args) {
		//PROGRAM TEST
		
		//testing default constructor
		System.out.println("-----------testing default constructor-----------");
		List list = new List();
		System.out.println("No values to display");
		System.out.println();
		//testing Insert value
		System.out.println("-----------testing Insert values-----------");
		list.insert(6);
		list.insert(2);
		list.insert(4);
		list.insert(1);
		list.insert(7);
		list.insert(10);
		list.insert(5);
		list.insert(3);
		list.insert(9);
		list.insert(8);
		list.print();
		System.out.println();
		//testing access to first element
		System.out.println("-----------testing access to first element expected 6-----------");
		System.out.println(list.front());
		System.out.println();
		//testing Access to last element
		System.out.println("-----------testing Access to last element expected 8-----------");
		System.out.println(list.back());
		System.out.println();
		//testing Ordering List Ascending
		System.out.println("-----------testing Ordering List Ascending-----------");
		list.orderAscending();
		list.print();
		System.out.println();
		//testing Remove value at front
		System.out.println("-----------testing Remove value at front-----------");
		list.pop_front();
		list.print();
		System.out.println();
		//testing Remove value at tail
		System.out.println("-----------testing Remove value at tail-----------");
		list.pop_back();
		list.print();
		System.out.println();
		//testing Determine if empty
		System.out.println("-----------testing Determine if empty-----------");
		System.out.println(list.empty());
		System.out.println();
		//testing Return # of elements
		System.out.println("-----------testing Return # of elements-----------");
		System.out.println(list.size());
		System.out.println();
		//Reverse order of elements in list
		System.out.println("-----------testing Reverse order of elements in list-----------");
		list.reverse();
		list.print();
		System.out.println();
		//testing copy constructor
		System.out.println("-----------testing copy constructor display new list-----------");
		List list2 = new List(list);
		list2.print();
		System.out.println();
		//Merge with another ordered list
		System.out.println("-----------testing Merge with another ordered list-----------");
		list.merge(list2);
		list.print();
		System.out.println();
		//finish testing with ordered ascending
		System.out.println("-----------finish testing with ordered ascending-----------");
		list.orderAscending();
		list.print();
		
		

	}

}
