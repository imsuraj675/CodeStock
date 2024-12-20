# Sparse Table

**What is it?**  
The Sparse Table is an efficient data structure used to answer range queries on an array. It works for queries that involve calculating functions like the minimum, maximum, greatest common divisor (GCD), least common multiple (LCM), bitwise AND, and bitwise OR over a given range of elements in an array.

---

## Features

- Supports the following operations:
  - `min` (find the minimum value)
  - `max` (find the maximum value)
  - `gcd` (find the greatest common divisor)
  - `lcm` (find the least common multiple)
  - `and` (bitwise AND)
  - `or` (bitwise OR)
- After preprocessing, each query can be answered in constant time.

---

## Why is Sparse Table More Efficient?

### Brute Force vs Sparse Table

- **Brute Force Approach**:  
  If we want to find the minimum, maximum, or other operations over a range of values in an array using a brute force approach, we would need to go through each element of the range every time we make a query. This leads to a time complexity of **O(R - L + 1)** per query, where `L` and `R` are the start and end indices of the range.

- **Sparse Table Approach**:  
  The Sparse Table preprocesses the array in **O(n log n)** time, storing results for overlapping ranges in a table. After this setup, each query is answered in **O(1)** time. This is much more efficient when there are multiple queries since the preprocessing is done once, and queries are answered instantly.

### Example:
Suppose you want to perform `k` queries on an array of size `n`:
- **Brute Force**: Time complexity for each query is O(R - L + 1). For `k` queries, the time complexity is O(k * (R - L + 1)).
- **Sparse Table**: The preprocessing time is O(n log n), and each query takes O(1) time. So for `k` queries, the time complexity is O(n log n + k), which is much faster if `k` is large.

---

## How to Use

### Input
1. **Array of numbers**: The list of numbers you want to perform operations on.
2. **Operation**: The operation you want to perform on the array (`min`, `max`, `gcd`, `lcm`, `and`, `or`).
3. **Queries**: A list of ranges (L, R) that you want to perform the operation on.

### Output
For each query, it returns the result of the operation for the range `[L, R]`.

---

### Example

#### Input:
```plaintext
Array: [7, 8, 9, 4, 5, 6, 7, 4, 1]
Operation: min
Queries: (0, 4), (4, 7), (7, 8)
```
#### Output: 
```plaintext
Function: min
Query (0, 4) -> 4
Query (4, 7) -> 4
Query (7, 8) -> 1
```
---

## Complexity :

### Time Complexity : 

- **Build Function**:
  - The preprocessing step (building the sparse table) requires iterating through the array to fill the table, which takes **O(n log n)** time, where `n` is the size of the array.
  
- **Query Function**:
  - Each query can be answered in constant time, **O(1)**, after the preprocessing step. This is because we can directly access precomputed values from the table.

- **Overall Time Complexity**:
  - **Preprocessing Time**: O(n log n)
  - **Query Time**: O(1) per query

### Space Complexity:
  - The space complexity is **O(n log n)** because we store the precomputed results in the lookup table.
