
/**
 * Created by jon on 4/11/2016.
 */
public interface LinkedListInterface {

    /*
        implement this interface in your subclass named IntLinkedList

        your linked list must be made up of the included IntNodes, please do not edit the IntNode class, use the
        methods provided within to construct and modify your linked list

        you should have one constructor in your IntLinkedList

        1.
            public IntLinkedList()
            -Initialize an empty linked list


        some hints:
        - remember the key features of a linked list, it is an abstraction of singular nodes that point to the next node
        in the list

        - nodes which have nothing following them should point to null

        - you should always keep a reference to the node at the head
     */



    /**
     * appends a new IntNode to the linked list with the data contained in the element variable
     * @param element
     */
    void add(int element);

    /**
     * appends an existing linked list to the current linked list
     * @param list
     */
    void addAll(LinkedListInterface list);

    /**
     * appends several new IntNodes to the linked list with the data contained in elements
     * @param elements
     */
    void addMany(int ... elements);

    /**
     * counts the number of IntNodes in the linked list with the value target
     * @param target
     * @return
     */
    int countOccurences(int target);

    /**
     * grabs a random node from the linked list and returns it's value
     * @return
     */
    int grab();

    /**
     * returns the element in the middle of the list (in the case of an even sized list use either middle element
     * @return
     */
    int middle();

    /**
     * removes one IntNode with the given value from the linked list
     * @param target
     * @return
     */
    boolean remove(int target);

    /**
     * returns the number of IntNodes in the linked list
     * @return
     */
    int size();

    /**
     * returns the first element from the linked list
     * @return
     */
    IntNode getHead();

    /**
     * returns the last element from the linked list
     * @return
     */
    IntNode getTail();

}
