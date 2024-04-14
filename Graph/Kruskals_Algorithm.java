import java.util.*;

class Kruskals_Algorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        DisjointSet ds = new DisjointSet(V);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        for (int i = 0; i < adj.size(); i++) {
            List<int[]> list = adj.get(i);
            for (int x[] : list) {
                pq.add(new Edge(x[1], i, x[0]));
            }
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            Edge p = pq.poll();
            if (!ds.isSameSet(p.u, p.v)) {
                ans += p.wt;
                ds.unionBySize(p.u, p.v);
            }
        }
        return ans;
    }
}

class Edge {
    int wt, u, v;

    Edge(int a, int b, int c) {
        wt = a;
        u = b;
        v = c;
    }
}

class DisjointSet {
    int parent[], size[], n;

    DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUParent(int x) {
        if (parent[x] != x) {
            parent[x] = findUParent(parent[x]);
        }
        return parent[x];
    }

    void unionBySize(int x, int y) {
        int xParent = findUParent(x);
        int yParent = findUParent(y);
        if (xParent == yParent) {
            return;
        }
        if (size[xParent] < size[yParent]) {
            parent[xParent] = yParent;
            size[yParent] += size[xParent];
        } else {
            parent[yParent] = xParent;
            size[xParent] += size[yParent];
        }
    }

    boolean isSameSet(int x, int y) {
        return findUParent(x) == findUParent(y);
    }

}