# Iterative Depth-First Search (DFS) Algorithm

## Overview

Depth-First Search (DFS) is a graph traversal algorithm that explores as far as possible along each branch before backtracking. It is commonly implemented recursively, but here we will discuss an **iterative approach** using a **stack** to simulate recursion.

This version of the DFS will start from a given node (usually node 0) and explore all its neighbors before moving on to the next unvisited neighbor. If all neighbors are visited, it backtracks using the stack.

## Steps of the Algorithm

1. **Initialize**:
   - A stack to simulate recursion.
   - A `visited` list to track the nodes that have been visited.
   - An empty list to store the DFS traversal order.

2. **Start DFS**:
   - Push the starting node (usually `0`) onto the stack.
   - Mark it as visited.

3. **Explore**:
   - Pop a node from the stack and visit it.
   - Push all unvisited neighbors of the current node onto the stack and mark them as visited.

4. **Repeat**:
   - Continue popping nodes from the stack and visiting unvisited neighbors until the stack is empty.

5. **End**:
   - Once the stack is empty, the DFS traversal is complete.

## Example Graph

Consider the following graph:

0 -- 1
|
2 -- 3 -- 4

- Node `0` is connected to nodes `1` and `2`.
- Node `1` is connected to node `0`.
- Node `2` is connected to nodes `0` and `3`.
- Node `3` is connected to nodes `2` and `4`.
- Node `4` is connected to node `3`.

The graph can be represented as an adjacency list:
```python
adj = [
    [1, 2],  # Neighbors of 0
    [0],      # Neighbors of 1
    [0, 3],   # Neighbors of 2
    [2, 4],   # Neighbors of 3
    [3]       # Neighbors of 4
]
# DFS Traversal

## Iterative DFS Process:

1. **Start at node 0**:
   - Push 0 onto the stack: `stack = [0]`
   - Mark 0 as visited.
   - Pop 0 and visit it.

2. **Visit neighbors of node 0**:
   - The neighbors of 0 are `1` and `2`.
   - Push 2 and 1 onto the stack: `stack = [2, 1]`
   - Mark both 1 and 2 as visited.

3. **Visit node 1**:
   - Pop 1 from the stack: `stack = [2]`
   - Visit 1. The only unvisited neighbor is 0, which is already visited.

4. **Visit node 2**:
   - Pop 2 from the stack: `stack = []`
   - Visit 2. The neighbors of 2 are 0 and 3.
   - Push 3 onto the stack: `stack = [3]`
   - Mark 3 as visited.

5. **Visit node 3**:
   - Pop 3 from the stack: `stack = []`
   - Visit 3. The neighbors of 3 are 2 and 4.
   - Push 4 onto the stack: `stack = [4]`
   - Mark 4 as visited.

6. **Visit node 4**:
   - Pop 4 from the stack: `stack = []`
   - Visit 4. The only neighbor is 3, which is already visited.

7. The stack is now empty, and the traversal is complete.

## DFS Order:
The order in which nodes are visited is: `0, 2, 3, 4, 1`.

## Time Complexity
- **Time Complexity**: O(V + E), where V is the number of vertices (nodes) and E is the number of edges. We visit each node once and explore all its edges.
- **Space Complexity**: O(V), as we store the visited list and use the stack to store nodes during traversal.
