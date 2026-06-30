import java.util.*;

public class PatternsPart1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
         * VARIABLE SCOPE IN JAVA — NEVER FORGET THIS
         * ─────────────────────────────────────────────────────
         * Scope = where a variable is accessible in your code.
         *
         * RULE:
         * A variable only exists within the block {} it was declared in.
         * Once that block ends, the variable is GONE.
         *
         * INSIDE LOOP DECLARATION (limited scope):
         * for(int i = 0; i <= 5; i++){
         * System.out.println(i); ✅ works fine inside
         * }
         * System.out.println(i); ❌ ERROR — i doesn't exist here anymore
         *
         * OUTSIDE LOOP DECLARATION (wider scope):
         * int i = 0; ← declared outside
         * for(i = 0; i <= 5; i++){
         * System.out.println(i); ✅ works inside
         * }
         * System.out.println(i); ✅ works outside too
         *
         * SIMPLE RULE TO REMEMBER:
         * Need the variable ONLY inside the loop → declare inside ✅
         * Need the variable OUTSIDE the loop too → declare outside ✅
         *
         * This applies to ALL blocks in Java:
         * if blocks, while blocks, for blocks, method blocks — same rule everywhere
         * ─────────────────────────────────────────────────────
         */
        // ----------------------------------------------------------------------------------------------------
        // normal star pattern
        /*
         * STAR PATTERN WITH USER INPUT
         * went beyond what teacher asked - added input validation and made size dynamic
         * instead of just hardcoding a fixed pattern
         *
         * MISTAKE I MADE FIRST TIME:
         * had my pattern loops INSIDE the while(true) validation loop
         * the break statement was exiting before my pattern code even got a chance to
         * run
         * fix was simple - just move the pattern loops OUTSIDE the validation loop
         * lesson learned - always check where your brackets actually close before
         * blaming the logic, sometimes its just a structure problem not a logic problem
         *
         * HOW THE NESTED LOOP ACTUALLY WORKS (traced this manually for n=3):
         * outer loop = controls how many ROWS we print
         * inner loop = controls how many STARS go in that specific row
         *
         * the part that genuinely surprised me - every single time the outer loop
         * increments and goes back to start the inner loop again, the inner loop
         * counter resets back to 1. it does not remember where it left off last time.
         * the inner loop basically gets destroyed once its condition fails, and gets
         * rebuilt fresh from 1 the next time the outer loop calls it
         *
         * row 1: inner loop runs once (1<=1) prints 1 star, then destroyed
         * row 2: inner loop starts fresh from 1 again, runs twice (1<=2, 2<=2) prints 2
         * stars, then destroyed
         * row 3: inner loop starts fresh from 1 again, runs three times, prints 3
         * stars, then destroyed
         *
         * this reset behaviour is the entire reason nested loops can build patterns -
         * the inner loop is basically reusable code that runs fresh every single
         * time the outer loop calls it
         */

        System.out.print("How many lines would you like to have in your star pattern: ");

        int totalLines;
        while (true) {
            totalLines = sc.nextInt();
            if (totalLines <= 0) {
                System.out.print("Kindly enter a valid number: ");
            } else {
                break;
            }
        }

        for (int noOfLines = 1; noOfLines <= totalLines; noOfLines++) {
            for (int noOfStars = 1; noOfStars <= noOfLines; noOfStars++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /*
         * INVERTED STAR PATTERN — WHY THE REDUNDANT CONDITION WASN'T NEEDED
         * ─────────────────────────────────────────────────────
         * Original attempt had:
         * patternLines <= totalLinesNumber && patternLines > 0
         * starsNumber <= patternLines && starsNumber > 0
         *
         * Realized the <= check was pointless. Here's why.
         *
         * OUTER LOOP REASONING:
         * patternLines STARTS at totalLinesNumber (say 5) and only ever decreases.
         * So patternLines <= totalLinesNumber will ALWAYS be true, every single time,
         * because the value can only go down from 5, never up past it.
         * That check is doing nothing — it can never fail.
         * The only check that actually controls the loop is patternLines > 0.
         *
         * INNER LOOP — SAME LOGIC:
         * starsNumber is initialized AT patternLines, not at 1.
         * So starsNumber <= patternLines is true on the very first check by
         * definition, since they start equal. As starsNumber decreases from there,
         * it can only get smaller — so the <= check never becomes false either.
         * Again, only starsNumber > 0 actually does any real work here.
         *
         * SIMPLE TRACE FOR n=5:
         * patternLines = 5, starsNumber = 5
         * 5 > 0 ✅ print star, starsNumber-- → 4
         * 4 > 0 ✅ print star, starsNumber-- → 3
         * 3 > 0 ✅ print star, starsNumber-- → 2
         * 2 > 0 ✅ print star, starsNumber-- → 1
         * 1 > 0 ✅ print star, starsNumber-- → 0
         * 0 > 0 ❌ inner loop destroyed, println(), back to outer loop
         * patternLines-- → 4, and the whole inner loop rebuilds fresh starting at 4
         *
         * THE MISTAKE I MADE FIRST TIME (across both patterns honestly):
         * was writing conditions that LOOK safe but are actually redundant,
         * because I didn't trace through what the starting value of the counter
         * already guarantees. If a counter starts at the exact ceiling value,
         * checking "is it still under the ceiling" is checking something that's
         * already mathematically guaranteed true.
         *
         * LESSON: before adding a condition, ask — can this counter EVER violate
         * this check given where it starts and which direction it moves? If not,
         * the check is dead weight.
         */

        System.out
                .print("Kindly enter the total number of lines that you would like to have in your reversed pattern: ");

        int totalLinesNumber;

        while (true) {
            totalLinesNumber = sc.nextInt();
            if (totalLinesNumber <= 0) {
                System.out.print("Kindly enter a valid number: ");
            } else {
                break;
            }
        }

        for (int patternLines = totalLinesNumber; patternLines > 0; patternLines--) {
            for (int starsNumber = patternLines; starsNumber > 0; starsNumber--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /*
         * HALF PYRAMID NUMBER PATTERN
         * ─────────────────────────────────────────────────────
         * No mistakes in this one — clean on the first attempt.
         * Applied the lesson from the inverted star pattern earlier:
         * no redundant conditions this time, only the checks that
         * actually do real work.
         *
         * LOGIC:
         * outer loop (pyramidRows) controls which row we're on, 1 to totalPyramidLines
         * inner loop (numbersInPyramidLine) prints numbers from 1 up to the current row
         *
         * the difference from the star pattern is small but important —
         * instead of printing a fixed symbol like "*" every time, we're
         * printing the actual COUNTER VALUE itself (numbersInPyramidLine)
         * that's literally the only conceptual change from before
         *
         * TRACE FOR n=4:
         * row 1: inner loop runs once → prints "1"
         * row 2: inner loop runs twice → prints "1 2"
         * row 3: inner loop runs 3x → prints "1 2 3"
         * row 4: inner loop runs 4x → prints "1 2 3 4"
         *
         * same nested loop skeleton as every pattern before this,
         * just printing the loop variable instead of a hardcoded symbol
         */

        System.out.print(
                "Kindly enter the total number of lines that you would like to have in your half-pyramid pattern: ");

        int totalPyramidLines;

        while (true) {
            totalPyramidLines = sc.nextInt();
            if (totalPyramidLines <= 0) {
                System.out.println("Kindly enter a valid number: ");
            } else {
                break;
            }
        }

        for (int pyramidRows = 1; pyramidRows <= totalPyramidLines; pyramidRows++) {
            for (int numbersInPyramidLine = 1; numbersInPyramidLine <= pyramidRows; numbersInPyramidLine++) {
                System.out.print(numbersInPyramidLine + " ");
            }
            System.out.println();
        }

    }
}