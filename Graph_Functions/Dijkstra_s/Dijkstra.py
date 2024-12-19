import heapq

def dijkstra(V, graph, S):

    dist = [float('inf')] * V
    dist[S] = 0
    pq = [(0, S)]

    while pq:
        dis, node = heapq.heappop(pq)

        if dis > dist[node]:
            continue

        for adj_node, edge_weight in graph[node]:
            if edge_weight < 0:
                continue
            if dis + edge_weight < dist[adj_node]:
                dist[adj_node] = dis + edge_weight
                heapq.heappush(pq, (dist[adj_node], adj_node))

    return dist

if __name__ == "__main__":
    V = 4
    S = 2
    graph = [[] for _ in range(V)]

    graph[0].append((1, -1))
    graph[0].append((2, 6))
    graph[1].append((2, 3))
    graph[1].append((0, -1))
    graph[2].append((1, 3))
    graph[2].append((0, 6))

    res = dijkstra(V, graph, S)

    for i in range(V):
        print(f"Shortest distance from {S} to {i} is: ", end="")
        if res[i] == float('inf'):
            print("INF")
        else:
            print(res[i])