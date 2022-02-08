package exercice2;
/**
 *  Class to test doubly linked list
 *  @author Jeff Souza
 */

class TestDLinkedList {

	public static void main( String [] args ) {

		// Create a new node, with data = 1
		ListNode    nNode = new ListNode();

		nNode.data = 1;

		// Create a new doubl- linked list with the node
		DLinkedList    list = new DLinkedList();

		list.firstNode = nNode;
		list.lastNode  = nNode;

		// Add items to linked list (2, 3, 4, 5, 6, 7 , 8, 9 and 10)
		for( int i = 2; i < 11; i++ ) {
			nNode      = new ListNode();
			nNode.data = i;
			list.AppendNode ( nNode );
		}

		// Print the content of the list
		System.out.println();
		list.print();

		// Remove items from linked list (2 first elements and the last one)
		System.out.println ( "items removed." );

		list.RemoveNode ( list.firstNode );
		list.RemoveNode ( list.firstNode );
		list.RemoveNode ( list.lastNode );

		// Print the content of the list
		list.print();
	} /* main */


}
