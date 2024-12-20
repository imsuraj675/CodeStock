from math import gcd, log2, floor
from functools import reduce

class SparseTable:
    def __init__(self, arr, func_name):
        self.func_name = func_name.lower()
        self.n = len(arr)
        self.bin_log = [0] * (self.n + 1)
        self.lookup = []
        self._precompute_logs()
        self._build(arr)

    def _precompute_logs(self):
        for i in range(2, self.n + 1):
            self.bin_log[i] = self.bin_log[i // 2] + 1

    def _operation(self, x, y):
        if self.func_name == "min":
            return min(x, y)
        if self.func_name == "max":
            return max(x, y)
        if self.func_name == "gcd":
            return gcd(x, y)
        if self.func_name == "lcm":
            return abs(x * y) // gcd(x, y)
        if self.func_name == "and":
            return x & y
        if self.func_name == "or":
            return x | y
        raise ValueError(f"Unsupported function name: {self.func_name}")

    def _build(self, arr):
        max_log = self.bin_log[self.n]
        self.lookup = [[0] * (max_log + 1) for _ in range(self.n)]

        for i in range(self.n):
            self.lookup[i][0] = arr[i]

        for k in range(1, max_log + 1):
            for i in range(self.n - (1 << k) + 1):
                self.lookup[i][k] = self._operation(
                    self.lookup[i][k - 1],
                    self.lookup[i + (1 << (k - 1))][k - 1]
                )

    def query(self, L, R):
        k = self.bin_log[R - L + 1]
        return self._operation(self.lookup[L][k], self.lookup[R - (1 << k) + 1][k])


# Example Usage
n = int(input())
arr = list(map(int, input().split()))
func_name = input().strip()
st = SparseTable(arr, func_name)

q = int(input())
for _ in range(q):
    L, R = map(int, input().split())
    print(st.query(L, R))
