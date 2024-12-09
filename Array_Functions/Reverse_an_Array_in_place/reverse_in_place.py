def reverse_in_place(arr):
    n = len(arr)
    for i in range(n // 2):
        temp = arr[i]
        arr[i] = arr[n-1-i]
        arr[n-1-i] = temp
    return

if __name__ == "__main__":
    arr = [1, 2, 3]
    reverse_in_place(arr)
    for num in arr:
        print(num, end=" ")
    print()

# You can also use reversed() built-in function
