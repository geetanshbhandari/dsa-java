import java.util.Scanner;

/*  In java, naming convention is of two types:
1) pascal naming convention
2) camel case naming convention

*/

/*
========================
☕ HOW JAVA CODE RUNS
========================
1️⃣ Write code  → Source Code (.java)
2️⃣ Compile     → Compiler converts to Bytecode (.class)
3️⃣ Run         → JVM converts Bytecode → Native Code for OS

📘 JVM = Java Virtual Machine
- Acts as a translator between bytecode & OS.
- Makes Java portable across Windows, Mac, Linux.

✅ Write Once, Run Anywhere!

📊 Java vs C++:
- Java → Portable, uses JVM.
- C++  → OS-specific, needs recompilation.
- Java = Compiled + Interpreted
- Python = Purely Interpreted

Example:
.java → (compile) → .class → (JVM) → runs on any OS!
*/

public class VariablesAndDataTypes {

    public static void main(String[] args) {

        /*
         * ========================
         * 📘 SCANNER CLASS SUMMARY
         * ========================
         * - Used for taking input from user.
         * - Must import: import java.util.Scanner;
         * - Create object: Scanner sc = new Scanner(System.in);
         * - Close when done: sc.close();
         * 
         * Common methods:
         * nextInt() → int
         * nextFloat() → float
         * nextDouble() → double
         * next() → single word String
         * nextLine() → whole line String
         * nextBoolean() → boolean
         * nextByte() → byte
         * nextShort() → short
         * nextLong() → long
         * 
         * ⚠️ Important:
         * - After nextInt(), if you use nextLine(), call sc.nextLine() once to clear
         * leftover newline.
         * - Always close the Scanner at the end.
         */

        Scanner sc = new Scanner(System.in);
        /*
         * create the object of the scanner class before importing it, as otherwise vs
         * code might auto remove the unused import java.util.Scanner
         */

        System.out.println("Hello world");
        System.out.println("My name is Geetansh Bhandari");

        // printing a pattern manually using the print statements
        System.out.println("****");
        System.out.println("***");
        System.out.println("**");

        // most used data types in the initial phase of our dsa journey..
        int age = 12;
        double gpa = 4.5;
        boolean passed = true;
        char grade = 'A';
        String car = "Kia Seltos";

        // code to calculate the sum of two numbers
        /*
         * int num1 = 11;
         * int num2 = 16;
         * int num3 = (num1 + num2);
         */

        // System.out.println("The sum of two numbers is:" + num3);

        // calculating the sum of two numbers entered by the user

        System.out.print("kindly enter the first number: ");
        double userNum1 = sc.nextDouble();

        System.out.print("Kindly enter the second number: ");
        double userNum2 = sc.nextDouble();

        double userNum3 = (userNum1 + userNum2);

        System.out.println("The sum of the two numbers entered by the user is " + userNum3);

        sc.nextLine();

        /*
         * Simple rule:
         * After ANY of these:
         * 
         * sc.nextInt()
         * sc.nextDouble()
         * sc.nextFloat()
         * sc.nextLong()
         * 
         * If we need sc.nextLine() AFTER them → add a dummy sc.nextLine() in between
         * If we're NOT using sc.nextLine() after → no need
         */

        // taking string input from the user
        System.out.print("Kindly enter your full name: ");
        String userName = sc.nextLine();

        System.out.println("Hello " + userName.toUpperCase() + "\nWelcome to your coding journey :) ");

        // toUpperCase() is a string method here.. and \n is the newline character here

        // product of the two numbers entered by the user
        System.out.print("Kindly enter the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Kindly enter the second number: ");
        int num2 = sc.nextInt();

        int num3 = num1 * num2;

        System.out.println("The product of the two numbers entered by you is: " + num3);

        // calculating the area of a circle with radius input
        System.out.print("Kindly enter the radius of the circle: ");
        double circleRadius = sc.nextDouble();

        double circleArea = 3.14 * circleRadius * circleRadius;

        System.out.println("The area of the circle with the above radius would be: " + circleArea);

        sc.close();

    }
}