import java.util.*;

class Detect_Cycle_in_Undirected_Graph_Using_DFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i])
                continue;
            vis[i] = true;
            if (detectCycle(i, adj, vis, -1))
                return true;
        }
        return false;
    }

    boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj, boolean vis[], int parent) {
        boolean ans = false;
        for (int x : adj.get(V)) {
            if (!vis[x]) {
                vis[x] = true;
                ans |= detectCycle(x, adj, vis, V);
            } else if (parent != x)
                return true;
        }
        return ans;
    }
}

class Detect_Cycle_in_Undirected_Graph_Using_BFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i])
                continue;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(i, -1));
            vis[i] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    Pair p = q.poll();
                    for (int x : adj.get(p.vertex)) {
                        if (!vis[x]) {
                            vis[x] = true;
                            q.add(new Pair(x, p.vertex));
                        } else if (p.parent != x)
                            return true;
                    }
                }
            }
        }
        return false;
    }
}

class Pair {
    int vertex, parent;

    Pair(int a, int b) {
        vertex = a;
        parent = b;
    }
}