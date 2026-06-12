public class TypeConversion {

    public static void main(String[] args) {

        /*
         * ========================
         * 🧠 TYPE CONVERSION (IMPLICIT)
         * ========================
         * Also called *Widening Conversion / Automatic Conversion*.
         * 
         * ✅ Happens automatically when:
         * 1️⃣ Types are compatible.
         * 2️⃣ Destination type > Source type (no data loss).
         * 
         * Conversion hierarchy:
         * byte → short → int → long → float → double
         * 
         * Example:
         * int x = 10;
         * float y = x; // implicit: int → float
         * 
         * ❌ Not allowed between incompatible types:
         * int ↔ boolean (invalid)
         * 
         * -----------------------------------
         * 
         * ========================
         * 🎯 TYPE CASTING (EXPLICIT)
         * ========================
         * Also called *Narrowing Conversion / Manual Conversion*.
         * 
         * ✅ Done by programmer using (datatype).
         * ⚠️ Can cause data or precision loss.
         * 
         * Syntax:
         * targetType var = (targetType) value;
         * 
         * Example:
         * float f = 99.99f;
         * int i = (int) f; // explicit: float → int (decimal part lost)
         * 
         * Overflow example:
         * byte b = (byte) 130; // result: -126 (overflowed)
         * 
         * -----------------------------------
         * 
         * ========================
         * 🔡 CHARACTER CONVERSION
         * ========================
         * - char internally stores *Unicode values* (numeric).
         * - Implicitly converts between char ↔ int.
         * 
         * Examples:
         * char ch = 'A';
         * int code = ch; // char → int (65)
         * int n = 66;
         * char c = (char) n; // int → char ('B')
         * 
         * -----------------------------------
         * 
         * ========================
         * 🧩 BONUS: PROMOTION RULES IN EXPRESSIONS
         * ========================
         * When different data types appear in an expression:
         * byte, short, char → promoted to int before evaluation.
         * Example:
         * byte a = 5, b = 10;
         * byte c = a + b; // ❌ error
         * int c = a + b; // ✅ auto promoted to int
         * 
         * Mixed-type arithmetic:
         * int + float → float
         * int + double → double
         * long + float → float
         * float + double → double
         * 
         * -----------------------------------
         * 
         * ✅ QUICK SUMMARY TABLE
         * 
         * | Concept | Type | Direction | Example |
         * |--------------------|-------------|----------------|----------------------|
         * | Type Conversion | Implicit | small → large | int → float |
         * | Type Casting | Explicit | large → small | (int) 3.14f |
         * | Char Conversion | Auto/manual | char ↔ int | 'A' → 65 / (char)66 |
         * 
         * -----------------------------------
         * 
         * ⚡ NEVER FORGET:
         * - Implicit = safe widening.
         * - Explicit = risky narrowing.
         * - char ↔ int is allowed.
         * - byte/short/char always promoted to int in expressions.
         * - Always close Scanner when done.
         */

        /*
         * double num1 = 10.65;
         * int num2 = (int) num1;
         * System.out.println(num2);
         * // the above was an example of explicit conversion.
         * 
         * int num3 = 11;
         * double num4 = num3;
         * System.out.println(num4); // example of implicit conversion..
         * 
         * char ch = 'a';
         * int num5 = ch;
         * System.out.println(num5);
         * // char ↔ int is allowed.
         * 
         * int num6 = 101;
         * char ch2 = (char) num6;
         * 
         * System.out.println(ch2);
         */
        // This requires an explicit cast because you're going from a wider type to a
        // narrower one, and data could potentially be lost.

        float f1 = 10.95f;
        int n1 = (int) f1;

        System.out.println(n1);

        /*
         * ========================
         * ⚙️ TYPE PROMOTION RULE
         * ========================
         * - Happens ONLY inside expressions/operations (e.g. a + b, a * b).
         * - Promotes smaller data types to int (or higher) for safe arithmetic.
         * 
         * Examples:
         * byte + byte → int
         * short + char → int
         * int + float → float
         * float + double → double
         * 
         * 📘 Note:
         * - Simple assignments like int x = c; → implicit conversion (not promotion).
         * - Promotions occur during arithmetic or mixed-type expressions only.
         */

        byte num1 = 125;
        byte num2 = 112;

        byte b3 = (byte) (num1 + num2);
        System.out.println(b3);

        /*
         * ============================================================
         * BYTE OVERFLOW RULE:
         * byte range = -128 to 127 (256 values total)
         * If result > 127 → subtract 256 until it's in range
         * If result < -128 → add 256 until it's in range
         * Example: 237 → 237 - 256 = -19
         * ============================================================
         *
         * CHAR & UNICODE IN JAVA:
         * char stores a single Unicode character (16-bit, 0 to 65535)
         * char c = 'A'; → stores Unicode value 65
         *
         * FAMOUS UNICODE VALUES:
         * 'A' = 65 'a' = 97
         * 'B' = 66 'b' = 98
         * 'Z' = 90 'z' = 122
         * '0' = 48 '9' = 57
         * ' ' = 32 (space)
         * '!' = 33
         * '\n' = 10 (newline)
         * '\t' = 9 (tab)
         *
         * char → int : IMPLICIT (widening, automatic)
         * int → char : EXPLICIT (narrowing, cast needed)
         * Example:
         * char c = 'A'; int n = c; // n = 65
         * int n = 65; char c = (char)n; // c = 'A'
         * ============================================================
         */

        byte num3 = 15;
        byte num4 = 12;

        // byte b3 = (num3+num4);
        // this should be int instead as we are performing operations on the bytes..

        int num5 = num3 + num4;
        System.out.println(num5);

        char ch3 = 'B';
        short sh1 = 57;
        System.out.println(ch3 + sh1);
        // both converted to the int type during the operation..

        float f3 = 3.456f;
        int num7 = 167;

        System.out.println(f3 + num7);
        // as float was the dominating data type here during the operation..

    }
}
