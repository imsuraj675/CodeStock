import java.util.*;

public class Dijkstra {

    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static List<Integer> dijkstra(int V, List<List<Pair>> graph, int S) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        List<Integer> dist = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));

        pq.add(new Pair(S, 0));
        dist.set(S, 0);

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int dis = current.weight;

            for (Pair neighbor : graph.get(node)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (edgeWeight < 0) continue;

                if (dis + edgeWeight < dist.get(adjNode)) {
                    dist.set(adjNode, dis + edgeWeight);
                    pq.add(new Pair(adjNode, dist.get(adjNode)));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 4, S = 2;
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1, 1));
        graph.get(0).add(new Pair(2, 6));
        graph.get(1).add(new Pair(2, 3));
        graph.get(1).add(new Pair(0, 1));
        graph.get(2).add(new Pair(1, 3));
        graph.get(2).add(new Pair(0, 6));

        List<Integer> res = dijkstra(V, graph, S);

        for (int i = 0; i < V; i++) {
            System.out.print("Shortest distance from " + S + " to " + i + " is: ");
            if (res.get(i) == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(res.get(i));
            }
        }
    }
}
