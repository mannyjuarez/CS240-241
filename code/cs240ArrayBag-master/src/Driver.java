import java.util.Scanner;

/**
 * Created by jon on 4/4/2016.
 */
public class Driver {

    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        IntArrayBag ages = new IntArrayBag();
        getAges(ages);
        checkAges(ages);
    }

    public static void getAges(IntArrayBag ages) {
        int userInput;

        System.out.println("type the ages of your family members.");
        System.out.println("type a negative number at the end and press return");

        userInput = stdin.nextInt();
        while (userInput >= 0)
        {
            ages.add(userInput);
            userInput = stdin.nextInt();
        }
    }

    public static void checkAges(IntArrayBag ages) {
        int userInput;

        System.out.println("Type those ages in again.");
        System.out.println("Press return after each age.");

        while (ages.size() > 0)
        {
            System.out.print("next age: ");
            userInput = stdin.nextInt();

            if (ages.countOccurrences(userInput) == 0)
            {
                System.out.println("No, that age does not occur.");
            }
            else
            {
                System.out.println("removing that age");
                ages.remove(userInput);
            }
        }
    }
}
