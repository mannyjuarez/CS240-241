/** Copyright 2014: smanna@csupomona.edu
 * CS 240
 * Doubly linked list sample code 
 */

public class DLL {
  // fields
  private DNode head;
  private DNode tail;
  int size;// size of the linked list

  // constructor
  public DLL() {
    head = null;
    tail = null;
    size = 0;
  }

  // adding node at end 
  public void append(int data) {
    assert (data != -1);
    DNode node = new DNode(data);
    if (head == null) {
      head = node;
      tail = node;      
    } else {
      node.prev = tail;
      tail.next = node;
      tail = node;
    }
    ++size;
  }

  // adding node at front
  public void prepend(int data) {
    assert (data != -1);
    DNode node = new DNode(data);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }
    ++size;
  }

  // inserting node at a specific location
  public void insertAtPos(int pos, int data) {
    DNode node = new DNode(data);
    if (pos == 1) {
      prepend(data);
      return;
    }
    DNode curr = head;
    int i = 2;
    for (; i < pos; ++i) {
      curr = curr.next;
    }
    if (i == pos) {
      DNode temp = curr.next;
      curr.next = node;
      node.prev = curr;
      node.next = temp;
      temp.prev = node;
    }
    ++size;
  }

  // deleting node from a specific location
  public void deleteAtPos(int pos) {
    if (pos == 1) {
      if (size == 1) { 
        head = null;
        tail = null;
        size = 0;
        return;
      }
      head = head.next;
      head.prev = null;
      --size;
      return;
    }
    if (pos == size) {
      tail = tail.prev;
      tail.next = null;
      --size;
    }
    DNode curr = head.next;
    int i = 2;
    for (; i < size; ++i) {
      curr = curr.next;
    }
    if (i == pos) {
      DNode p = curr.prev;
      DNode n = curr.next;
      p.next = n;
      n.prev = p;
      --size;
    }
  }
  

  // getting size
  public int getSize() {
    return size;
  }
  // printing forward
  public void printForward() {
    if (head == null) {
      return;
    }
    for (DNode curr = head; curr != null; curr = curr.next) {
      System.out.print(curr.element + " ");
    }
    System.out.println();
  }

  // printing backward
  public void printBackward() {
    if (tail == null) {
      return;
    }
    for (DNode curr = tail; curr != null; curr = curr.prev) {
      System.out.print(curr.element + " ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    DLL first = new DLL();
    first.append(1);
    first.append(2);
    first.append(3);
    first.printForward();
    DLL second = new DLL();
    second.append(4);
    second.append(5);
    second.append(6);
    concatenate(first, second);
    first.printForward();
  }
  
  public static void concatenate(DLL first, DLL second)
  {
    DNode cursor = first.head;
    DNode secondhead = second.head;
    while(cursor.next != null)
    {
      cursor = cursor.next;
    }
    
    cursor.next = secondhead;
    secondhead.prev = cursor;
    
  }
  
}
