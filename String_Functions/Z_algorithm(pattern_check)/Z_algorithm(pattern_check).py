def zfunction(text, pattern):
    # Create concatenated string "P$T"
    concat = pattern + "$" + text
    n = len(concat)

    # Z-array to store lengths of the longest prefix substring starting from each position
    Z = [0] * n
    l, r = 0, 0

    for i in range(1, n):
        if i <= r:
            Z[i] = min(r - i + 1, Z[i - l])
        while i + Z[i] < n and concat[Z[i]] == concat[i + Z[i]]:
            Z[i] += 1
        if i + Z[i] - 1 > r:
            l = i
            r = i + Z[i] - 1

    # Search for the pattern in the text using the Z-array
    for i in range(n):
        if Z[i] == len(pattern):
            print(f"Pattern found at index {i - len(pattern) - 1}")

if __name__ == "__main__":
    givenstring = "WORLD PEACE"
    pattern = "PEACE"

    # Perform pattern search using Z algorithm
    zfunction(givenstring, pattern)

