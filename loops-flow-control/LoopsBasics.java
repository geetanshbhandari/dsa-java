import java.util.*;

/*
 * LOOPS BASICS - KEY THINGS TO REMEMBER
 *
 * WHILE LOOP TEMPLATE (every loop needs all three):
 *   Initialize the counter before the loop, check the condition at the top,
 *   update the counter inside the body.
 *   Missing the update means the counter never changes, condition stays true forever,
 *   and you get an infinite loop.
 *
 * ACCUMULATOR PATTERN:
 *   Sum accumulator starts at 0 (additive identity).
 *   Product accumulator starts at 1 (multiplicative identity, used in factorial).
 *   Declare it OUTSIDE the loop. Declaring inside resets it every iteration.
 *
 * DIGIT TRICKS (runs in O(log n), once per digit):
 *   n % 10  extracts the last digit.
 *   n / 10  removes the last digit.
 *   Always work on a COPY of the number so you still have the original to compare.
 *   Forgetting the /= 10 inside the loop means the same digit repeats forever.
 *
 * STEP LOOPS (prefer stepping over checking):
 *   Evens: start at 2, step by +=2. Do not check % 2 == 0 on every number.
 *   Odds:  start at 1, step by +=2. Same idea.
 *   Using ++ and a modulo check is the brute force way, stepping is cleaner.
 *
 * WHILE(TRUE) + BREAK PATTERN:
 *   Use when you do not know upfront how many iterations the loop will run.
 *   Always take input INSIDE the loop, not outside.
 *   Input outside means the first value is never re-read on the next iteration.
 *
 * CONTINUE KEYWORD:
 *   Skips the rest of the current iteration and jumps to the next one.
 *   Does not exit the loop, just skips one step.
 *
 * BRUTE FORCE MISTAKES TO AVOID:
 *   Using ++ instead of +=2 for evens or odds (doubles iterations for no reason).
 *   Reversing the original number directly (original is gone, comparison is wrong).
 *   Initializing a product accumulator at 0 (anything times 0 stays 0 forever).
 *   Not handling 0 in digit count (the loop condition n > 0 skips 0 entirely).
 *
 * Author: Geetansh Bhandari
 */
public class LoopsBasics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Q1: Print "Hello World" 6 times
        // helloCount goes 0 to 5, loop runs exactly 6 times.
        // Missing helloCount++ makes it an infinite loop.
        int helloCount = 0;
        while (helloCount <= 5) {
            System.out.println("Hello World");
            helloCount++;
        }

        // Q2: Print numbers 1 to 10
        // Template: initialize, check, update. Every counting loop follows this.
        int seqNum = 1;
        while (seqNum <= 10) {
            System.out.print(seqNum + " ");
            seqNum++;
        }
        System.out.println();

        // Q3: Print numbers 1 to N (user decides the limit at runtime)
        System.out.print("Enter N to print numbers 1 to N: ");
        int limitN = sc.nextInt();
        int rangeCounter = 1;
        while (rangeCounter <= limitN) {
            System.out.print(rangeCounter + " ");
            rangeCounter++;
        }
        System.out.println();

        // Q4: Sum of first N natural numbers (accumulator pattern)
        // runningSum lives outside the loop so it is not reset each iteration.
        System.out.print("Enter N for sum of first N natural numbers: ");
        int sumLimitN = sc.nextInt();
        int accumCounter = 1;
        int runningSum = 0;
        while (accumCounter <= sumLimitN) {
            runningSum += accumCounter;
            accumCounter++;
        }
        System.out.println("Sum of first " + sumLimitN + " natural numbers: " + runningSum);

        // Q5: Print a 4x4 star pattern
        // patternRow goes 0 to 3, condition < 4 gives exactly 4 rows.
        int patternRow = 0;
        while (patternRow < 4) {
            System.out.println("* * * *");
            patternRow++;
        }

        // Q6: Print digits of a number in reverse (n%10 = last digit, n/10 = remove it)
        // For 12345 this prints: 5 4 3 2 1
        System.out.print("Enter a number to print its digits in reverse: ");
        int digitSource = sc.nextInt();
        while (digitSource > 0) {
            System.out.print((digitSource % 10) + " ");
            digitSource /= 10;
        }
        System.out.println();

        // Q7: Reverse a number and store it
        // reversed = (reversed * 10) + (n % 10) shifts digits left and appends the new
        // one.
        // Trace for 123: start 0, step 1 gives 3, step 2 gives 32, step 3 gives 321.
        // Without the *10 you just overwrite reversed with the last digit every time.
        System.out.print("Enter a number to reverse and store: ");
        int copyForRev = sc.nextInt();
        int reversedStore = 0;
        while (copyForRev > 0) {
            reversedStore = (reversedStore * 10) + (copyForRev % 10);
            copyForRev /= 10;
        }
        System.out.println("Reversed number: " + reversedStore);

        // Q8: while(true) + break pattern
        // Keep taking numbers until the user enters a multiple of 10.
        // Input is inside the loop so every value including the first one gets checked.
        System.out.println("Enter numbers. Loop stops when you enter a multiple of 10.");
        while (true) {
            System.out.print("Enter a number: ");
            int inputNum = sc.nextInt();
            if (inputNum % 10 == 0) {
                System.out.println("Multiple of 10 found: " + inputNum + ". Stopping.");
                break;
            }
        }

        // Q9: continue keyword
        // Skip multiples of 10 and print everything else. Enter -1 to quit.
        // continue jumps back to the loop condition without running the rest of the
        // body.
        System.out.println("Enter numbers (-1 to quit). Multiples of 10 will be skipped.");
        while (true) {
            System.out.print("Enter a number: ");
            int enteredNum = sc.nextInt();
            if (enteredNum == -1)
                break;
            if (enteredNum % 10 == 0)
                continue;
            System.out.println(enteredNum);
        }

        // PRACTICE QUESTIONS

        // PQ1: Print a phrase N times
        // Concept: basic counter loop, control how many times a block runs.
        // Mistake: forgetting phraseCounter++ causes an infinite loop.
        System.out.print("How many times should \"Keep Grinding\" print? ");
        int phraseLimit = sc.nextInt();
        int phraseCounter = 0;
        while (phraseCounter < phraseLimit) {
            System.out.println("Keep Grinding");
            phraseCounter++;
        }

        // PQ2: Print all even numbers from 2 to N
        // Concept: step by 2 so you only visit even numbers, no modulo check needed.
        // Mistake: using ++ instead of +=2 doubles the iterations.
        System.out.print("Enter N to print even numbers from 2 to N: ");
        int evenUpperBound = sc.nextInt();
        int evenCurrent = 2;
        while (evenCurrent <= evenUpperBound) {
            System.out.print(evenCurrent + " ");
            evenCurrent += 2;
        }
        System.out.println();

        // PQ3: Print all odd numbers from 1 to N (brute force with modulo check)
        // Concept: visit every number and use % to filter. Optimized version uses +=2.
        // Mistake: writing %2 == 0 instead of != 0 prints evens instead of odds.
        System.out.print("Enter N to print odd numbers from 1 to N: ");
        int oddUpperBound = sc.nextInt();
        int oddCurrent = 1;
        while (oddCurrent <= oddUpperBound) {
            if (oddCurrent % 2 != 0) {
                System.out.print(oddCurrent + " ");
            }
            oddCurrent++;
        }
        System.out.println();

        // PQ4: Multiplication table of a number (1 to 10)
        // Concept: loop variable acts as the multiplier, base stays fixed.
        // Mistake: starting tableMultiplier at 0 prints base x 0 = 0 as the first line.
        System.out.print("Enter a number to print its multiplication table: ");
        int tableBase = sc.nextInt();
        int tableMultiplier = 1;
        while (tableMultiplier <= 10) {
            System.out.println(tableBase + " x " + tableMultiplier + " = " + (tableBase * tableMultiplier));
            tableMultiplier++;
        }

        // PQ5: Factorial of N
        // Concept: product accumulator must start at 1, not 0 (0 x anything = 0
        // forever).
        // long is used because 13! already overflows int.
        System.out.print("Enter N to compute N!: ");
        int factInput = sc.nextInt();
        int factCounter = 1;
        long factResult = 1;
        while (factCounter <= factInput) {
            factResult *= factCounter;
            factCounter++;
        }
        System.out.println(factInput + "! = " + factResult);

        // PQ6: Count the number of digits in a number
        // Concept: each /10 removes one digit, count how many times you can divide.
        // Mistake: input 0 skips the loop entirely giving 0 digits, but 0 has 1 digit.
        System.out.print("Enter a number to count its digits: ");
        int digitCountInput = sc.nextInt();
        int digitCounter = 0;
        int digitCountCopy = digitCountInput;
        if (digitCountCopy == 0) {
            digitCounter = 1;
        } else {
            while (digitCountCopy > 0) {
                digitCountCopy /= 10;
                digitCounter++;
            }
        }
        System.out.println("Digit count of " + digitCountInput + ": " + digitCounter);

        // PQ7: Sum of all digits of a number
        // Concept: %10 extracts the last digit, add it to the total, /10 removes it.
        // Mistake: forgetting /10 means the same last digit adds forever (infinite
        // loop).
        System.out.print("Enter a number to find the sum of its digits: ");
        int digitSumInput = sc.nextInt();
        int digitSumCopy = digitSumInput;
        int digitTotal = 0;
        while (digitSumCopy > 0) {
            digitTotal += digitSumCopy % 10;
            digitSumCopy /= 10;
        }
        System.out.println("Sum of digits of " + digitSumInput + ": " + digitTotal);

        // PQ8: Check if a number is a palindrome
        // Concept: reverse the number using a COPY, then compare the reversed copy with
        // original.
        // Mistake: reversing the original variable directly destroys it, comparison is
        // always wrong.
        System.out.print("Enter a number to check if it is a palindrome: ");
        int palindromeInput = sc.nextInt();
        int palindromeCopy = palindromeInput;
        int palindromeBuilt = 0;
        while (palindromeCopy > 0) {
            int lastExtracted = palindromeCopy % 10;
            palindromeBuilt = (palindromeBuilt * 10) + lastExtracted;
            palindromeCopy /= 10;
        }
        if (palindromeBuilt == palindromeInput) {
            System.out.println(palindromeInput + " is a palindrome.");
        } else {
            System.out.println(palindromeInput + " is NOT a palindrome.");
        }

        // PQ9: Sum of all even numbers from 1 to N
        // Concept: step by 2 (from PQ2) combined with a sum accumulator (from Q4).
        // Mistake: using ++ instead of +=2 adds odd numbers too and doubles iterations.
        System.out.print("Enter N to find the sum of all even numbers from 1 to N: ");
        int evenSumLimit = sc.nextInt();
        int evenSumCounter = 2;
        int evenSumTotal = 0;
        while (evenSumCounter <= evenSumLimit) {
            evenSumTotal += evenSumCounter;
            evenSumCounter += 2;
        }
        System.out.println("Sum of even numbers from 1 to " + evenSumLimit + ": " + evenSumTotal);

        sc.close();
    }
}
