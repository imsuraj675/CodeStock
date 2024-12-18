# Python Code Example

def dfs(adj, n):
    # Create a visited list to track visited nodes
    visited = [False] * n
    stack = []
    dfs_order = []

    # Start DFS from node 0 (or any other node)
    stack.append(0)
    visited[0] = True

    while stack:
        node = stack.pop()

        # Add the current node to the DFS order
        dfs_order.append(node)

        # Explore all neighbors of the current node
        for neighbor in adj[node]:
            if not visited[neighbor]:
                visited[neighbor] = True
                stack.append(neighbor)

    return dfs_order


def func_body():
    # Define the graph as an adjacency list
    n = 5  # Number of nodes
    adj = [[] for _ in range(n)]

    # Adding edges (undirected graph)
    adj[0].append(1)
    adj[0].append(2)
    adj[1].append(0)
    adj[2].append(0)
    adj[2].append(3)
    adj[3].append(2)
    adj[3].append(4)
    adj[4].append(3)

    # Call the DFS function and get the DFS order
    dfs_order = dfs(adj, n)

    # Print the DFS order
    print("DFS Order:", " ".join(map(str, dfs_order)))


if __name__ == "__main__":
    # Main function where the function is called and use case is demonstrated
    func_body()
