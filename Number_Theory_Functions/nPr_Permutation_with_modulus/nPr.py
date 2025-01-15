M = int(1e9 + 7)  # Modulus value

# Function to precompute factorial modulo M
def precompute_factorials(n, M):
    fact = [1] * (n + 1)
    for i in range(2, n + 1):
        fact[i] = (fact[i - 1] * i) % M
    return fact

# Function to compute modular exponentiation
def mod_exp(base, exp, mod):
    result = 1
    while exp > 0:
        if exp % 2 == 1:  # If exp is odd
            result = (result * base) % mod
        base = (base * base) % mod
        exp //= 2
    return result

# Function to compute modular inverse 
def mod_inverse(a, M):
    return mod_exp(a, M - 2, M)  # a^(M-2) mod M

# Function to compute nPr modulo M
def nPr(n, r, fact, M):
    if r > n:
        return 0  # nPr is 0 if r > n
    numerator = fact[n]  # n!
    denominator = fact[n - r]  # (n - r)!
    return (numerator * mod_inverse(denominator, M)) % M

# Main
if __name__ == "__main__":
    n, r = 10, 3

    # Precompute factorials up to n modulo M
    fact = precompute_factorials(n, M)

    # Compute nPr modulo M
    print(f"nPr({n}, {r}) mod {M} = {nPr(n, r, fact, M)}")
