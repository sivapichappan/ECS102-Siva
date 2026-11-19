/**
 * GadgetShop - STARTER
 * Lesson: The Math class and the String class in Java
 *
 * Complete every TODO. Run the program after each part and check your output.
 *
 * Part A: the Math class. Math methods are static: call them on the class
 *         name, like Math.sqrt(16). Do NOT create a Math object.
 * Part B: the String class. A String is an object with many methods.
 *         Strings are immutable: every method returns a NEW String.
 */
public class GadgetShop {

    public static void main(String[] args) {

        // ---------------- PART A: The Math class ----------------
        // A tablet screen is 9 inches wide and 12 inches tall.
        double width = 9.0;
        double height = 12.0;

        // A1. TODO: diagonal = square root of (width squared + height squared)
        //     Use Math.sqrt and Math.pow.
        double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        System.out.println("A1 Screen diagonal: " + diagonal);

        // A2. Two stores sell the same headphones.
        double priceA = 349.99;
        double priceB = 299.50;
        // TODO: store the lower price using a Math method.
        double lower = Math.min(priceA, priceB);
        System.out.println("A2 Lower price: " + lower);

        // A3. TODO: savings = the positive difference between the two prices.
        double savings = Math.abs(priceA - priceB);
        System.out.println("A3 Savings (raw): " + savings);

        // A4. TODO: round savings to cents.
        //     Multiply by 100, use Math.round, then divide by 100.0
        double savingsCents = Math.round(savings * 100) / 100.0;
        System.out.println("A4 Savings (rounded): " + savingsCents);

        // A5. TODO: a random whole number from 1 to 100 using Math.random()
        int ticket = (int)(Math.random() * 100) + 1;
        System.out.println("A5 Raffle ticket: " + ticket);

        // ---------------- PART B: The String class ----------------
        String code = "tab-2026-blue";

        // B1. TODO: the number of characters in code
        int len = code.length();
        System.out.println("B1 Length: " + len);

        // B2. TODO: the index of the first "-" in code
        int dash = code.indexOf("-");
        System.out.println("B2 First dash at index: " + dash);

        // B3. TODO: the product type (everything before the first dash)
        String type = code.substring(0, dash);
        System.out.println("B3 Type: " + type);

        // B4. TODO: the color (starts at index 9)
        String color = code.substring(9);
        System.out.println("B4 Color: " + color);

        // B5. Run this line as written. Predict the output BEFORE you run it.
        code.toUpperCase();
        System.out.println("B5 After code.toUpperCase(): " + code);

        // B6. TODO: change the line below so code really becomes uppercase.
        code = code.toUpperCase();
        System.out.println("B6 After code = code.toUpperCase(): " + code);

        // B7. TODO: compare code with scanned using the correct String method.
        String scanned = "TAB-2026-BLUE";
        boolean match = code.equals(scanned);
        System.out.println("B7 Codes match: " + match);
    }
}
