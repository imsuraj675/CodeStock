
# **Chinese Remainder Theorem**

The Chinese Remainder Theorem (CRT) was discovered by the Chinese mathematician Sun Zi.

## Formulation

Let \( m = m₁ × m₂ × ⋯ × mₖ \), where \( mᵢ \) are pairwise coprime. In addition to \( mᵢ \), we are also given a system of congruences:

a ≡ a₁ (mod m₁) a ≡ a₂ (mod m₂) ⋮ a ≡ aₖ (mod mₖ)

where \( aᵢ \) are given constants. The original form of CRT states that the given system of congruences always has **one and exactly one solution modulo \( m \)**.


## Solution for General Case

### Direct Construction
A direct construction similar to Lagrange interpolation is possible.

Let:

`Mᵢ := Π_{j ≠ i} mⱼ`

(the product of all moduli except `mᵢ`) and:

`Nᵢ := Mᵢ⁻¹ (mod mᵢ)`

Then, a solution to the system of congruences is:

`a ≡ Σ_{i=1}^{k} aᵢMᵢNᵢ (mod m₁m₂...mₖ)`

---

### Verification
We can check this is indeed a solution by computing `a (mod mᵢ)` for all `i`. Because `Mⱼ` is a multiple of `mᵢ` for `i ≠ j`, we have:

`a ≡ Σ_{j=1}^{k} aⱼMⱼNⱼ (mod mᵢ)`

`≡ aᵢMᵢNᵢ (mod mᵢ)`

`≡ aᵢMᵢMᵢ⁻¹ (mod mᵢ)`

`≡ aᵢ (mod mᵢ)`



### Generalized Chinese Remainder Theorem (CRT) for Non-Coprime Moduli

When the moduli m₁, m₂, ..., mₖ are **not pairwise coprime**, the standard Chinese Remainder Theorem cannot be directly applied. However, such systems can still be solved under certain conditions.

---

To solve a system of congruences with non-coprime moduli:

1. **Define the System**:
   x ≡ aᵢ (mod mᵢ), for i = 1, 2, ..., k

2. **Check Pairwise Consistency**:
   - For each pair of congruences:
     x ≡ aᵢ (mod mᵢ)
     x ≡ aⱼ (mod mⱼ)

     - Compute gcd(mᵢ, mⱼ) = g.
     - Verify aᵢ ≡ aⱼ (mod g). If this condition is violated, the system is inconsistent.

3. **Combine Consistent Congruences**:
   - Combine congruences iteratively using the least common multiple (lcm) of moduli:
     x ≡ a (mod lcm(mᵢ, mⱼ))

4. **Solve the Final Reduced System**:
   - After reducing all congruences, solve the resulting single congruence.

---

## Example: Solving a System with Non-Coprime Moduli

Solve the system:
x ≡ 2 (mod 6)
x ≡ 3 (mod 9)

### Step 1: Check Consistency
- Compute gcd(6, 9) = 3.
- Verify 2 ≡ 3 (mod 3). This condition is satisfied because both leave a remainder of 2 modulo 3.

### Step 2: Combine Congruences
- Combine the two congruences into one:
  x ≡ 2 (mod lcm(6, 9)) = x ≡ 2 (mod 18)

### Final Solution:
x ≡ 2 (mod 18)

---

## Notes:
- If the system is inconsistent, no solution exists.
- If all moduli are coprime, the standard Chinese Remainder Theorem applies.

## USE OF CHINESE REMAINDER THEOREM IN SOLVING PROBLEMS
Problem: Multiple Congruences with Mixed Moduli and Constraints

Sure! Let's tackle a more complex problem that involves the Chinese Remainder Theorem (CRT). Here's a more challenging problem that would require using CRT, along with some advanced concepts like handling large inputs, dealing with constraints, and considering edge cases.

Problem: Multiple Congruences with Mixed Moduli and Constraints
You are given several systems of congruences. Each system can have different moduli and constraints. Your goal is to use the Chinese Remainder Theorem to solve this.

### Problem Statement:

Given a system of `n` congruences of the form:
x ≡ a₁ (mod m₁) x ≡ a₂ (mod m₂) ... x ≡ aₙ (mod mₙ)

Where `mᵢ` and `mⱼ` (for all `i ≠ j`) are **not necessarily coprime** (i.e., they may share common factors). The task is to find the smallest `x` that satisfies all these congruences, or determine that there is **no solution**.

### Input Format:
- The first line contains a single integer `n` — the number of congruences.
- The second line contains `n` space-separated integers, each representing a modulus: `m₁, m₂, ..., mₙ`.
- The third line contains `n` space-separated integers, each representing the corresponding remainder: `a₁, a₂, ..., aₙ`.



### Output Format:
- If a solution exists, output the smallest `x` that satisfies all the congruences.
- If no solution exists, output `No solution`.

Here,to solve this problem, we have to use the extended form of chinese remainder theorem as the given moduli are not given to be coprime i.e.
gcd(m<sub>i</sub>,m<sub>j</sub>)|abs(a<sub>i</sub>-a<sub>j</sub>)


The following code shows the implementation of above logic


```cpp
#include <iostream>
#include <vector>
#include <numeric> // For gcd
using namespace std;

// Function to find the modular inverse of a under modulo m (when gcd(a, m) == 1)
int modInverse(int a, int m) {
    int m0 = m, t, q;
    int x0 = 0, x1 = 1;

    while (a > 1) {
        q = a / m;
        t = m;
        m = a % m;
        a = t;
        t = x0;
        x0 = x1 - q * x0;
        x1 = t;
    }

    if (x1 < 0)
        x1 += m0;

    return x1;
}

// Function to solve the system of congruences using the Chinese Remainder Theorem
int chineseRemainder(vector<int> num, vector<int> rem) {
    int prod = 1;

    // Compute the product of all numbers in num (product of all moduli)
    for (int n : num)
        prod *= n;

    int result = 0;

    // Loop through each congruence
    for (size_t i = 0; i < num.size(); i++) {
        int pp = prod / num[i];  // Partial product excluding num[i]
        result += rem[i] * modInverse(pp, num[i]) * pp;
    }

    // Return the result modulo the product of all moduli
    return result % prod;
}

// Function to check if the system of congruences is solvable
bool isSolvable(const vector<int>& num, const vector<int>& rem) {
    int n = num.size();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int g = gcd(num[i], num[j]);
            if (g > 1 && abs(rem[i] - rem[j]) % g != 0) {
                return false;  // If gcd doesn't divide the difference of remainders, no solution
            }
        }
    }
    return true;
}

// Function to solve the system of congruences even when moduli are not coprime
bool extendedChineseRemainder(vector<int>& num, vector<int>& rem) {
    int n = num.size();

    // Loop through the moduli and solve pairwise
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int g = gcd(num[i], num[j]);
            // Check if the difference of remainders is divisible by the gcd
            if (abs(rem[i] - rem[j]) % g != 0) {
                return false; // No solution if this condition fails
            }

            // Solve pairwise congruences using the Extended Euclidean Algorithm
            int x1 = rem[i], x2 = rem[j];
            int m1 = num[i], m2 = num[j];

            // Calculate the combined modulus
            int newMod = (m1 * m2) / g;
            int newRem = 0;

            // Solve the pairwise system (x1 mod m1) and (x2 mod m2)
            int g1, x, y;
            extendedGCD(m1, m2, g1, x, y);
            x = ((x * (x2 - x1) / g) % (m2)) + m1;
            newRem = (x * m1 + x1) % newMod;

            // Update moduli and remainders for the new system
            num[i] = newMod;
            rem[i] = newRem;
        }
    }

    return true;
}

// Function to find the Extended GCD of two numbers (also computes the coefficients x and y such that ax + by = gcd(a, b))
void extendedGCD(int a, int b, int& g, int& x, int& y) {
    if (a == 0) {
        g = b;
        x = 0;
        y = 1;
        return;
    }

    int x1, y1;
    extendedGCD(b % a, a, g, x1, y1);
    x = y1 - (b / a) * x1;
    y = x1;
}

// Driver code
int main() {
    int n;
    cin >> n;

    vector<int> num(n);
    vector<int> rem(n);

    // Input the moduli and remainders
    for (int i = 0; i < n; i++) {
        cin >> num[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> rem[i];
    }

    // Check if the system is solvable
    if (!isSolvable(num, rem)) {
        cout << "No solution" << endl;
        return 0;
    }

    // Solve the system of congruences using the Extended Chinese Remainder Theorem
    if (!extendedChineseRemainder(num, rem)) {
        cout << "No solution" << endl;
    } else {
        int result = chineseRemainder(num, rem);
        cout << result << endl;
    }

    return 0;
}




```
