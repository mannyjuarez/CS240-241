/** Copyright 2014: smanna@csupomona.edu
 * CS 240
 * Node of Singly linked list
*/

public class Node {
  protected int element;
  protected Node next;

  public Node(int elem) {
    element = elem;
    next = null;
  }

  public Node() {
    element = -1;
    next = null;
  }
}
