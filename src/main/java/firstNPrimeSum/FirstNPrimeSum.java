package firstNPrimeSum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstNPrimeSum {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static boolean isPrime(int number) {
        if (number > 1) {
            int half = number / 2, div = 0;
            for (int i = 2; i <= half; i++) {
                if (number % i == 0) {
                    div = 1;
                    break;
                }
            }
            return div == 0;
        }
        return false;
    }

    public static long firstNPrimeSum(int count) {
        long sum = 0;
        for (int number = 2; count > 0; number++) {
            if (isPrime(number)) {
                count--;
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print("Hello! I calculate the sum of the first n prime numbers.\n" +
                "Please enter an integer between one and a million: ");
        try {
            int count = SCANNER.nextInt();
            if (count < 0 || count > 1000000) {
                System.out.println("Your input cannot be negative or greater than one million. Bye!");
            } else {
                System.out.println("Calculating. Please wait...");
                System.out.print("The sum of the first " + count +
                        " prime numbers is " + firstNPrimeSum(count) + ". Goodbye!");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Your input must be integer. Bye!");
        }
        SCANNER.close();
    }
}
