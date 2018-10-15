 /**
 * Emanuel Juarez
 * CS 240.01
 * Programming Assignment 1
 * 04/19/16
 * COPYRIGHT: smanna@cpp.edu
 * CS 240 Spring 2016
 * Programming Assignment 1
 *
 * STUDENTS SHOULD COMPLETE THIS CODE.
 * You will upload this code to Blackboard.
 *
 * Feel free to include your own utility private fields and methods.
 * But please make sure you do not change the signature
 * of the public methods provided. If you do so, your code
 * cannot be run automatically, and you will not be graded.
 *
 * If you do not write enough comments, at least two points
 * will be deducted from your assignment. Also make sure you
 * follow the coding conventions.
 *
 * Make sure you check all the boundary conditions while implementing
 * your code here.
 *
 **/
public class LinkedList
{
  // head of the linked list
  private Node head;

  // constructor sets the head to null
  public LinkedList()
  {
    head = null;
  }

  //adds element to end of the list
  //if head is null then the node is the head
  //otherwise it traverses to the end of the list and then adds the Node
  public void append(int elem)
  {
    if (head == null)
    {
      Node node = new Node(elem);
      head = node;
    }
    else
    {
      Node current = head;
      while (current.next != null)
      {
        current = current.next;
      }
      current.next = new Node(elem);
    }
  }

  //straightforward, just set node.next to head and head to node
  public void prepend(int elem)
  {
    // TODO (student)
    Node node = new Node(elem);
    node.next = head;
    head = node;
  }

  // this one I had trouble with. I tried doing node.next = curr.next.next
  // then curr.next = node but realized this didnt work. Setting a temp node
  // simplifies this.
  public void insert(int index, int elem)
  {
    Node node = new Node(elem);
    Node curr = head;
    if (index == 0)
    {
      prepend(elem);
    }
    else
    {
      for (int i = 0; i < index - 1; i++)
      {
        curr = curr.next;
      }
      Node temp = curr.next;
      curr.next = node;
      node.next = temp;
    }
  }
  // if index is 0 then it deletes the head
  // otherwise you traverse the list until you reach 1 before index
  // then you set curr.next to curr.next.next and garbage collection will deal with the other node
  public void deleteElemAt(int i)
  {
    if (i == 0)
    {
      head = head.next;
    }
    else
    {
      Node current = head;
      for (int a = 0; a < i - 1; a++)
      {
        current = current.next;
      }
      current.next = current.next.next;
    }
  }

  // traverse the list and check if the data for that node equals the elem given
  // once found it will return the index, otherwise it returns -1
  public int findElem(int elem)
  {
    int index = 0;
    Node current = head;
    while (current != null)
    {
      if (current.data == elem)
      {
        return index;
      }
      index++;
      current = current.next;
    }
    return -1;
  }

  // traverse until you reach the given index
  // return the data at that Node
  // if there is no node, return -1
  public int readElemAt(int i)
  {
    Node current = head;
    for (int a = 0; a < i; a++)
    {
      current = current.next;
    }
    if (current == null)
    {
      return -1;
    }
    else
      return current.data;
  }

  // I realized if this wasn't correct the run program would give a terrible negative score.
  // If the list is empty it returns a blank string
  // otherwise it traverses through the loop and adds the data and a space to the string
  public String toString() {
    String result = "";
    Node current = head;
    if (current == null)
      return result;
    else {
      while (current != null)
      {
        result += current.data + " ";
        current = current.next;
      }
      return result;
    }
  }


  // Defining node here
  // begin: node class
  //  WARNING: DO NOT MAKE ANY CHANGES TO THE NODE CLASS
  public class Node {
    private int data;
    private Node next;


    //for elements that are at the tail
    public Node(int data) {
      this.data=data;
      next=null;
    }

    //for everything else
    public Node(int data, Node next) {
      this.data=data;
      this.next=next;
    }

    public int getData() {
      return data;
    }
  } // end: node class
}
