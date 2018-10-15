/** Copyright 2014: smanna@csupomona.edu
 * CS 240
 * Example of circular linked list 
 */

public class CLL {
  
  // fileds
  private Node head;

  // constructor
  public CLL() {
    // defining head
    head = null;
  }

  // printing the elements of the linked list
  public void print() {
    if (head == null) {
      return;
    }
    Node curr = head;
    for (; curr.next != head; curr = curr.next) { // note the difference here
      System.out.print(curr.element + " ");
    }
    System.out.println(curr.element);
  }

 // inserting anywhere
 public void insertAnywhere(int data){
   assert (data != -1);
   Node node = new Node(data);
   if (head == null) {
     head = node;
     head.next = head;
     return;
   }
   if (head.next == head) {
     // Single element
     head.next = node;
     node.next = head;
     return;
   }
   // More than 2 elements, insert after head
   node.next = head.next;
   head.next = node;
 }

 // inserting a node at front 
 public void insertNodeAtFront(int data){
   assert (data != -1);
   if (head == null) {
     insertAnywhere(data);
     return;
   }
   Node curr = head;
   for (; curr.next != head; curr = curr.next) {
   }
   // Now we are at the last node.
   Node node = new Node(data);
   node.next = head;
   curr.next = node;
   head = node;
 }

 // inserting after
 public void insertAfterFirstOccurance(int elem, int data){
   Node node = new Node(data);
   for (Node curr = head; curr != null; curr = curr.next) {
    if (curr.element == elem) {
      node.next = curr.next;
      curr.next = node;
      break;
    }
   }
 }

 // finding a node
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
 public void deleteNextNode(Node node) {
   if (node == null || head == null) {
     return;
   }
   if (node.next == node) {
     // Single element
     head = null;
     return;
   }
   node.next = node.next.next;
 }

 // deleting a node
 public void deleteNode(Node node) {
   if (node == null || head == null) {
     return;
   }
   Node curr = head;
   for (; curr.next != node; curr = curr.next) {
   }
   deleteNextNode(curr);
 }

 // deleting a node from a specific position
 public boolean deleteAtPos(int pos) {
   if (head == null) {
     return false;
   }
   if (pos == 1) {
     deleteNode(head);
     return true;
   }
   int i = 2;
   for (Node curr = head; curr.next != head; curr = curr.next) {
     if (i == pos) {
       deleteNextNode(curr);
       return true;
     }
     ++i;
   }
   return false;
 }

 // main method
  public static void main(String[] args) {
    CLL numerals = new CLL();
    numerals.insertAnywhere(10);
    numerals.print();
    numerals.insertAnywhere(20);
    numerals.print();
    numerals.insertAnywhere(30);
    numerals.print();
    numerals.insertNodeAtFront(0);
    numerals.print();
    numerals.insertAfterFirstOccurance(10, 12);
    numerals.print();
    System.out.println("Next to 12 is: " + numerals.findNode(12).next.element);
    numerals.deleteNode(numerals.findNode(10));
    numerals.print();
    numerals.deleteAtPos(4);
    numerals.print();
  }

}



