def modular_exponentiation(a, b, M):
    if M <= 0:
        return -1  # Invalid modulus
    if M == 1:
        return 0  # Modulus 1 case, result is always 0 as every number is divisible by 1
    if a == 0 and b < 0:
        return -1  # 0 raised to a negative power is undefined

    a %= M  # Reduce 'a' modulo M
    result = 1

    # Handle negative exponent using modular inverse
    if b < 0:
        b = -b  # Convert exponent to positive
        inverse = 1
        base = a
        power = M - 2
        # For this case, M must be a prime
        # Compute modular inverse using Fermat's Little Theorem (a^(M-2) mod M)
        while power > 0:
            if power & 1:
                inverse = (inverse * base) % M
            base = (base * base) % M
            power >>= 1
        a = inverse  # Replace base 'a' with its modular inverse

    # Standard binary exponentiation
    while b > 0:
        if b & 1:
            result = (result * a) % M
        a = (a * a) % M
        b >>= 1

    return result


MOD = int(1e9 + 7)  # Taking it as default mod
# It is a prime number and this works only when M is prime in case of negative exponents

# Negative Exponent
print("a = 2, b = -3, M = 1e9+7:", modular_exponentiation(2, -3, MOD))

# Undefined: 0^-3
print("a = 0, b = -3, M = 1e9+7:", modular_exponentiation(0, -3, MOD))

# Large Negative Exponent
print("a = 3, b = -1000000, M = 1e9+7:", modular_exponentiation(3, -1000000, MOD))

