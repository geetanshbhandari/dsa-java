import java.util.Scanner;

/*
 * ====================================================================
 * Conditional Statements in Java
 * ====================================================================
 *
 * 1. IF
 *    Executes a block only when a condition evaluates to true.
 *
 * 2. IF-ELSE
 *    Runs one block when the condition is true, another when it is false.
 *
 * 3. ELSE-IF LADDER
 *    Checks multiple conditions from top to bottom.
 *    The first true condition executes and the rest are skipped.
 *    Put the most specific condition first.
 *
 * 4. TERNARY OPERATOR
 *    A one-line shorthand for a simple if-else.
 *    Syntax: resultType variable = (condition) ? valueIfTrue : valueIfFalse;
 *    Use only for single-condition decisions. Never nest it.
 *
 * 5. SWITCH
 *    Matches one variable against a list of fixed values (cases).
 *    Always use break after each case and include a default case.
 *
 * --------------------------------------------------------------------
 * Questions Covered:
 *   Q1. Find the larger of two numbers
 *   Q2. Check whether a number is odd or even
 *   Q3. Income tax bracket calculator
 *   Q4. Find the largest of three numbers
 *   Q5. Pass or fail check using the ternary operator
 *   Q6. Employee bonus calculator using switch
 *   Q7. Arithmetic calculator using switch
 * ====================================================================
 */

public class ConditionalStatements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Q1 - Find the larger of two numbers
        System.out.println("Q1: Find the larger of two numbers");
        System.out.print("Enter your first number: ");
        int firstValue = sc.nextInt();

        System.out.print("Enter your second number: ");
        int secondValue = sc.nextInt();

        if (firstValue > secondValue) {
            System.out.println("The larger of the two numbers is: " + firstValue);
        } else {
            System.out.println("The larger of the two numbers is: " + secondValue);
        }

        // Q2 - Check whether a number is odd or even
        System.out.println("\nQ2: Check whether a number is odd or even");
        System.out.print("Enter a number: ");
        int numberInput = sc.nextInt();

        if (numberInput % 2 == 0) {
            System.out.println(numberInput + " is an even number.");
        } else {
            System.out.println(numberInput + " is an odd number.");
        }

        // Q3 - Income tax bracket calculator
        System.out.println("\nQ3: Income tax bracket calculator");
        System.out.print("Enter your gross annual income in rupees: ");
        double grossYearlyIncome = sc.nextDouble();

        if (grossYearlyIncome < 500000) {
            System.out.println("You fall in the 0% tax bracket.");
            System.out.println("Your net annual income after tax is: " + grossYearlyIncome + " rupees.");
        } else if (grossYearlyIncome <= 1000000) {
            System.out.println("You fall in the 20% tax bracket.");
            System.out.println("Your net annual income after tax is: "
                    + (grossYearlyIncome - 20 * grossYearlyIncome / 100) + " rupees.");
        } else {
            System.out.println("You fall in the 30% tax bracket.");
            System.out.println("Your net annual income after tax is: "
                    + (grossYearlyIncome - 30 * grossYearlyIncome / 100) + " rupees.");
        }

        // Q4 - Find the largest of three numbers
        System.out.println("\nQ4: Find the largest of three numbers");
        System.out.print("Enter your first number: ");
        int numFirst = sc.nextInt();

        System.out.print("Enter your second number: ");
        int numSecond = sc.nextInt();

        System.out.print("Enter your third number: ");
        int numThird = sc.nextInt();

        if (numFirst >= numSecond && numFirst >= numThird) {
            System.out.println("The largest number is: " + numFirst);
        } else if (numSecond >= numThird) {
            System.out.println("The largest number is: " + numSecond);
        } else {
            System.out.println("The largest number is: " + numThird);
        }

        // Q5 - Pass or fail check using the ternary operator
        /*
         * TERNARY OPERATOR
         * ====================================================================
         * Shorthand for a simple if-else with a single condition.
         * Use it only when you have one if and one else, nothing more.
         *
         * Syntax:
         * resultType variable = (condition) ? valueIfTrue : valueIfFalse;
         *
         * How to think through it:
         * Step 1 - What is the condition? age >= 18
         * Step 2 - What happens if true? "Adult"
         * Step 3 - What happens if false? "Minor"
         * Step 4 - What is the result type? String
         *
         * String category = (age >= 18) ? "Adult" : "Minor";
         *
         * Use ternary for: simple single-condition true/false decisions.
         * Avoid ternary for: multiple else-if conditions or nested logic.
         * ====================================================================
         */
        System.out.println("\nQ5: Pass or fail check using the ternary operator");
        System.out.print("Enter your marks: ");
        double studentMarks = sc.nextDouble();

        String studentGrade = (studentMarks >= 33)
                ? "Congratulations, you have passed the subject."
                : "Sorry, you have failed the course.";
        System.out.println(studentGrade);

        // Q6 - Employee bonus calculator using switch
        System.out.println("\nQ6: Employee bonus calculator");
        System.out.print("Enter your performance rating (1 to 5): ");
        int employeeRating = sc.nextInt();

        System.out.print("Enter your annual salary in rupees: ");
        float annualSalary = sc.nextFloat();

        switch (employeeRating) {
            case 1:
                System.out.println("Poor rating. No bonus will be provided.");
                break;
            case 2:
                System.out.println("Average rating. You will receive a bonus of 5%, i.e. "
                        + (5 * annualSalary / 100) + " rupees.");
                break;
            case 3:
                System.out.println("Good rating. You will receive a bonus of 10%, i.e. "
                        + (10 * annualSalary / 100) + " rupees.");
                break;
            case 4:
                System.out.println("Excellent rating. You will receive a bonus of 20%, i.e. "
                        + (20 * annualSalary / 100) + " rupees.");
                break;
            case 5:
                System.out.println("Outstanding rating. You will receive a bonus of 30%, i.e. "
                        + (30 * annualSalary / 100) + " rupees.");
                break;
            default:
                System.out.println("Please enter a valid rating between 1 and 5.");
        }

        // Q7 - Arithmetic calculator using switch
        /*
         * WHY STRING IS SAFER THAN charAt(0) FOR SWITCH INPUT
         * ====================================================================
         * charAt(0) approach (avoid this):
         * char op = sc.nextLine().charAt(0);
         * If the user presses Enter without typing anything, sc.nextLine()
         * returns "" and "".charAt(0) throws StringIndexOutOfBoundsException,
         * crashing the program completely.
         *
         * String approach (use this):
         * String op = sc.nextLine();
         * Empty input "" triggers the default case, no crash.
         * Space input " " triggers the default case, no crash.
         * Wrong input "abc" triggers the default case, no crash.
         *
         * Rule: always use String for switch input, never use charAt(0).
         * ====================================================================
         */
        System.out.println("\nQ7: Arithmetic calculator");
        System.out.print("Enter your first number: ");
        float calcNum1 = sc.nextFloat();

        System.out.print("Enter your second number: ");
        float calcNum2 = sc.nextFloat();

        sc.nextLine();

        System.out.print("Enter the operation you want to perform (+, -, *, /, %): ");
        String arithmeticOp = sc.nextLine();

        switch (arithmeticOp) {
            case "+":
                System.out.println("The sum of the two numbers is: " + (calcNum1 + calcNum2));
                break;
            case "-":
                System.out.println("The difference of the two numbers is: " + (calcNum1 - calcNum2));
                break;
            case "*":
                System.out.println("The product of the two numbers is: " + (calcNum1 * calcNum2));
                break;
            case "/":
                if (calcNum2 == 0) {
                    System.out.println("Division by zero is not allowed.");
                } else {
                    System.out.println(
                            "The result of dividing the first number by the second is: " + (calcNum1 / calcNum2));
                }
                break;
            case "%":
                System.out.println(
                        "The remainder when dividing the first number by the second is: " + (calcNum1 % calcNum2));
                break;
            default:
                System.out.println("Please enter a valid operation: +, -, *, /, or %.");
        }

        sc.close();
    }
}

/*
 * KEY THINGS TO REMEMBER
 * ====================================================================
 * - Use == for comparison inside conditions, not = (that is assignment).
 * - In an else-if ladder, the first true condition wins. Put the most
 * specific or restrictive condition at the top.
 * - Ternary is only for single-condition decisions. Never nest ternaries.
 * - switch works with exact fixed values, not ranges. Use it when you are
 * comparing one variable against many specific constants.
 * - Always add break after each switch case to prevent fall-through.
 * - Always include a default case in switch to handle unexpected input.
 * - Use String for switch input, not charAt(0). String handles empty
 * input gracefully; charAt(0) crashes the program.
 * ====================================================================
 */

/*
 * COMMON MISTAKES TO AVOID
 * ====================================================================
 * ❌ Writing = instead of == inside a condition
 * ❌ Missing break in a switch case (causes unintended fall-through)
 * ❌ Forgetting the default case in a switch statement
 * ❌ Using charAt(0) for switch input (crashes on empty input)
 * ❌ Nesting ternary operators (unreadable and hard to debug)
 * ❌ Omitting curly braces {} in if-else when adding multiple statements
 * ❌ Putting a less restrictive condition before a more restrictive one
 * in an else-if ladder (the earlier match will always win)
 * char must ALWAYS contain exactly one character — no more, no less!
 * String can contain zero, one or infinite characters!
 * ====================================================================
 */
