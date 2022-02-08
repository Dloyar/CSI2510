/*
 * doubly linked list of integers 
 * (with dummy element)
 *
 * CSI2510 Algortihmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2017
 *
*/
public class DoublyLinkedListExercice2<E>{

    private class Node<E> {

        public E element;
        public Node<E> prev;
        public Node<E> next;

        public Node(E v, Node<E> p, Node<E> n) {
            element = v;
            prev = p;
            next = n;
        }
    }

    private Node<E> head;
    private int size;

    // construct empty list
    public DoublyLinkedListExercice2() {
        head = new Node(null, null, null);
        head.prev = head.next = head;
        size = 0;
    }

    // get the list size
    public int getSize() {
        return size;
    }

    // add a new integer (most efficient)
    public boolean add(E value) {
        Node newNode = new Node(value, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;

        size++;

        return true;
    }

    // add a new integer (least efficient)
    public boolean addOppositeSide(E value) {
        Node newNode = new Node(value, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;

        size++;

        return true;
    }

    // search a node in the list, given an element.
    // Returns -1 if it's not in the list
    public E search(E value) {

        Node<E>n = head.next;

        while (n != head && n.element.equals(value)) {
            n = n.next;
        }

        if (n == head) {
            return null;
        }

        return n.element;
    }

    // remove a given integer (first occurrence of)
    public boolean searchAndRemove(E value) {

        Node<E> n = head.next;

        while (n != head && n.element.equals(value)) {
            n = n.next;
        }

        if (n != head) {

            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
            return true;

        } else {

            return false;
        }
    }

    // remove element at a given index
    public boolean removeAt(int index) {

        if (index < 0 || index >= size) {
            return false;
        }

        size--;

        Node<E> n = head.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        n.prev.next = n.next;
        n.next.prev = n.prev;

        return true;
    }

    // return the first element of the list
    public E getFirst() {
        return head.next.element;
    }

    // string representation
    public String toString() {

        StringBuffer s = new StringBuffer("");

        for (Node node = head.next; node != head; node = node.next) {
            s.append("[" + node.element + "]");
        }

        return s.toString();
    }
}
