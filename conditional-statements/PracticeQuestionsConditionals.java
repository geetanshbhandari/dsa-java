import java.util.Scanner;

public class PracticeQuestionsConditionals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Question1
        System.out.print("Kindly enter your number: ");
        float num1 = sc.nextFloat();

        if (num1 > 0) {
            System.out.println("The number entered by you is a positive number");
        }

        else if (num1 < 0) {
            System.out.println("The number entered by you is a negative number");
        }

        else {
            System.out.println("The number entered by you is a neutral number, i.e. Zero !");
        }

        // Question 2

        System.out.print("Kindly enter your body temperature (in degree celcius): ");
        double bodyTemp = sc.nextDouble();

        if (bodyTemp > 100) {
            // fever above temperature 100 (as said in the question..)
            System.out.println("You have a fever.");
        }

        else {
            System.out.println("You don't have a fever.");
        }

        // Question 3
        System.out.print("Kindly enter the weekday number: ");

        int dayOfWeek = sc.nextInt();

        switch (dayOfWeek) {

            case 1:
                System.out.println("This weekday number represents Monday.");
                break;

            case 2:
                System.out.println("This weekday number represents Tuesday.");
                break;

            case 3:
                System.out.println("This weekday number represents Wednesday.");
                break;

            case 4:
                System.out.println("This weekday number represents Thursday.");
                break;

            case 5:
                System.out.println("This weekday number represents Friday.");
                break;

            case 6:
                System.out.println("This weekday number represents Saturday.");
                break;

            case 7:
                System.out.println("This weekday number represents Sunday.");
                break;

            default:
                System.out.println("Kindly enter a valid weekday number between 1 and 7 :)");

        }

        // Question 4
        int a = 63;
        int b = 36;
        boolean x = (a < b) ? true : false;
        int y = (a > b) ? a : b;

        // The value of x and y in the above program would be false and 63 respectively.

        // Question 5

        System.out.print("Kindly enter the year of your choice: ");
        int userYear = sc.nextInt();

        if ((userYear % 4 == 0 && userYear % 100 != 0)
                || (userYear % 4 == 0 && userYear % 100 == 0 && userYear % 400 == 0)) {
            System.out.println("The year entered by you is a leap year.");
        }

        else {
            System.out.println("The year entered by you is not a leap year.");
        }

    }

}
