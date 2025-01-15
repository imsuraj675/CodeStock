def factorial(n, p):
    res = [1] * (n + 1)
    for i in range(1, n + 1):
        res[i] = (res[i - 1] * i) % p
    return res

if __name__ == "__main__":
    n, p = 25, 29
    res = factorial(n, p)
    
    print(" ".join(map(str, res)))
