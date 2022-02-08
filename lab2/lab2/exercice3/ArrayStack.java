package exercice3;
/**
 * Implementation of the Stack interface using a fixed-length array.
 * An exception is thrown if a push operation is attempted when the
 * size of the stack is equal to the length of the array.
 */
public class ArrayStack implements Stack {

	// Default length of the array used to implement the stack.
	public static final int CAPACITY = 1000;

	// Length of the array used to implement the stack.
	protected int capacity;

	// Array used to implement the stack.
	protected Object S [];

	// Index of the top element of the stack in the array.
	protected int top = -1;

	/**
	 * ArrayStack class constructor, with no parameter.
	 * Default length used for the array is CAPACITY.
	 */
	public ArrayStack() {
		this(CAPACITY);
	}


	/**
	 * ArrayStack class constructor.
	 * @param cap length of the array.
	 */
	public ArrayStack( int cap ) {
		capacity = cap;
		S        = new Object [ capacity ];
	}


	public int size() {
		return (top + 1);
	} /* size */


	public boolean isEmpty() {
		return (top < 0);
	} /* isEmpty */


	public Object top() throws EmptyStackException {
		if( isEmpty() )
			throw new EmptyStackException ( "Stack is empty." );

		return S [ top ];
	} /* top */


	/**
	 * Be careful here, this implementation may throw an exception.
	 * @exception FullStackException if the array is full.
	 */
	public void push( Object obj ) throws FullStackException {
		if( size() == capacity )
			throw new FullStackException ( "Stack overflow." );

		S [ ++top ] = obj;
	} /* push */


	public Object pop() throws EmptyStackException {
		if( isEmpty() )
			throw new EmptyStackException ( "Stack is Empty." );


		Object    elem = S [ top ];

		// dereference S[top] for garbage collection.
		S [ top-- ] = null;

		return elem;
	} /* pop */


}
