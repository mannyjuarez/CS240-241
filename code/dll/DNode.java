/** Copyright 2014: smanna@csupomona.edu
 *
 * Node for doubly linked list
 **/

public class DNode {
  protected int element;
  protected DNode prev;
  protected DNode next;

  public DNode(int e){
    element = e;
    prev = null;
    next = null;
  }

  public DNode() {
    next = null;
    prev = null;
    element = -1;
  }
}
