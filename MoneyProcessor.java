import java.io.*;
import java.util.*;

public class MoneyProcessor
{
    public static void main(String[] args) throws IOException
    {
         // Determine the length of array to be created.
        File file = new File("money.txt");
        Scanner input = new Scanner(file);

        int arrayLength = 0;

        while(input.hasNext())
        {
            input.nextLine();
            arrayLength++;
        }
        input.close();

        // Create an array and fill it with Dollar objects.
        Dollar[] dollarList = new Dollar[arrayLength];
        input = new Scanner(file);

        int denomination;
        String face;
        String serial;
        int year;

        String[] tokens;
        Dollar dollar;

        for (int i = 0; i < arrayLength; i++)
        {
            // Split a line of data from file into individual tokens.
            tokens = input.nextLine().split(",");
            denomination = Integer.parseInt(tokens[0]);
            face = tokens[1];
            serial = tokens[2];
            year = Integer.parseInt(tokens[3]);

            // Create Dollar object using tokens then add it to array.
            dollar = new Dollar(denomination, face, serial, year);
            dollarList[i] = dollar;
        }
        input.close();

        // Display results using methods.
        System.out.println("***** printBills() *****");
        printBills(dollarList);
        System.out.println("***** printOnlyDenominations() *****");
        printOnlyDenominations(dollarList);
        System.out.println("***** getTotalAmountInWallet() *****");
        System.out.println(getTotalAmountInWallet(dollarList));
    }

    // Takes an array of Dollar objects and invokes the showBill() method for each Dollar.
    public static void printBills(Dollar[] dollarList)
    {
        for (Dollar dollar : dollarList)
        {
            dollar.showBill();
        }
    }

    // Takes an array of Dollar objects and prints only the denominations.
    public static void printOnlyDenominations(Dollar[] dollarList)
    {
        for (Dollar dollar : dollarList)
        {
            System.out.print(dollar.getDenomination() + " ");
        }
        System.out.println();
    }

    // Takes an array of Dollar objects and calculates the total amount of money.
    public static int getTotalAmountInWallet(Dollar[] dollarList)
    {
        int total = 0;
        for (Dollar dollar : dollarList)
        {
            total += dollar.getDenomination();
        }
        return total;
    }
}
