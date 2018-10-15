/**
 * Created by jon on 4/4/2016.
 */
public interface IntArrayBagInterface {

    /*
        implement this interface in your subclass named IntArrayBag

        if you have the book and want some extra practice, try implementing the exceptions detailed

        the bag that stores the integers in your implementation needs to be an integer array

        you should have two constructors

        1.
            public IntArrayBag()
            -this constructor creates a new bag of capacity 10
        2.
            public IntArrayBag(int initialCapacity)
            -this constructor creates a new bag of capacity initialCapacity
     */

    /**
     * add a new element to the bag. If the element would increase the size of the bag beyond the capacity double
     * the capacity of the bag
     * @param a
     */
    void add(int a);

    /**
     * add the contents of another IntArrayBag to this bag. If the elements would increase the size of the bag beyond
     * the capacity double the capacity of the bag
     * @param arrayBag
     */
    //public void addAll(IntArrayBag addend) copy this, there's issues with exteding it

    /**
     * add a variable number of new elements to this bag.
     * @param elements
     */
    void addMany(int ... elements);

    /**
     * generate a deep copy of the bag, change the retutn type to IntArrayBag within your class
     * @return
     */
    IntArrayBagInterface clone();

    /**
     * count the number of occurences of the particular target within the bag
     * @param target
     * @return
     */
    int countOccurrences(int target);

    /**
     * changes the current capacity of the bag (remember that whenever you do this to copy and update the array)
     * @param minimumCapacity
     */
    void ensureCapacity(int minimumCapacity);

    /**
     * returns the current capacity of the bag
     * @return
     */
    int getCapacity();

    /**
     * removes one copy of the particular element from the bag.  returns false if one does not exist, true if successful
     * @param target
     * @return
     */
    boolean remove(int target);

    /**
     * returns the current size of the bag (# of elements)
     * @return
     */
    int size();

    /**
     * reduces the current capacity of the bag to the actual size (# of elements) of the bag
     */
    void trimToSize();

}
