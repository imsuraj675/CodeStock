import java.util.*;

public class Main {
    static final int M = 1000000007; // Modulus value

    // Function to precompute factorial modulo M
    static long[] precomputeFactorials(int n) {
        long[] fact = new long[n + 1];
        fact[0] = 1; // 0! = 1
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % M;
        }
        return fact;
    }

    // Function to compute modular exponentiation
    static long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) { // If exp is odd
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    // Function to compute modular inverse
    static long modInverse(long a, int M) {
        return modExp(a, M - 2, M); // a^(M-2) mod M
    }

    // Function to compute nPr modulo M
    static long nPr(int n, int r, long[] fact) {
        if (r > n) return 0; // nPr is 0 if r > n
        long numerator = fact[n]; // n!
        long denominator = fact[n - r]; // (n - r)!
        return (numerator * modInverse(denominator, M)) % M;
    }

    public static void main(String[] args) {
        int n = 10, r = 3;

        // Precompute factorials up to n modulo M
        long[] fact = precomputeFactorials(n);

        // Compute nPr modulo M
        System.out.println("nPr(" + n + ", " + r + ") mod " + M + " = " + nPr(n, r, fact));
    }
}
