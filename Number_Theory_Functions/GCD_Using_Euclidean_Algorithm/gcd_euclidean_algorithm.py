def gcd(a, b):
    if a == 0 and b == 0:
        return 0
    if a == 0:
        return b
    if b == 0:
        return a

    if (a<0) a = -a
    if (b<0) b = -b
    
    while b != 0:
        a, b = b, a % b
    return a

if __name__ == "__main__":
    a = 111
    b = 37

    ans = gcd(a, b)
    print(ans)
