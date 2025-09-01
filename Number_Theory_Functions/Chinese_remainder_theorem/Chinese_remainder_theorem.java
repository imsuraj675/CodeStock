import java.util.List;
import java.util.ArrayList;

public class ChineseRemainder {

    // Function to find the smallest x such that:
    // x % num[i] = rem[i] for all i in [0, k-1]
    public static int chineseRemainder(List<Integer> num, List<Integer> rem) {
        int prod = 1;

        // Compute the product of all numbers in num (product of all moduli)
        for (int n : num)
            prod *= n;

        // Function to compute the modular inverse of a under modulo m
        int modInverse(int a, int m) {
            int m0 = m, t, q;
            int x0 = 0, x1 = 1;

            // Apply the Extended Euclidean Algorithm
            while (a > 1) {
                // q is the quotient
                q = a / m;
                t = m;
                // Update m and a (remainder and divisor)
                m = a % m;
                a = t;
                t = x0;
                // Update coefficients
                x0 = x1 - q * x0;
                x1 = t;
            }

            // Make x1 positive if it is negative
            if (x1 < 0)
                x1 += m0;

            return x1;
        }

        int result = 0;

        // Loop through each congruence
        for (int i = 0; i < num.size(); i++) {
            int pp = prod / num.get(i);  // Partial product excluding num[i]
            // Add the contribution of the current remainder to the result
            result += rem.get(i) * modInverse(pp, num.get(i)) * pp;
        }

        // Return the result modulo the product of all moduli
        return result % prod;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> num = new ArrayList<>();
        num.add(3);
        num.add(4);
        num.add(5);  // Moduli

        List<Integer> rem = new ArrayList<>();
        rem.add(2);
        rem.add(3);
        rem.add(1);  // Remainders

        // Solve the system of congruences using the Chinese Remainder Theorem
        int result = chineseRemainder(num, rem);

        // Output the result
        System.out.println("The solution is " + result);
    }
}

