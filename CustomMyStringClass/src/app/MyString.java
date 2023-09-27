package app;

public class MyString implements Comparable<MyString> {
	//class attributes******************************************************************************
	//A char array reference (or pointer) for the array of characters that make up the string
	private char[] charArray; //O(1)
	//An integer curr_length representing the number of characters in the string
	private int curr_length; //O(1)
	//Constructors*********************************************************************************
	//A constructor that initializes the array to null and the curr_length to 0
	public MyString() { // T = c1 + c2 = O(1)
		
		this.charArray = null; //O(1)
		
		this.curr_length = 0; //O(1)
	}
	/*A constructor that takes a String parameter and initializes the char array to the 
	characters in the String.  curr_length should be appropriately initialized.*/
	public MyString(String s) { // T = n + c1 + c2 + c3 = O(n)
		//initialize size of array
		this.charArray = new char[s.length()]; //O(n)
		
		this.curr_length = s.length(); //O(1)
		
		for(int i = 0; i < s.length(); i++) //O(1)
			//set char array items to string 
			this.charArray[i] = s.charAt(i); //O(1)
		
		ensureCapacity(); 
		
	}
	/*a copy constructor that takes a MyString object and initializes a new MyString object so 
	 that it is a copy of the argument string*/
	public MyString(MyString myString) { // T = n + c1 = O(n)
		//set object array to passed object array
		this.charArray = myString.charArray; //O(n)
		
		this.curr_length = myString.curr_length; //O(1)
		
	}
	//Methods*************************************************************************************
	//a length() method that returns the number of characters in the string
	public int length() { // T = c1 = O(1)
		return this.curr_length; //O(1)
	}
	//a private method, ensureCapacity(), that handles allocation of additional memory for the string
	private char[] ensureCapacity() { // T = n + c1 + c2 + n + c3 = O(n)
		//instantiate new array to current object length times 2
		char[] charArray2 = new char[this.curr_length*2]; //O(n)
		
		for(int i = 0; i < this.curr_length; i++)  //O(1)
			//fill new array with old array
			charArray2[i] = this.charArray[i]; //O(1)
		
		
		this.charArray = charArray2; //O(n)
		
		return this.charArray; //O(1)
	}
	//a toString() method that returns a String representation of the MyString object (Java)
	@Override
	public String toString() { // T = c1 + c2 + c3 + c4 = O(1)
		
		String string = ""; //O(1)
		
		for(int i = 0; i < this.curr_length; i++) //O(1)
			string += this.charArray[i]; //O(1)
		
		return string; //O(1)
		
	}
	/*a concat(MyString) method that takes a MyString parameter and returns a MyString object that 
	is a concatenation of the calling object and the parameter (Java) */
	public MyString concat(MyString object) { // T = c1 + n + c2 + n + n + c3 = O(n)
		
		String string = ""; //O(1)
		
		string = this.toString(); //O(n)
		
		string += " " + object.toString(); //O(1) O(n)
		
		MyString concatMyString = new MyString(string); //O(n)
		
		return concatMyString; //O(1)
	}
	/*a .compareTo(MyString) method that takes a MyString parameter and returns as follows (Java)
	 *  0 if the parameter and this MyString are the same
	 *  A negative integer if this MyString is alphabetically before the parameter
	 *  A positive integer if this MyString is alphabetically after the parameter*/
	@Override
	public int compareTo(MyString object) { // T = c1 + n + c2 + c3 + n + c4 + c5 + c6 = O(n)
		//compare passed object to calling object
		if(this.toString().compareTo(object.toString()) == 0) //O(1) O(n)
			return 0; //O(1)
		//compare passed object to calling object
		else if(this.toString().compareTo(object.toString()) == 1) //O(1) O(n)
			return 1; //O(1)
		else //O(1)
			return -1; //O(1)
					
	}
	
	/*.get(int) method that takes an integer and returns the character at that index location.  
	 * PRE:  the integer must be in range (Java) */
	public char get(int index) { // T = c1 + n = O(n)
		//returns char at passed index
		return this.toString().charAt(index); //O(1) O(n)
	}
	//.toUpper() and .toLower() that return a MyString that is in all upper case (or lower case)
	public MyString toUpper() { // T = n + n + c1 = O(n)
		//instantiate new MyString object to calling object set to uppercase
		MyString upperMyString = new MyString(this.toString().toUpperCase()); //O(n) O(n)
		
		return upperMyString; //O(1)
	}
	
	public MyString toLower() { // T = c1 + n + n = O(n)
		//instantiate new MyString object to calling object set to lowercase
		MyString lowerMyString = new MyString(this.toString().toLowerCase()); //O(n) O(n)
		
		return lowerMyString; //O(1)
	}
	//.substring(int) that takes an integer and returns the substring starting at that index.
	public String substring(int index) { // T = c1 + c2 + c3 + n = O(n)
		
		String string = ""; //O(1)
		
		for(int i = 0; i <= index; i++) { //O(1)
			
			string += this.toString().charAt(i); //O(1) O(n)
		}
		
		return string; //O(1)
	}
	/* .substring(int n, int m) .  Return a MyString substring where n is the starting index 
	 * and m is one past the ending index */
	public String substring(int n, int m) { // T = c1 + c2 + c3 + n = O(n)
		
		String string = ""; //O(1)
		
		for(int i = n; i <= m; i++) { //O(1)
			
			string += this.toString().charAt(i); //O(1) O(n)
		}
		
		return string; //O(1)
	}
	/* indexOf(MyString) and .lastIndexOf(MyString) that take a MyString parameter and return the 
	 starting index of the first (or last) occurrence of the MyString in the calling object.  
	 If the parameter is not found in the calling object, the method should return -1 */
	public int indexOf(MyString object) { // T = c1 + n + n = O(n)
		//returns the first index of the string from the passed object
		return this.toString().indexOf(object.toString()); //O(1) O(n) O(n)
	}
	
	public int lastIndexOf(MyString object) { // T = c1 + n + n = O(n)
		//returns the last index of the string from the passed object
		return this.toString().lastIndexOf(object.toString()); //O(1) O(n) O(n)
	}
}
