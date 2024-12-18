#include <bits/stdc++.h>
using namespace std;

// Iterative DFS function that takes the adjacency list and an empty container
void dfs(const vector<vector<int>>& adj, vector<int>& dfs_order) {
    int n = adj.size();
    
    // Create a visited vector to track which nodes have been visited
    vector<bool> visited(n, false);
    
    // Stack for the iterative DFS
    stack<int> st;
    
    // Let's start DFS from node 0 (or any other node)
    st.push(0);
    visited[0] = true;
    
    while (!st.empty()) {
        int node = st.top();
        st.pop();
        
        // Add the current node to the DFS order
        dfs_order.push_back(node);
        
        // Explore all neighbors of the current node
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                st.push(neighbor);
            }
        }
    }
}

int main() {
    // Define the graph as an adjacency list
    int n = 5;  // Number of nodes
    vector<vector<int>> adj(n);
    
    // Adding edges (undirected graph)
    adj[0].push_back(1);
    adj[0].push_back(2);
    adj[1].push_back(0);
    adj[2].push_back(0);
    adj[2].push_back(3);
    adj[3].push_back(2);
    adj[3].push_back(4);
    adj[4].push_back(3);
    
    // Container to store the DFS order
    vector<int> dfs_order;
    
    // Call the DFS function
    dfs(adj, dfs_order);
    
    // Print the DFS order
    cout << "DFS Order: ";
    for (int node : dfs_order) {
        cout << node << " ";
    }
    cout << endl;
    
    return 0;
}
