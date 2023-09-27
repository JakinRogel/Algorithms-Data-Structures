package binaryTree;

public class Tree {
	// create node class
  private class Node {
    private String value;
    private Node leftChild;
    private Node rightChild;

    public Node(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node=" + value;
    }
  }

  private Node root;
  private int inspected;
  //inserts nodes into BT
  public void insert(String value) { // T = O(logn)
    var node = new Node(value);

    if (root == null) {
      root = node;
      return;
    }

    var current = root;
    //orders nodes below parent value on right if greater and left if less than
    while (true) {
    	//compares current node to passed value if greater than...
      if (current.value.compareTo(value) > 0) {
        if (current.leftChild == null) {
        	//set left child to node instantiated
          current.leftChild = node;
          break;
        }
        current = current.leftChild;
      }
      else {
        if (current.rightChild == null) {
          current.rightChild = node;
          break;
        }
        current = current.rightChild;
      }
    }
  }

  public boolean find(String value) { // T = O(logn)
	  //used to determine how many elements traversed
	  inspected = 0;
    var current = root;
    //traverses BT returns true if value is found
    while (current != null) {
    	//determines if value is on left side
      if (current.value.compareTo(value) > 0) {
        current = current.leftChild;
        inspected++;
      }
      //determines if value is on right side
      else if (current.value.compareTo(value) < 0) {
        current = current.rightChild;
        inspected++;
      }
      else
        return true;
    }
    return false;
  }
  
 
  
  public int getInspected() {// T = O(1)
	return inspected;
  }
  
  public Node getRoot() {// T = O(1)
	  return root;
  }

  public void traverseInOrder() {// T = O(1)
	  traverseInOrder(root);
  }
  //prints BT in ascending order recursively 
  private void traverseInOrder(Node root) { // T = O(logn)
		  if(root == null)
			  return;
		  //passes leftchild as root, prints current value, then passes rightchild
		  traverseInOrder(root.leftChild);
		  System.out.print(root.value + " ");
		  traverseInOrder(root.rightChild);
  }
  //finds value and removes it recursively 
  public Node remove(Node root, String value) { // T = O(logn)
	  if(!find(value)) {
		  System.out.println("No Such Value Found");
		  return null;
	  }
	  //searches for correct node
      if (root.value.compareTo(value) > 0) {
          root.leftChild = remove(root.leftChild, value);
      } else if (root.value.compareTo(value) < 0) {
          root.rightChild = remove(root.rightChild, value);
      } else {
    	  //once correct node is found checks if it has one child
          if (root.leftChild == null) {
              return root.rightChild;
          } else if (root.rightChild == null)
              return root.leftChild;
          //if node has two children then find lowest value
          root.value = inOrderSuccessor(root.rightChild);
          root.rightChild = remove(root.rightChild, root.value);
      }

	  
	return root;
	  
  }

  	private String inOrderSuccessor(Node root) { // T = O(logn)
        String minimum = root.value;
        //determines minimum value in branches connected to deleted node
        while (root.leftChild != null) {
            minimum = root.leftChild.value;
            root = root.leftChild;
        }
        
        return minimum;
}


}
  

