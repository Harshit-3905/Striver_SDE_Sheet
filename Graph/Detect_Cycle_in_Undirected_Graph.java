import java.util.*;

class Detect_Cycle_in_Undirected_Graph {

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