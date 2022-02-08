/**
 * Array Heap implementation of a priority queue
 * @author Lachlan Plant
 */
public class HeapPriorityQueue <K extends Comparable, V>implements PriorityQueue <K, V> {

	private Entry [] storage; //The Heap itself in array form
	private int tail;    //Index of last element in the heap

	/**
	 * Default constructor
	 */
	public HeapPriorityQueue() {
		this(50);
	}


	/**
	 * HeapPriorityQueue constructor
	 * @param size maximum storage size
	 */
	public HeapPriorityQueue( int size ) {
		storage = new Entry[size];
		tail = -1;
	}


	/****************************************************
	*
	*             Priority Queue Methods
	*
	****************************************************/

	/**
	 * Returns the number of items in the priority queue.
	 * O(1)
	 * @return number of items
	 */
	public int size() {
	
		return tail+1;
	} /* size */


	/**
	 * Tests whether the priority queue is empty.
	 * O(1)
	 * @return true if the priority queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return tail<0;
	} /* isEmpty */


	/**
	 * Inserts a key-value pair and returns the entry created.
	 * O(log(n))
	 * @param key     the key of the new entry
	 * @param value   the associated value of the new entry
	 * @return the entry storing the new key-value pair
	 * @throws IllegalArgumentException if the heap is full
	 */
	public Entry <K, V>insert( K key, V value ) throws IllegalArgumentException {
		return null;
	} /* insert */


	/**
	 * Returns (but does not remove) an entry with minimal key.
	 * O(1)
	 * @return entry having a minimal key (or null if empty)
	 */
	public Entry <K, V>min() {
		return null;
	} /* min */


	/**
	 * Removes and returns an entry with minimal key.
	 * O(log(n))
	 * @return the removed entry (or null if empty)
	 */
	public Entry <K, V>removeMin() {
		return null;
	} /* removeMin */


	/****************************************************
	*
	*           Methods for Heap Operations
	*
	****************************************************/

	/**
	 * Algorithm to place element after insertion at the tail.
	 * O(log(n))
	 */
	private void upHeap( int location ) {
		if(location == 0)
			return;
		int parent = parent(location);
		if (storage[location].key.compareTo(storage[parent].key)<0) {
			swap(parent,location);
			upHeap(parent);
		}
	} /* upHeap */


	/**
	 * Algorithm to place element after removal of root and tail element placed at root.
	 * O(log(n))
	 */
	private void downHeap( int location ) {
		return;
	} /* downHeap */


	/**
	 * Find parent of a given location,
	 * Parent of the root is the root
	 * O(1)
	 */
	private int parent( int location ) {
		return (location-1)/2;
	} /* parent */


	/**
	 * Inplace swap of 2 elements, assumes locations are in array
	 * O(1)
	 */
	private void swap( int location1, int location2 ) {
		Entry<K,V> tempNode = storage[location1];
		storage[location1] = storage[location2];
		storage[location2] = tempNode;
	} /* swap */


}
