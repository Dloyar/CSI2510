package exercice1;
/**
 * Node used for chained data structures.
 * This class is used to create a single element in such chains (simple chained).
 */
public class Node {
	// Element in the node.
	private Object element;

	// Next element after this node.
	private Node next;

	/**
	 * Node class constructor without parameters.
	 * @return a node with null reference to its element and next node.
	 */
	public Node() {
		this(null, null);
	}


	/**
	 * Node class constructor given an object and next node.
	 * @param  Object e             element to store in the node
	 * @param  Node   n             next node
	 * @return        created node with element e and next node n
	 */
	public Node( Object e, Node n ) {
		element = e;
		next    = n;
	}


	/** Getters */
	public Object getElement() {
		return element;
	} /* getElement */


	public Node getNext() {
		return next;
	} /* getNext */


	/** Setters */
	public void setElement( Object newElem ) {
		element = newElem;
	} /* setElement */


	public void setNext( Node newNext ) {
		next = newNext;
	} /* setNext */


}
