import java.util.*;

public class LoopsBasics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Q1: print "Hello World" 6 times using a while loop
        // helloCount goes 0, 1, 2, 3, 4, 5 so the loop runs exactly 6 times
        // the condition stays true until helloCount hits 6, then it stops
        // if i forget helloCount++ inside, the condition never becomes false = infinite
        // loop
        int helloCount = 0;
        while (helloCount <= 5) {
            System.out.println("Hello World");
            helloCount++;
        }

        // Q2: print numbers from 1 to 10
        // three things every while loop needs: initialize before, check condition,
        // increment inside
        // this is basically the template for every loop i write
        int printNum = 1;
        while (printNum <= 10) {
            System.out.print(printNum + " ");
            printNum++;
        }
        System.out.println();

        // Q3: print numbers from 1 to N where N comes from the user
        // same idea as Q2 but now the limit is flexible, user decides instead of
        // hardcoding 10
        System.out.print("Enter N to print numbers from 1 to N: ");
        int userN1 = sc.nextInt();
        int rangeNum = 1;
        while (rangeNum <= userN1) {
            System.out.println(rangeNum);
            rangeNum++;
        }

        // Q4: sum of first N natural numbers
        // totalSum has to live outside the loop, if i put it inside it resets to 0
        // every iteration
        // this is the accumulator pattern, totalSum keeps growing with each step
        // there is a O(1) formula n*(n+1)/2 that does this in one line but at the loops
        // stage
        // the loop version is the right thing to focus on, formula can come later
        System.out.print("Enter N for sum of first N natural numbers: ");
        int userN2 = sc.nextInt();
        int sumI = 1;
        int totalSum = 0;
        while (sumI <= userN2) {
            totalSum += sumI;
            sumI++;
        }
        System.out.println("Sum of first " + userN2 + " natural numbers: " + totalSum);

        // Q5: print a 4x4 square pattern
        // patternRow goes 0 to 3, condition < 4 gives exactly 4 iterations
        // hardcoding the row string works fine for a fixed 4x4 size
        // for variable dimensions i would need nested loops but that comes later
        int patternRow = 0;
        while (patternRow < 4) {
            System.out.println("* * * *");
            patternRow++;
        }

        // Q6: print the digits of a number in reverse
        // n % 10 gives the last digit, n / 10 removes that digit
        // so each iteration i strip one digit from the right and print it
        // for 12345 this prints: 5 4 3 2 1
        // this is O(log n) since iterations = number of digits = log10(n)
        // forgetting the /= 10 part means the same last digit prints forever
        System.out.print("Enter a number to print its digits in reverse: ");
        int revPrintNum = sc.nextInt();
        while (revPrintNum > 0) {
            System.out.print((revPrintNum % 10) + " ");
            revPrintNum /= 10;
        }
        System.out.println();

        // Q7: reverse a number and actually store it, not just print the digits

        // how does storedRev = (storedRev * 10) + (origNum % 10) build the reversed
        // number?
        // origNum % 10 pulls the last digit
        // storedRev * 10 shifts whatever i already have one place left to make room for
        // the new digit
        // tracing through 123 to see this clearly:
        // start: storedRev = 0
        // step 1: last digit is 3, storedRev = (0 * 10) + 3 = 3
        // step 2: last digit is 2, storedRev = (3 * 10) + 2 = 32
        // step 3: last digit is 1, storedRev = (32 * 10) + 1 = 321
        // and 321 is exactly the reverse of 123, the formula works perfectly

        // why storedRev = origNum % 10 alone does not work:
        // without the * 10, every iteration just overwrites storedRev with the newest
        // digit
        // i lose everything from before and only keep the very last digit i saw
        // the * 10 is what actually builds the number, skipping it breaks everything

        // leading zeros edge case:
        // if i input 100, the digits are 0, 0, 1 which gives 001 but as an int that is
        // just 1
        // integers cannot hold leading zeros, handling that needs a String (a later
        // topic)
        // just good to know this limitation exists for now

        // brute force approaches people try first:
        // 1. convert to String, reverse it, convert back to int (works but feels
        // roundabout)
        // 2. store all digits in an array then read it backwards (works but wastes
        // space)
        // the math version here is the actual optimal approach, not brute force
        // this is O(log n), the go to solution for reversing a number

        System.out.print("Enter a number to reverse and store: ");
        int origNum = sc.nextInt();
        int storedRev = 0;
        while (origNum > 0) {
            System.out.print(origNum % 10 + " ");
            storedRev = (storedRev * 10) + (origNum % 10);
            origNum /= 10;
        }
        System.out.println();
        System.out.println("The reversed number is: " + storedRev);

        sc.close();
    }
}
