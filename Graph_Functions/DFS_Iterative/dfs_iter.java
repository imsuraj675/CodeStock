package DFS_Iterative;
import java.util.*;

public class dfs_iter {

    // Iterative DFS function that takes the adjacency list and an empty container
    public static void dfs(List<List<Integer>> adj, List<Integer> dfsOrder) {
        int n = adj.size();
        
        // Create a visited array to track which nodes have been visited
        boolean[] visited = new boolean[n];
        
        // Stack for iterative DFS
        Stack<Integer> stack = new Stack<>();
        
        // Let's start DFS from node 0 (or any other node)
        stack.push(0);
        visited[0] = true;
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            // Add the current node to the DFS order
            dfsOrder.add(node);
            
            // Explore all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    // Main function where the DFS function is called and use case is demonstrated
    public static void func_body() {
        // Define the graph as an adjacency list
        int n = 5;  // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Adding edges (undirected graph)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        
        // Container to store the DFS order
        List<Integer> dfsOrder = new ArrayList<>();
        
        // Call the DFS function
        dfs(adj, dfsOrder);
        
        // Print the DFS order
        System.out.print("DFS Order: ");
        for (int node : dfsOrder) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Main function where the DFS function is called
        func_body();
    }
}
