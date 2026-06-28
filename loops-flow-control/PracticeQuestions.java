import java.util.*;

/*
 * PRIME NUMBERS - KEY THINGS TO REMEMBER
 *
 * WHAT IS A PRIME NUMBER:
 *   A number divisible only by 1 and itself.
 *   Examples of primes:     2, 3, 5, 7, 11, 13, 97, 107
 *   Examples of non-primes: 4 (2x2), 6 (2x3), 9 (3x3), 15 (3x5)
 *   Special case: 0 and 1 are NOT prime.
 *
 * BOOLEAN FLAG PATTERN:
 *   Assume the number is prime (flag = true) before the loop.
 *   If any divisor is found inside the loop, flip to false and break immediately.
 *   After the loop, check the flag for the final answer.
 *   Think of it as: innocent until proven guilty.
 *
 * BRUTE FORCE - O(n):
 *   Check every number from 2 to n-1.
 *   Works but slow for large numbers.
 *   For n = 1,000,000 you unnecessarily check 999,998 numbers.
 *
 * OPTIMAL - O(sqrt n):
 *   Factors always come in pairs (a x b = n).
 *   The smaller factor in every pair is always less than or equal to sqrt(n).
 *   So if no divisor is found up to sqrt(n), there cannot be one after it.
 *   For n = 1,000,000: brute force checks 999,998 numbers, optimal checks only 1,000.
 *
 * AVOID: checking i < n when you can check i <= Math.sqrt(n).
 *
 * Author: Geetansh Bhandari
 */
public class PracticeQuestions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number to check if it is prime: ");
        int numberToCheck = sc.nextInt();

        // Brute force - O(n)
        // Checks every number from 2 to numberToCheck - 1.
        // Mistake: people forget to handle numberToCheck <= 1 separately,
        // so 0 and 1 incorrectly get flagged as prime.
        boolean isPrimeBrute = true;
        if (numberToCheck <= 1) {
            isPrimeBrute = false;
        }
        int bruteChecker = 2;
        while (bruteChecker < numberToCheck) {
            if (numberToCheck % bruteChecker == 0) {
                isPrimeBrute = false;
                break;
            }
            bruteChecker++;
        }
        if (isPrimeBrute) {
            System.out.println("[Brute Force O(n)] " + numberToCheck + " is prime.");
        } else {
            System.out.println("[Brute Force O(n)] " + numberToCheck + " is NOT prime.");
        }

        // Optimal - O(sqrt n) using Math.sqrt
        // Only checks up to sqrt(numberToCheck) because factors come in pairs
        // and the smaller factor in every pair is always <= sqrt(n).
        // Mistake: checking i < n instead of i <= Math.sqrt(n) is just the brute force
        // in disguise. The massive win comes from switching to the sqrt condition.
        boolean isPrimeOptimal = true;
        if (numberToCheck <= 1) {
            isPrimeOptimal = false;
        }
        int optimalChecker = 2;
        while (optimalChecker <= Math.sqrt(numberToCheck)) {
            if (numberToCheck % optimalChecker == 0) {
                isPrimeOptimal = false;
                break;
            }
            optimalChecker++;
        }
        if (isPrimeOptimal) {
            System.out.println("[Optimal O(sqrt n)] " + numberToCheck + " is prime.");
        } else {
            System.out.println("[Optimal O(sqrt n)] " + numberToCheck + " is NOT prime.");
        }

        sc.close();
    }
}
