import java.util.*;

class Prims_Algorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean vis[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(0, 0));
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (vis[p.v])
                continue;
            ans += p.wt;
            vis[p.v] = true;
            for (int[] x : adj.get(p.v)) {
                if (vis[x[0]])
                    continue;
                pq.add(new Pair(x[1], x[0]));
            }
        }
        return ans;
    }
}

class Pair {
    int wt, v;

    Pair(int a, int c) {
        wt = a;
        v = c;
    }
}