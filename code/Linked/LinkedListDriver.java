import java.util.Scanner;

/**
 * Created by jon on 4/11/2016.
 */
public class LinkedListDriver {

    static Scanner kb = new Scanner(System.in);

    static IntLinkedList testLL = new IntLinkedList();

    public static void main(String[] args) {

        insertNodes();
        testNodes();
        removeNodes();
    }

    public static void insertNodes() {
        int count = 0;
        while (true) {
            System.out.println("please input several numbers to place in this list, type q to stop");
            String input = "";
            try {
                input = kb.nextLine();
                testLL.add(Integer.parseInt(input));
                count++;
            } catch (NumberFormatException e) {
                if (input.equals("q"))
                    break;
            }
        }

        System.out.printf("elements entered: %d\nelements in list: %d\n",count,testLL.size());
    }

    public static void testNodes() {
        System.out.println("HEAD value: " + testLL.getHead().getData());
        System.out.println("TAIL value: " + testLL.getTail().getData());
        System.out.println("MIDDLE value: "  + testLL.middle());
        System.out.println("RANDOM value: " + testLL.grab());

        System.out.println("checking values 1-10\n__________________________");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number of " + i + "'s in linked list: " + testLL.countOccurences(i));
        }
    }

    public static void removeNodes() {
        int size = testLL.size();
        System.out.println("removing one node");
        testLL.remove(testLL.getHead().getData());

        System.out.printf("size list should be: %d\n size list is %d\n", size, testLL.size());

        System.out.println("removing remaining nodes");

        while (testLL.size() > 0) {
            testLL.remove(testLL.getTail().getData());
        }

        System.out.printf("size list should be: 0\n size list is %d\n", testLL.size());
    }
}
