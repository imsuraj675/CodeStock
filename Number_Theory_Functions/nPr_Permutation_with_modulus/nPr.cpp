#include <bits/stdc++.h>
using namespace std;

const int M = 1e9 + 7; // Modulus value (you can adjust it)

// Function to compute factorial modulo M
vector<long long> precomputeFactorials(int n, int M) {
    vector<long long> fact(n + 1, 1);
    for (int i = 2; i <= n; i++) {
        fact[i] = (fact[i - 1] * i) % M;
    }
    return fact;
}

// Function to compute modular exponentiation
long long modExp(long long base, long long exp, int mod) {
    long long result = 1;
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
long long modInverse(long long a, int M) {
    return modExp(a, M - 2, M); // a^(M-2) mod M
}

// Function to compute nPr modulo M
long long nPr(int n, int r, const vector<long long>& fact, int M) {
    if (r > n) return 0; // nPr is 0 if r > n
    long long numerator = fact[n]; // n!
    long long denominator = fact[n - r]; // (n - r)!
    return (numerator * modInverse(denominator, M)) % M;
}

int main() {
    int n = 10, r = 3;

    // Precompute factorials up to n modulo M
    vector<long long> fact = precomputeFactorials(n, M);

    // Compute nPr modulo M
    cout << "nPr(" << n << ", " << r << ") mod " << M << " = " << nPr(n, r, fact, M) << endl;

    return 0;
}
