package firstNPrimeSum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstNPrimeSum {

    private static final Scanner SCANNER = new Scanner(System.in);

    private boolean isPrime(int number) {
        if (number > 1) {
            int half = number / 2;
            boolean div = false;
            for (int i = 2; i <= half; i++) {
                if (number % i == 0) {
                    div = true;
                    break;
                }
            }
            return !div;
        }
        return false;
    }

    private long firstNPrimeSum(int primeCount) {
        long sum = 0;
        if (primeCount > 0) {
            sum = 2;
            for (int number = 3; primeCount > 1; number += 2) {
                if (isPrime(number)) {
                    primeCount--;
                    sum += number;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FirstNPrimeSum primeCalculator = new FirstNPrimeSum();

        System.out.print("Hello! I calculate the sum of the first n prime numbers.\n" +
                "Please enter an integer between one and a million: ");

        try {
            int primeCount = SCANNER.nextInt();
            if (primeCount < 0 || primeCount > 1000000) {
                System.out.println("Your input cannot be negative or greater than one million. Bye!");
            } else {
                System.out.println("Calculating. Please wait...");
                System.out.print("The sum of the first " + primeCount +
                        " prime numbers is " + primeCalculator.firstNPrimeSum(primeCount) + ". Goodbye!");
            }
        } catch (InputMismatchException exception) {
            System.out.println("Your input must be integer. Bye!");
        }
        SCANNER.close();
    }
}
