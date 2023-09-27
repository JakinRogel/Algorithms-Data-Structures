package app;

public class Driver {

	public static void main(String[] args) {
		
		System.out.println("Test Program...");
		
		MyString s1 = new MyString("Bilbo Baggins");
		
		System.out.println("testing the custom Constructor - passing s1 as parameter");
		
		System.out.println("\'" + s1.toString() + "\' was returned when object is instantiated and then passed to string");
		
		System.out.println();

		MyString s2 = new MyString("Frodo Baggins");
		
		System.out.println("s1 = \'" + s1.toString() + "\' and s2 = \'" + s2.toString() + "\'");
		
		System.out.println();
		
		System.out.println("testing the default Constructor");
		
		MyString default1 = new MyString();
		
		System.out.println("\'" + default1.toString() + "\' was returned when object is instantiated then passed to string");
		
		System.out.println();
		
		System.out.println("testing copy constructor - copying s1 to new string s3...");
		
		MyString s3 = new MyString(s1);
		
		System.out.println("s1 = \'" + s1.toString() + "\' and s3 = \'" + s3.toString() + "\'");
		
		System.out.println();
		
		System.out.println("testing .length()...");
		
		System.out.println("there are " + s1.length() + " characters in \'" + s1.toString() + "\'");
		
		System.out.println();
		
		System.out.println("testing the toString function - s1");
		
		System.out.println("the toString() for s1 returned \'" + s1.toString() + "\'");
		
		System.out.println();
		
		System.out.println("testing the concat function - concatenating s1 to s2");
		
		System.out.println("the concat() for s1 with s2 returned \'" + s1.concat(s2) + "\'");
		
		System.out.println();
		
		System.out.println("testing the compareTo function - assigning s1 to s3...");
		
		System.out.println("the compareTo() returned " + s1.compareTo(s3) + " meaning the objects are equal");
		
		System.out.println();
		
		System.out.println("testing the get function - s1 index 4 expected 'o' ");
		
		System.out.println("the get() for s1 index 4 returned \'" + s1.get(4) + "\'");
		
		System.out.println();
		
		System.out.println("testing the toUpper function - s1");
		
		System.out.println("the toUpper() for s1 returned \'" + s1.toUpper() + "\'");
		
		System.out.println();

		System.out.println("testing the toLower function - s1");
		
		System.out.println("the toLower() for s1 returned \'" + s1.toLower() + "\'");
		
		System.out.println();
		
		System.out.println("testing the substring function - s1 with index 3 expected 'Bilb'");
		
		System.out.println("the substring() for s1 parameter int 3 returned \'" + s1.substring(3) + "\'");
		
		System.out.println();
		
		System.out.println("testing the substring function - s1 starting at index 1 and ending at index 8 expected 'ilbo Bag'");
		
		System.out.println("the substring() for s1 parameter int 1 and int 8 returned \'" + s1.substring(1, 8) + "\'");
		
		System.out.println();
		
		MyString s4 = new MyString("Baggins");
		
		System.out.println("testing the indexOf function - s1 will be evaluated to s4 expected '6'");
		
		System.out.println("the indexOf() for s1 evaluating s4 returned \'" + s1.indexOf(s4) + "\'");
		
		System.out.println();
		
		MyString s5 = new MyString("Bilbo");
		
		MyString s6 = new MyString("Bilbo Bilbo Bilbo Bilbo");
		
		System.out.println("testing the lastIndexOf function - s6 will be evaluated to s5 expected '18'");
		
		System.out.println("the lastIndexOf() for s6 evaluating s5 returned \'" + s6.lastIndexOf(s5) + "\'");
		
		System.out.println();
		
		System.out.println("ALL TESTS COMPLETED");

	}

}
