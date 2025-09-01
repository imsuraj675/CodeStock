def prefixSum(arr, n):
    res = [0] * n
    res[0] = arr[0]
    for i in range(1, n):
        res[i] = res[i - 1] + arr[i]
    return res

n = 5
arr = [1, 2, 3, 4, 5]
preSum = prefixSum(arr, n)
for i in range(n):
    print(preSum[i], end = " ")