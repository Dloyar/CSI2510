/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 * LinkedBinarySearchTree for tree traversal lab
 * @author Lachlan Plant
 * @param <E>
 */
public class LinkedBinarySearchTree <E extends Comparable>implements Iterable <E> {

 private class Node <E> {
  E elem;

  Node <E>parent;
  Node <E>left;
  Node <E>right;
  public Node( E e, Node <E>p, Node <E>l, Node <E>r ) {
   elem   = e;
   parent = p;
   left   = l;
   right  = r;
  }


 }

 private Node <E>root;
 private int size;

 /**
  *
  */
 public LinkedBinarySearchTree() {
  root = null;
  size = 0;
 }


 /**
  * Adds elem into BST
  * @param elem
  * @return
  */
 public boolean add( E elem ) {
  if( root == null ) {
   root = new Node <> ( elem, null, null, null );
   size++;
   return true;
  }
  else {
   root = insert ( elem, root, null );
   return true;
  }
 } /* add */


 /**
  * Recursive BST insertion
  * @param elem
  * @param curr
  * @param from
  * @return
  */
 private Node <E>insert( E elem, Node <E>curr, Node <E>from ) {
  if( curr == null ) {
   curr = new Node <> ( elem, from, null, null );
   size++;
   return curr;
  }

  if( elem.compareTo ( curr.elem ) < 0 )
   curr.left = insert ( elem, curr.left, curr );

  if( elem.compareTo ( curr.elem ) > 0 )
   curr.right = insert ( elem, curr.right, curr );
  return curr;
 } /* insert */


 /*****************************************************************
 *
 * Recursive Printing Functions
 *
 *
 *****************************************************************/

 /**
  * Caller method for preorder recursive printing
  */
 public void printPreorderRecursive() {
  System.out.print ( "Recursive Preorder Printing: " );
  preorderRecursive ( root );
 } /* printPreorderRecursive */


 /**
  * preorder tree traversal, prints(curr.elem + ", ")
  * @param curr
  */
 private void preorderRecursive( Node <E>curr ) {
	System.out.print(curr.elem + ", ");

        if (curr.left != null) {

            preorderRecursive(curr.left);

        }

        if (curr.right != null) {

            preorderRecursive(curr.right);

        }
 } /* preorderRecursive */


 /**
  * Caller method for inorder recursive printing
  */
 public void printInorderRecursive() {
  System.out.print ( "Recursive Inorder Printing: " );
  inorderRecursive ( root );
 } /* printInorderRecursive */


 /**
  * inorder tree traversal, prints(curr.elem + ", ")
  * @param curr
  */
 private void inorderRecursive( Node <E>curr ) {
  //Implement Here
  if (curr.left != null) {

            inorderRecursive(curr.left);

        }



        System.out.print(curr.elem + ", ");



        if (curr.right != null) {

            inorderRecursive(curr.right);

        }
 } /* inorderRecursive */


 /**
  * Caller method for postorder recursive printing
  */
 public void printPostorderRecursive() {
  System.out.print ( "Recursive Postorder Printing: " );
  postorderRecursive ( root );
 } /* printPostorderRecursive */


 /**
  * postorder tree traversal, prints(curr.elem + ", ")
  * @param curr
  */
 private void postorderRecursive( Node <E>curr ) {
  //Implement Here
  if (curr.left != null) {

            postorderRecursive(curr.left);

        }



        if (curr.right != null) {

            postorderRecursive(curr.right);

        }



        System.out.print(curr.elem + ", ");
 } /* postorderRecursive */


 /*****************************************************************
 *
 * Iterator Functions
 *
 *
 *****************************************************************/
 public Iterator iterator() {
  return new InorderIterator();
 } /* iterator */


 public Iterator inorderIterator() {
  return new InorderIterator();
 } /* inorderIterator */


 public Iterator preorderIterator() {
  return new PreorderIterator();
 } /* preorderIterator */


 /*****************************************************************
 *
 * Iterators
 *
 *
 *****************************************************************/




 /**
  * Tree Iterator using preorder traversal for ordering
  */
 private class PreorderIterator implements Iterator <E> {
  Node <E>next;

  public PreorderIterator() {
   //Implement Here
     next = root;
    }
   
  }


  public boolean hasNext() {
    return next != null;
  } /* hasNext */


  public E next() {
   E current = next.elem;

            Node<E> parent;

            Node<E> child;

            if (next.left != null) {

                next = next.left;

            } else {

                if (next.right != null) {

                    next = next.right;

                } else {

                    parent = next.parent;

                    child = next;

                    while (parent != null && (parent.right == child || parent.right == null)) {

                        child = parent;

                        parent = parent.parent;

                    }

                    if (parent == null) {

                        next = null;

                    } else {

                        next = parent.right;

                    }

                }

            }

            return current;
   //Implement Here
  } /* next */


  public void remove() {
   // not implemented
  } /* remove */


 }

 /**
  * Tree Iterator using inorder traversal for ordering
  */
 private class InorderIterator implements Iterator <E> {

  Node <E>next;

  public InorderIterator() {
   //Implement Here
     next = root;

            if (next != null) {

                while(next.left != null) {

                    next = next.left;

                }

            }
  }


  public boolean hasNext() {
   return next != null;
  } /* hasNext */


  public E next() {
   E current = next.elem;

            if (next.right != null) {

                next = next.right;

                while (next.left != null) {

                    next = next.left;

                }

            } else {

                while (true) { //If you can, go up till you came from the left

                    if (next.parent == null) {

                        next = null;

                        break;

                    }

                    if (next.parent.left == next) {

                        next = next.parent;

                        break;

                    }

                    next = next.parent;

                }

            }

            return current;
  } /* next */


  public void remove() {
   // not implemented
  } /* remove */


 }
}
