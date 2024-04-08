import java.util.*;

class Bellman_Ford_Algorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dist[] = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;
        int n = edges.size();
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < n; j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);
                if (dist[u] != (1e8) && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }
        for (ArrayList<Integer> adj : edges) {
            int node = adj.get(0);
            int adjnode = adj.get(1);
            int weight = adj.get(2);
            if (dist[node] != (1e8) && dist[node] + weight < dist[adjnode]) {
                int temp[] = { -1 };
                return temp;
            }
        }
        return dist;
    }
}