import java.util.*;

/**
 * LoopsBasics.java
 *
 * Covers while loop fundamentals in Java.
 *
 * SECTION 1 — Core Concept Questions (Q1–Q7)
 * Guided examples with step-by-step inline explanation.
 *
 * SECTION 2 — Practice Questions (PQ1–PQ9)
 * Independent problems. Each one lists:
 * Concept → the core idea the question tests
 * Common mistake → the exact error beginners make and why it breaks things
 *
 * Run the file to work through all problems sequentially.
 * Author: Geetansh Bhandari
 */
public class LoopsBasics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ══════════════════════════════════════════════════════════════
        // SECTION 1 — CORE CONCEPT QUESTIONS
        // ══════════════════════════════════════════════════════════════

        // ──────────────────────────────────────────────────────────────
        // Q1: Print "Hello World" 6 times using a while loop
        // ──────────────────────────────────────────────────────────────
        // helloCount goes 0 → 5, so the loop body runs exactly 6 times.
        // The condition turns false the moment helloCount reaches 6.
        // Missing helloCount++ inside the body makes the condition permanently
        // true → infinite loop.
        int helloCount = 0;
        while (helloCount <= 5) {
            System.out.println("Hello World");
            helloCount++;
        }

        // ──────────────────────────────────────────────────────────────
        // Q2: Print numbers from 1 to 10
        // ──────────────────────────────────────────────────────────────
        // Three things every while loop needs:
        // • initialize the counter before the loop
        // • check the condition at the top of every iteration
        // • update (increment) the counter inside the body
        // This is the standard template for any counting loop.
        int seqNum = 1;
        while (seqNum <= 10) {
            System.out.print(seqNum + " ");
            seqNum++;
        }
        System.out.println();

        // ──────────────────────────────────────────────────────────────
        // Q3: Print numbers from 1 to N (user-supplied limit)
        // ──────────────────────────────────────────────────────────────
        // Same structure as Q2 but the upper bound is flexible.
        // The user decides the limit at runtime instead of hardcoding 10.
        System.out.print("Enter N to print numbers from 1 to N: ");
        int limitN = sc.nextInt();
        int rangeCounter = 1;
        while (rangeCounter <= limitN) {
            System.out.print(rangeCounter + " ");
            rangeCounter++;
        }
        System.out.println();

        // ──────────────────────────────────────────────────────────────
        // Q4: Sum of first N natural numbers (accumulator pattern)
        // ──────────────────────────────────────────────────────────────
        // runningSum must live OUTSIDE the loop.
        // Declaring it inside resets it to 0 on every iteration — the sum is lost.
        // The O(1) formula n*(n+1)/2 exists, but the loop version builds the
        // foundational "accumulator" mental model needed for harder problems.
        System.out.print("Enter N for sum of first N natural numbers: ");
        int sumLimitN = sc.nextInt();
        int accumCounter = 1;
        int runningSum = 0;
        while (accumCounter <= sumLimitN) {
            runningSum += accumCounter;
            accumCounter++;
        }
        System.out.println("Sum of first " + sumLimitN + " natural numbers: " + runningSum);

        // ──────────────────────────────────────────────────────────────
        // Q5: Print a 4×4 star pattern
        // ──────────────────────────────────────────────────────────────
        // patternRow goes 0 → 3; condition (< 4) gives exactly 4 iterations.
        // Hardcoding the row string is fine for a fixed 4×4 size.
        // Variable dimensions would need nested loops (covered separately).
        int patternRow = 0;
        while (patternRow < 4) {
            System.out.println("* * * *");
            patternRow++;
        }

        // ──────────────────────────────────────────────────────────────
        // Q6: Print the digits of a number in reverse order
        // ──────────────────────────────────────────────────────────────
        // n % 10 → extracts the last digit
        // n / 10 → removes that digit (shifts number one place right)
        // For 12345 this prints: 5 4 3 2 1
        // Forgetting the /= 10 means the same last digit prints forever.
        // This runs in O(log n) — iterations equal the number of digits.
        System.out.print("Enter a number to print its digits in reverse: ");
        int digitSource = sc.nextInt();
        while (digitSource > 0) {
            System.out.print((digitSource % 10) + " ");
            digitSource /= 10;
        }
        System.out.println();

        // ──────────────────────────────────────────────────────────────
        // Q7: Reverse a number and store the result
        // ──────────────────────────────────────────────────────────────
        // How reversedStore = (reversedStore * 10) + (copyForRev % 10) builds
        // the reversed number step by step:
        // copyForRev % 10 → pulls the last digit
        // reversedStore * 10 → shifts existing digits left to make room
        //
        // Trace for input 123:
        // start: reversedStore = 0
        // step 1: last digit 3 → reversedStore = (0 × 10) + 3 = 3
        // step 2: last digit 2 → reversedStore = (3 × 10) + 2 = 32
        // step 3: last digit 1 → reversedStore = (32 × 10) + 1 = 321 ✓
        //
        // Using only reversedStore = copyForRev % 10 (without × 10) overwrites
        // reversedStore every step and keeps only the very last digit — wrong.
        //
        // Edge case: input 100 → digits 0, 0, 1 → reversed int = 1 (not 001).
        // Integers cannot hold leading zeros; String handling covers that later.
        System.out.print("Enter a number to reverse and store: ");
        int copyForRev = sc.nextInt();
        int reversedStore = 0;
        while (copyForRev > 0) {
            reversedStore = (reversedStore * 10) + (copyForRev % 10);
            copyForRev /= 10;
        }
        System.out.println("Reversed number: " + reversedStore);

        // ══════════════════════════════════════════════════════════════
        // SECTION 2 — PRACTICE QUESTIONS
        // ══════════════════════════════════════════════════════════════

        // ──────────────────────────────────────────────────────────────
        // PQ1: Print a phrase exactly N times
        // ──────────────────────────────────────────────────────────────
        // Concept : Basic loop repetition — controlling exactly how many
        // times a block of code executes using a counter.
        // Common mistake: Forgetting phraseCounter++ inside the body. The
        // counter never changes, the condition stays true forever
        // → infinite loop.
        System.out.print("How many times should \"Keep Grinding\" print? ");
        int phraseLimit = sc.nextInt();
        int phraseCounter = 0;
        while (phraseCounter < phraseLimit) {
            System.out.println("Keep Grinding");
            phraseCounter++;
        }

        // ──────────────────────────────────────────────────────────────
        // PQ2: Print all even numbers from 2 to N
        // ──────────────────────────────────────────────────────────────
        // Concept : Step-based incrementing (+=2) is cleaner and twice as
        // fast as visiting every number and checking % 2 == 0.
        // Even numbers are uniformly spaced, so jump by 2.
        // Common mistake: Using evenCurrent++ instead of +=2 visits every number,
        // requiring an extra if-check and doubling iterations.
        System.out.print("Enter N to print even numbers from 2 to N: ");
        int evenUpperBound = sc.nextInt();
        int evenCurrent = 2;
        while (evenCurrent <= evenUpperBound) {
            System.out.print(evenCurrent + " ");
            evenCurrent += 2;
        }
        System.out.println();

        // ──────────────────────────────────────────────────────────────
        // PQ3: Print all odd numbers from 1 to N (brute-force approach)
        // ──────────────────────────────────────────────────────────────
        // Concept : Modulo operator (%) for parity check. Every integer is
        // visited but only odd ones are printed. This is the
        // brute-force approach; the optimized version starts at 1
        // and steps by 2 (same idea as PQ2 for evens).
        // Common mistake: Writing oddCurrent % 2 == 0 instead of != 0 — that
        // condition is true for even numbers, so you end up
        // printing evens instead of odds.
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

        // ──────────────────────────────────────────────────────────────
        // PQ4: Print the multiplication table of a number (1 to 10)
        // ──────────────────────────────────────────────────────────────
        // Concept : The loop variable itself acts as the multiplier.
        // tableMultiplier represents "times 1", "times 2", etc.
        // The pattern tableBase × tableMultiplier is a linear sequence.
        // Common mistake: Starting tableMultiplier at 0 → first line prints
        // tableBase × 0 = 0, making the table look wrong.
        // Tables conventionally start at ×1, so initialize at 1.
        System.out.print("Enter a number to print its multiplication table: ");
        int tableBase = sc.nextInt();
        int tableMultiplier = 1;
        while (tableMultiplier <= 10) {
            System.out.println(tableBase + " x " + tableMultiplier + " = " + (tableBase * tableMultiplier));
            tableMultiplier++;
        }

        // ──────────────────────────────────────────────────────────────
        // PQ5: Compute the factorial of N (N!)
        // ──────────────────────────────────────────────────────────────
        // Concept : Multiplicative accumulator. Unlike a sum accumulator
        // (which starts at 0, the additive identity), a product
        // accumulator MUST start at 1 (the multiplicative identity).
        // Uses long instead of int — 13! already overflows int.
        // Common mistake: Initializing factResult = 0. Any number multiplied by
        // 0 is 0, so the product stays 0 forever regardless of N.
        System.out.print("Enter N to compute N!: ");
        int factInput = sc.nextInt();
        int factCounter = 1;
        long factResult = 1;
        while (factCounter <= factInput) {
            factResult *= factCounter;
            factCounter++;
        }
        System.out.println(factInput + "! = " + factResult);

        // ──────────────────────────────────────────────────────────────
        // PQ6: Count the number of digits in a number
        // ──────────────────────────────────────────────────────────────
        // Concept : Each integer division by 10 strips one digit from the
        // right. Counting how many divisions it takes to reach 0
        // gives the total digit count. This is O(log n).
        // Common mistake: Not handling 0 as a special case. The loop condition
        // (digitCountCopy > 0) is immediately false for input 0,
        // giving a count of 0 — but 0 has exactly 1 digit.
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

        // ──────────────────────────────────────────────────────────────
        // PQ7: Sum of all digits of a number
        // ──────────────────────────────────────────────────────────────
        // Concept : Combine digit extraction (% 10) with an additive
        // accumulator. Each iteration: add the last digit to
        // digitTotal, then chop that digit off (/ 10).
        // Common mistake: Forgetting digitSumCopy /= 10 at the end of the loop
        // body. digitSumCopy never shrinks → same last digit is
        // added infinitely → infinite loop.
        System.out.print("Enter a number to find the sum of its digits: ");
        int digitSumInput = sc.nextInt();
        int digitSumCopy = digitSumInput;
        int digitTotal = 0;
        while (digitSumCopy > 0) {
            digitTotal += digitSumCopy % 10;
            digitSumCopy /= 10;
        }
        System.out.println("Sum of digits of " + digitSumInput + ": " + digitTotal);

        // ──────────────────────────────────────────────────────────────
        // PQ8: Check if a number is a palindrome
        // ──────────────────────────────────────────────────────────────
        // Concept : Apply the reverse-a-number technique (Q7) on a copy,
        // then compare the reversed value with the original.
        // A number is a palindrome when reversing it produces the
        // same value (e.g., 121, 1331, 12321).
        // Common mistake: Reversing the original variable directly. After the loop
        // the original is 0, so the comparison always says "not a
        // palindrome". Always work on a copy (palindromeCopy here)
        // and keep the original (palindromeInput) untouched.
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

        // ──────────────────────────────────────────────────────────────
        // PQ9: Sum of all even numbers from 1 to N
        // ──────────────────────────────────────────────────────────────
        // Concept : Combines two earlier ideas: step-based even iteration
        // from PQ2 with the additive accumulator from Q4.
        // evenSumTotal must be declared OUTSIDE the loop so it
        // persists across iterations.
        // Common mistake: Using evenSumCounter++ instead of +=2. This visits
        // every number, so you must add a % 2 check — twice as
        // many iterations for the same result. Step by 2 instead.
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
