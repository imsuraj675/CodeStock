def generate_permutations(arr):
    permutations = []
    arr.sort()
    permutations.append(arr[:])

    while True:
        i = len(arr) - 2
        while i >= 0 and arr[i] >= arr[i + 1]:
            i -= 1
        if i < 0:
            break
        j = len(arr) - 1
        while arr[j] <= arr[i]:
            j -= 1

        arr[i], arr[j] = arr[j], arr[i]
        arr = arr[:i + 1] + arr[i + 1:][::-1]
        permutations.append(arr[:])

    return permutations

if __name__ == "__main__":
    arr = ['a', 'b', 'c', 'd']
    permutations = generate_permutations(arr)

    for perm in permutations:
        print(" ".join(map(str, perm)))
