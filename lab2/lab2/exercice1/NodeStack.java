package exercice1;
/**
 * Implementation of Stack interface, based on Node class (dynamic).
 */
public class NodeStack implements Stack {
	// reference to the head node
	protected Node top;

	// number of elements in the stack
	protected int size;

	/**
	 * Constructor fo NodeStack class.
	 * @return an empty stack
	 */
	public NodeStack() {
		top  = null;
		size = 0;
	}


	public int size() {
		return size;
	} /* size */


	public boolean isEmpty() {
		if( top == null )
			return true;
		return false;
	} /* isEmpty */


	public Object top() throws EmptyStackException {
		if( isEmpty() )
			throw new EmptyStackException ( "Stack is empty." );

		return top.getElement();
	} /* top */


	public void push( Object elem ) {

		// create and link-in a new node
		Node    v = new Node ( elem, top );

		top = v;
		size++;
	} /* push */


	public Object pop() throws EmptyStackException {
		if( isEmpty() )
			throw new EmptyStackException ( "Stack is empty." );


		Object    temp = top.getElement();

		// link-out the former top node
		top = top.getNext();
		size--;

		return temp;
	} /* pop */


}
