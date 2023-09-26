package app;

public class  RBTree {
	  private class RBNode {
	    private int height;
	    private int value;
	    private RBNode leftChild;
	    private RBNode rightChild;

	    public RBNode(int value) {
	      this.value = value;
	    }

	    @Override
	    public String toString() {
	      return "Value=" + this.value;
	    }
	  }

	  private RBNode root;

	  public void insert(int value) {
	    root = insert(root, value);
	  }

	  private RBNode insert(RBNode root, int value) {
	    if (root == null)
	      return new RBNode(value);

	    if (value < root.value)
	      root.leftChild = insert(root.leftChild, value);
	    else
	      root.rightChild = insert(root.rightChild, value);

	    setHeight(root);

	    return balance(root);
	  }

	  private RBNode balance(RBNode root) {
	    if (isLeftHeavy(root)) {
	      if (balanceFactor(root.leftChild) < 0)
	        root.leftChild = rotateLeft(root.leftChild);
	      return rotateRight(root);
	    }
	    else if (isRightHeavy(root)) {
	      if (balanceFactor(root.rightChild) > 0)
	        root.rightChild = rotateRight(root.rightChild);
	      return rotateLeft(root);
	    }
	    return root;
	  }

	  private RBNode rotateLeft(RBNode root) {
	    var newRoot = root.rightChild;

	    root.rightChild = newRoot.leftChild;
	    newRoot.leftChild = root;

	    setHeight(root);
	    setHeight(newRoot);

	    return newRoot;
	  }

	  private RBNode rotateRight(RBNode root) {
	    var newRoot = root.leftChild;

	    root.leftChild = newRoot.rightChild;
	    newRoot.rightChild = root;

	    setHeight(root);
	    setHeight(newRoot);

	    return newRoot;
	  }

	  private void setHeight(RBNode node) {
	    node.height = Math.max(
	            height(node.leftChild),
	            height(node.rightChild)) + 1;
	  }

	  private boolean isLeftHeavy(RBNode node) {
	    return balanceFactor(node) > 1;
	  }

	  private boolean isRightHeavy(RBNode node) {
	    return balanceFactor(node) < -1;
	  }

	  private int balanceFactor(RBNode node) {
	    return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
	  }

	  private int height(RBNode node) {
	    return (node == null) ? -1 : node.height;
	  }
	}

