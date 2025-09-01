def generate_permutations(arr, l, r, result):
    if l == r:
        result.append(arr[:])
    else:
        for i in range(l, r + 1):
            arr[l], arr[i] = arr[i], arr[l]
            generate_permutations(arr, l + 1, r, result)
            arr[l], arr[i] = arr[i], arr[l]

def get_permutations(arr):
    result = []
    generate_permutations(arr, 0, len(arr) - 1, result)
    return result

if __name__ == "__main__":
    arr = ['a', 'b', 'c']
    permutations = get_permutations(arr)

    for perm in permutations:
        print(" ".join(map(str, perm)))
