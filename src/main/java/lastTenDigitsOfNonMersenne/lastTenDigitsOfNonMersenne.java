package lastTenDigitsOfNonMersenne;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class lastTenDigitsOfNonMersenne {

    static int[] lastDigitsOfBigInteger(BigInteger nonMarsenne, int lastDigitsNo) {

        int[] lastDigits = new int[lastDigitsNo];

        for (int digitIndex = lastDigitsNo - 1; digitIndex >= 0; digitIndex--) {

            lastDigits[digitIndex] =
                    nonMarsenne.mod(BigInteger.TEN)
                    .intValue();

            nonMarsenne = (
                    nonMarsenne.subtract(
                    BigInteger.valueOf(lastDigits[digitIndex])
                    ))
                    .divide(BigInteger.TEN);
        }
        return lastDigits;
    }

    public static void main(String[] args) {

        System.out.println("The last 10 digits of non-Marsenne prime number\n" +
                "28433 * 2^7830457 + 1 are:");

        BigInteger nonMarsenne =
                BigInteger.valueOf(28433)
                .multiply(
                BigInteger.valueOf(2).pow(7830457)
                )
                .add(BigInteger.ONE);

        IntStream.of(
                lastDigitsOfBigInteger(nonMarsenne,10)
                )
                .forEach(System.out::print);
    }
}
