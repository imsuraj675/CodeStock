from typing import List

# Function to find the smallest x such that:
# x % num[i] = rem[i] for all i in [0, k-1]
def chinese_remainder(num: List[int], rem: List[int]) -> int:
    prod = 1

    # Compute the product of all numbers in num (product of all moduli)
    for n in num:
        prod *= n

    # Function to compute the modular inverse of a under modulo m
    def mod_inverse(a: int, m: int) -> int:
        m0, t, q = m, 0, 0
        x0, x1 = 0, 1

        # Apply the Extended Euclidean Algorithm
        while a > 1:
            # q is the quotient
            q = a // m
            t = m
            # Update m and a (remainder and divisor)
            m = a % m
            a = t
            t = x0
            # Update coefficients
            x0 = x1 - q * x0
            x1 = t

        # Make x1 positive if it is negative
        if x1 < 0:
            x1 += m0

        return x1

    result = 0

    # Loop through each congruence
    for i in range(len(num)):
        pp = prod // num[i]  # Partial product excluding num[i]
        # Add the contribution of the current remainder to the result
        result += rem[i] * mod_inverse(pp, num[i]) * pp

    # Return the result modulo the product of all moduli
    return result % prod

# Example usage
num = [3, 4, 5]  # Moduli
rem = [2, 3, 1]  # Remainders

# Solve the system of congruences using the Chinese Remainder Theorem
result = chinese_remainder(num, rem)

# Output the result
print("The solution is", result)

