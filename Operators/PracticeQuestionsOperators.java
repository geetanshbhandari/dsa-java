public class PracticeQuestionsOperators {

    public static void main(String[] args) {

        // Question 1
        /*
         * int x = 2;
         * int y = 5;
         * 
         * int exp1 = (x * y / x);
         * int exp2 = (x * (y / x));
         * 
         * System.out.print(exp1 + ",");
         * // 5 is the answer here
         * 
         * System.out.print(exp2);
         * // 4 is the answer here
         */

        // Question 2
        /*
         * int x = 200;
         * int y = 50;
         * int z = 100;
         * 
         * if (x > y && y > z) {
         * System.out.println("Hello");
         * // one is false, so overall will be false in this case
         * }
         * 
         * if (z > y && z < x) {
         * System.out.println("Java");
         * // this one will be correct..
         * }
         * 
         * if ((y + 200) < x && (y + 150) < z) {
         * System.out.println("Hello Java");
         * 
         * // incorrect again..
         * }
         */

        // Question 3
        /*
         * int x, y, z;
         * x = y = z = 2;
         * x += y;
         * y -= z;
         * z /= (x + y);
         * System.out.println(x + " " + y + " " + z);
         * // 4 0 0 will be the output..
         * 
         */

        // Question 4
        /*
         * int x = 9, y = 12;
         * int a = 2, b = 4, c = 6;
         * int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
         * 
         * System.out.println(exp);
         * // 278 is the output
         * 
         */

        // Question 5
        /*
         * int x = 10, y = 5;
         * int exp1 = (y * (x / y + x / y));
         * int exp2 = (y * x / y + y * x / y);
         * System.out.println(exp1);
         * // 20
         * System.out.println(exp2);
         * // 20
         */
    }

}
