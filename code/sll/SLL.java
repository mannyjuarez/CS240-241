/** Copyright 2014: smanna@csupomona.edu
 * CS 240
 * Singly Linked list example
 */

public class SLL {
  // fields
  private Node head;

  // constructor
  public SLL() {
    // defining head
    head = null;
  }

  // printing the elements of the linked list
  public void print() {
    if (head == null) {
      return;
    }
    for (Node curr = head; curr != null; curr = curr.next) {
      System.out.print(curr.element + " ");
    }
    System.out.println();
  }

 // inserting a node at front 
 public void insertNodeAtFront(int data){
   Node node = new Node(data);
   node.next = head;
   head = node;
 }

 // inserting after
 public void insertAfter(int elem, int data){
   Node node = new Node(data);
   for (Node curr = head; curr != null; curr = curr.next) {
    if (curr.element == elem) {
      node.next = curr.next;
      curr.next = node;
      break;
    }
   }
 }

 // finding a specific node
 public Node findNode(int data) {
   if (head == null) {
     return null;
   }
   for (Node curr = head; curr != null; curr = curr.next) {
     if (curr.element == data) {
       return curr;
     }
   }
   return null;
 }

 // deleting a node
 public void deleteNode(Node node) {
   Node succ = node.next;
   if (node == head) {
     head = succ;
   } else {
     Node pred = head;
     while (pred.next != node) {
       pred = pred.next;
     }
     pred.next = succ;
   }
 }

 // deleting node from a position
 public boolean deleteAtPos(int pos) {
   int i = 1;
   for (Node curr = head; curr != null; curr = curr.next) {
     if (i == pos) {
       deleteNode(curr);
       return true;
     }
     ++i;
   }
   return false;
 }

 // main method
  public static void main(String[] args) {
    SLL numerals = new SLL();
    // inserting node
    numerals.insertNodeAtFront(10);
    numerals.insertNodeAtFront(30);
    numerals.insertAfter(10, 20);
    // printing the list
    System.out.println("List is now: ");
    numerals.print();
    System.out.println();
    // deleting a node by looking for an element
    numerals.deleteNode(numerals.findNode(20));
    // printing the list after deletion
    System.out.println("List is now: ");
    numerals.print();
  }

}



