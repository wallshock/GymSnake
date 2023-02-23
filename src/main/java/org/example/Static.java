package org.example;

import java.util.Random;

import static java.lang.Math.abs;

public class Static {
    public static boolean callFunction() {
        Random random = new Random();
        int chance = random.nextInt(100); // Generate a random number between 0 and 99
        return chance < 1;
    }
    public static long roundUp(long num, long divisor) {
        int sign = (num > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);
        return sign * (abs(num) + abs(divisor) - 1) / abs(divisor);
    }

    public static int modulo(int dividend, int divisor) {
        int result = dividend % divisor;
        if (result < 0) {
            result += divisor;
        }
        return result;
    }
}
