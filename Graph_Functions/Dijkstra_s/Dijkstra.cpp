#include <bits/stdc++.h>
using namespace std;

vector <int> dijkstra(int V, vector<vector<pair<int, int>>> graph, int S) {

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq; 
    vector<int> dist(V, 1e9); 
    
    pq.push({0, S}); 
    dist[S] = 0;
    while(!pq.empty()) {
        auto it = pq.top();
        pq.pop();
        int node = it.second; 
        int dis = it.first; 
        
        for(auto it : graph[node]) {
            int adjNode = it.first; 
            int edgW = it.second;
            
            if(edgW < 0)    continue;

            if(dis + edgW < dist[adjNode]) {
                dist[adjNode] = dis + edgW; 
                pq.push({dist[adjNode], adjNode}); 
            }
        }
    }
    return dist; 
}

int main() {
    int V = 4, S = 2;
    vector<vector<pair<int, int>>> graph(V);

    graph[0].push_back({1, 1});
    graph[0].push_back({2, 6});
    graph[1].push_back({2, 3});
    graph[1].push_back({0, 1});
    graph[2].push_back({1, 3});
    graph[2].push_back({0, 6});

    vector<int> res = dijkstra(V, graph, S);

    for(int i=0;i<V;i++) {
        cout<<"Shortest distance from "<<S<<" to "<<i<<" is: ";
        if(res[i] == 1e9)   cout<<"INF";
        else    cout<<res[i];
        cout<<endl;
    }

    return 0;
}