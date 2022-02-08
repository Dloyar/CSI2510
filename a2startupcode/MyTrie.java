/*** 
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 * 
 * Name:   
 * Student Number: 
 * Uottawa Email: 
 * 
 *
 */

public class MyTrie {
	
	private TreeNode root = null;

	private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node 
	public MyTrie() {
		root = new TreeNode(null, null, null,false); 
		numNodes=1;
	}

	// Method to be implemented by you. See handout part 1A
	public boolean insert(String s) {
 
		// ***** method code to be added in this class *****
		// now we just have a dummy that prints  message and returns true.
		System.out.println("insert(String) not implemented!");
		return true;

	}
	
	// Method to be implemented by you. See handout part 1A
	public boolean search(String s) {
		// **** method code to be added in this class *****
		// now we just have a dummy that prints  message and returns true.
		System.out.println("search(String) not implemented!");
		return true;	
	    
	}

	

	// Method to be implemented by you. See handout part 1A	
	public void printStringsInLexicoOrder() {
		// ***** method code to be added in this class *****
		// now we just have a dummy method that prints a message.
		System.out.println("printStringsInLexicoOrder() not implemented!");

	}
	
	
	
	// the following method that calls its recursive counterpart
	// prints the tree and its boolean values at nodes in 
	// in-order traversal order
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(N.getIsUsed());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}
	

	
	public TreeNode root() { // not to be changed
		return root;
	}
	
	public int numNodes() { // not to be changed
		return numNodes;
	}


}
