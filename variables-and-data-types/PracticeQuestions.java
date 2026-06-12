import java.util.Scanner;

public class PracticeQuestions {

    public static void main(String[] args) {

        // Question 1
        Scanner sc = new Scanner(System.in);
        System.out.print("Kindly enter the first number: ");
        double A = sc.nextDouble();
        System.out.print("Kindly enter the second number: ");
        double B = sc.nextDouble();
        System.out.print("Kindly enter the third number: ");
        double C = sc.nextDouble();

        double averageNum = (A + B + C) / 3;

        System.out.println("The average of the three numbers is: " + averageNum);

        // Question 2
        System.out.print("Kindly enter the side of the square: ");

        double sideLength = sc.nextDouble();

        double areaSquare = sideLength * sideLength;

        System.out
                .println("The area of the square with the above sidelength would be: " + areaSquare + " square units.");

        // Question 3
        System.out.print("Kindly enter the cost of pencil: ");
        float pencilCost = sc.nextFloat();

        System.out.print("Kindly enter the cost of pen: ");
        ;
        float penCost = sc.nextFloat();

        System.out.print("Kindly enter the cost of eraser: ");
        float eraserCost = sc.nextFloat();

        float totalNormalCost = pencilCost + penCost + eraserCost;

        float totalGstCost = (totalNormalCost * 18) / 100 + (totalNormalCost);

        System.out.println("Your total without GST is: " + totalNormalCost);
        System.out.println("Your total with GST is: " + totalGstCost);

        // Question 4

        byte b = 4;
        char c = 'a';
        short s = 512;
        int i = 1000;
        float f = 3.14f;

        double d = 99.9954;

        /*
         * result = (f*b)+(i%c)-(d*s);
         * // the resulting data type in the above case would be double !
         * As, float + int - double = double (double is the most dominating data
         * type out of these three in the above operation..)
         * 
         */

        /*
         * Question 5
         * int $ = 24;
         * In java, I can have a $ sign as my variable name.
         * 
         * A Java variable name can only contain:Letters (A-Z, a-z)Digits (0-9, but not
         * at the start) Underscore (_) Dollar sign ($)
         */

    }

}
