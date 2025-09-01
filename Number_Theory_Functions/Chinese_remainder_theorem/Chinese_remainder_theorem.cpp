#include <iostream>
#include <vector>
using namespace std;

// Function to find the smallest x such that:
// x % num[i] = rem[i] for all i in [0, k-1]
int chineseRemainder(vector<int> num, vector<int> rem) {
    int prod = 1;

    // Compute the product of all numbers in num (product of all moduli)
    for (int n : num)
        prod *= n;

    // Lambda function to compute the modular inverse of a under modulo m
    auto modInverse = [](int a, int m) {
        int m0 = m, t, q;
        int x0 = 0, x1 = 1;

        // Apply the Extended Euclidean Algorithm
        while (a > 1) {
            // q is the quotient
            q = a / m;
            t = m;
            // Update m and a (remainder and divisor)
            m = a % m, a = t;
            t = x0;
            // Update coefficients
            x0 = x1 - q * x0;
            x1 = t;
        }

        // Make x1 positive if it is negative
        if (x1 < 0)
            x1 += m0;

        return x1;
    };

    int result = 0;

    // Loop through each congruence
    for (size_t i = 0; i < num.size(); i++) {
        int pp = prod / num[i];  // Partial product excluding num[i]
        // Add the contribution of the current remainder to the result
        result += rem[i] * modInverse(pp, num[i]) * pp;
    }

    // Return the result modulo the product of all moduli
    return result % prod;
}

int main() {
    // Example usage
    vector<int> num = {3, 4, 5};  // Moduli
    vector<int> rem = {2, 3, 1};  // Remainders

    // Solve the system of congruences using the Chinese Remainder Theorem
    int result = chineseRemainder(num, rem);

    // Output the result
    cout << "The solution is " << result << endl;

    return 0;
}
