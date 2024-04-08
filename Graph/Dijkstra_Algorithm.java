import java.util.*;

class Dijkstra_Algorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int ans[] = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.x == b.x) ? a.y - b.y : a.x - b.x);
        ans[S] = 0;
        pq.add(new Pair(0, S));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (ArrayList<Integer> edge : adj.get(p.y)) {
                if (edge.get(1) + p.x < ans[edge.get(0)]) {
                    ans[edge.get(0)] = edge.get(1) + p.x;
                    pq.add(new Pair(ans[edge.get(0)], edge.get(0)));
                }
            }
        }
        return ans;
    }
}

class Pair {
    int x, y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }
}
