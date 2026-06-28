import java.util.*;

/*
 * FOR LOOPS AND PRACTICE - KEY THINGS TO REMEMBER
 *
 * FOR LOOP EXECUTION ORDER (this is where most people go wrong):
 *   for (initialization; condition; update) { body }
 *   initialization runs ONCE at the very start, never again.
 *   After that the order is always: condition → body → update → repeat.
 *   The update runs AFTER the body, not before it.
 *
 * TRICKY CASE - manual increment inside body AND i++ in the update:
 *   Both increments fire on every single iteration.
 *   Trace it manually step by step, never assume it works like a normal loop.
 *   for (int i = 0; i < 5; i++) { i += 2; }
 *     i=0: body runs → i+=2 makes it 2 → update i++ makes it 3 → next check
 *     i=3: body runs → i+=2 makes it 5 → update i++ makes it 6 → stops
 *   Loop ran twice even though the condition limit was 5.
 *
 * FOR vs WHILE - when to use which:
 *   Use a for loop when you know the count upfront (N iterations, 1 to 10, etc.)
 *   Use a while loop when you do not know how many times the loop will run.
 *
 * EVEN/ODD SPLIT PATTERN:
 *   Two accumulators, one loop. Use % 2 to route each number to the right total.
 *   Both accumulators must live outside the loop or they reset every iteration.
 *
 * BRUTE FORCE MISTAKES TO AVOID:
 *   Forgetting that the update runs after the body leads to wrong manual traces.
 *   Initializing a product accumulator at 0 instead of 1 (result is always 0).
 *   Mixing up == 0 and != 0 in even/odd checks (wrong group gets accumulated).
 *   Starting a multiplication table multiplier at 0 (first line is always 0).
 *
 * Author: Geetansh Bhandari
 */
public class AssignmentQuestions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Q1: For loop with a manual increment inside the body
        // Concept: the update (i++) fires after the body, so both i+=2 and i++ apply
        // every iteration.
        // Mistake: assuming only one increment happens per iteration leads to a wrong
        // count.
        // This loop prints "Hello" exactly 2 times, not 5. Trace: i=0 runs, becomes 3.
        // i=3 runs, becomes 6. Stops.
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            i += 2;
        }

        // Q2: Enter N numbers, find the sum of the even ones and the sum of the odd
        // ones
        // Concept: two accumulators, one loop. Check % 2 to decide which accumulator
        // gets the number.
        // Mistake: writing % 2 == 0 for the odd check instead of != 0 accumulates the
        // wrong group.
        System.out.print("How many numbers would you like to enter? ");
        int inputCount = sc.nextInt();
        int evenTotal = 0;
        int oddTotal = 0;
        for (int round = 1; round <= inputCount; round++) {
            System.out.print("Enter number " + round + ": ");
            int currentNum = sc.nextInt();
            if (currentNum % 2 == 0) {
                evenTotal += currentNum;
            } else {
                oddTotal += currentNum;
            }
        }
        System.out.println("Even sum: " + evenTotal);
        System.out.println("Odd sum: " + oddTotal);

        // Q3: Factorial of N using a for loop
        // Concept: product accumulator starts at 1, not 0. For loop is cleaner when
        // count is known.
        // Mistake: starting factResult at 0 means the result is always 0 (0 times
        // anything is 0).
        // long is used because 13! already overflows int.
        System.out.print("Enter N to compute N!: ");
        int factInput = sc.nextInt();
        long factResult = 1;
        for (int step = 1; step <= factInput; step++) {
            factResult *= step;
        }
        System.out.println(factInput + "! = " + factResult);

        // Q4: Print the multiplication table of a number from 1 to 10
        // Concept: the loop variable acts as the multiplier, the base number stays
        // fixed throughout.
        // Mistake: starting the multiplier at 0 prints base x 0 = 0 as the first line.
        System.out.print("Enter a number to print its multiplication table: ");
        int tableBase = sc.nextInt();
        for (int multiplier = 1; multiplier <= 10; multiplier++) {
            System.out.println(tableBase + " x " + multiplier + " = " + (tableBase * multiplier));
        }

        sc.close();
    }
}
