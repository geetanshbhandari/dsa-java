public class Operators {

    public static void main(String[] args) {

        /*
         * ============================================================
         * ⚙️ JAVA OPERATORS - COMPLETE SUMMARY
         * ============================================================
         *
         * 📘 WHAT IS AN OPERATOR?
         * Symbols that perform operations on operands.
         * Example: int sum = a + b → a and b are operands, + is the operator.
         *
         * ============================================================
         * 1️⃣ ARITHMETIC OPERATORS → + - * / %
         * ============================================================
         * + → addition
         * - → subtraction
         * * → multiplication
         * / → division (int division truncates decimal part)
         * % → modulus (remainder after division)
         *
         * Example:
         * int x = 20, y = 6;
         * x + y = 26
         * x - y = 14
         * x * y = 120
         * x / y = 3 ← decimal part lost (int division)
         * x % y = 2 ← remainder
         *
         * ============================================================
         * 2️⃣ UNARY OPERATORS → ++ -- + - !
         * ============================================================
         * Work on ONE operand only.
         *
         * ++p → pre-increment (increment THEN use)
         * p++ → post-increment (use THEN increment)
         * --p → pre-decrement (decrement THEN use)
         * p-- → post-decrement (use THEN decrement)
         * -p → negation
         * !p → logical NOT (reverses boolean)
         *
         * KEY DIFFERENCE:
         * int p = 10;
         * int q = p++; → q = 10, p = 11 (post: old value assigned first)
         * int q = ++p; → q = 11, p = 11 (pre: incremented first)
         *
         * p++ vs p + 1:
         * p++ → actually MODIFIES p
         * p + 1 → just computes a value, does NOT change p
         *
         * ============================================================
         * 3️⃣ RELATIONAL OPERATORS → == != > < >= <=
         * ============================================================
         * Compare two values. Always return boolean (true/false).
         *
         * == → equal to (NOTE: single = is assignment, double == is comparison)
         * != → not equal to
         * > → greater than
         * < → less than
         * >= → greater than or equal to
         * <= → less than or equal to
         *
         * ============================================================
         * 4️⃣ LOGICAL OPERATORS → && || !
         * ============================================================
         * Combine boolean conditions.
         *
         * && → AND → true only if BOTH conditions are true
         * || → OR → true if AT LEAST ONE condition is true
         * ! → NOT → reverses the boolean value
         *
         * ⚡ SHORT CIRCUIT EVALUATION:
         * && → stops evaluating if first condition is false
         * || → stops evaluating if first condition is true
         *
         * ============================================================
         * 5️⃣ ASSIGNMENT OPERATORS → = += -= *= /= %=
         * ============================================================
         * Assign values to variables.
         *
         * a += 5 → same as a = a + 5 (faster execution than normal form)
         * a -= 5 → same as a = a - 5
         * a *= 5 → same as a = a * 5
         * a /= 5 → same as a = a / 5
         * a %= 5 → same as a = a % 5
         *
         * ============================================================
         * 6️⃣ OPERATOR PRECEDENCE (High → Low)
         * ============================================================
         * 1️⃣ ++, --, !, ~ → Unary
         * 2️⃣ *, /, % → Multiplicative
         * 3️⃣ +, - → Additive
         * 4️⃣ <, <=, >, >= → Relational
         * 5️⃣ ==, != → Equality
         * 6️⃣ && → Logical AND
         * 7️⃣ || → Logical OR
         * 8️⃣ =, +=, -=, *=, /=, %= → Assignment
         *
         * 🧭 ASSOCIATIVITY:
         * Most operators → Left to Right
         * Assignment operators → Right to Left
         * Example: a = b = c → c assigned to b first, then to a
         *
         * ✅ GOLDEN RULE:
         * Always use () parentheses to make order explicit and avoid bugs!
         * Example: result = a + (b * c); ← clear and readable
         * ============================================================
         */

        // ============================================================
        // ARITHMETIC OPERATORS
        // ============================================================
        int num1 = 20, num2 = 6;
        System.out.println("Addition: " + (num1 + num2)); // 26
        System.out.println("Subtraction: " + (num1 - num2)); // 14
        System.out.println("Multiplication: " + (num1 * num2)); // 120
        System.out.println("Division: " + (num1 / num2)); // 3 (int division)
        System.out.println("Modulus: " + (num1 % num2)); // 2

        // ============================================================
        // UNARY OPERATORS
        // ============================================================
        int p = 10;
        int postInc = p++; // postInc = 10, p becomes 11
        System.out.println("Post-increment → p: " + p + ", postInc: " + postInc);

        int r = 10;
        int preInc = ++r; // preInc = 11, r becomes 11
        System.out.println("Pre-increment → r: " + r + ", preInc: " + preInc);

        int s = 10;
        int postDec = s--; // postDec = 10, s becomes 9
        System.out.println("Post-decrement → s: " + s + ", postDec: " + postDec);

        int t = 10;
        int preDec = --t; // preDec = 9, t becomes 9
        System.out.println("Pre-decrement → t: " + t + ", preDec: " + preDec);

        // ============================================================
        // RELATIONAL OPERATORS
        // ============================================================
        int m = 10, n = 35;
        System.out.println("== : " + (m == n)); // false
        System.out.println("!= : " + (m != n)); // true
        System.out.println(">  : " + (m > n)); // false
        System.out.println("<  : " + (m < n)); // true
        System.out.println(">= : " + (m >= n)); // false
        System.out.println("<= : " + (m <= n)); // true

        // ============================================================
        // LOGICAL OPERATORS
        // ============================================================
        System.out.println("AND (2>3 && 5<6): " + ((2 > 3) && (5 < 6))); // false
        System.out.println("AND (2<3 && 7<10): " + ((2 < 3) && (7 < 10))); // true
        System.out.println("OR  (5>4 || 4<6): " + ((5 > 4) || (4 < 6))); // true
        System.out.println("OR  (2>3 || 5<6): " + ((2 > 3) || (5 < 6))); // true
        System.out.println("NOT !(2>3): " + (!(2 > 3))); // true
        System.out.println("NOT !(5>4): " + (!(5 > 4))); // false

        // ============================================================
        // ASSIGNMENT OPERATORS
        // ============================================================
        int val1 = 10;
        val1 += 10;
        System.out.println("+= : " + val1); // 20

        int val2 = 15;
        val2 -= 10;
        System.out.println("-= : " + val2); // 5

        int val3 = 100;
        val3 *= 10;
        System.out.println("*= : " + val3); // 1000

        int val4 = 10;
        val4 /= 6;
        System.out.println("/= : " + val4); // 1

        int val5 = 10;
        val5 %= 4;
        System.out.println("%= : " + val5); // 2

        /*
         * ============================================================
         * 🧭 ASSOCIATIVITY RULES:
         * ============================================================
         * POSTFIX (a++) → LEFT to RIGHT
         * PREFIX (++a) → RIGHT to LEFT
         * ASSIGNMENT (=) → RIGHT to LEFT
         * EVERYTHING ELSE → LEFT to RIGHT ✅
         *
         * ✅ GOLDEN RULE:
         * When confused → just use () parentheses to make order clear!
         * ============================================================
         */
    }
}