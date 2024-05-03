import java.util.ArrayList;

class Detect_Cycle_in_Directed_Graph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!vis[i] && isCyclic(i, adj, vis, path))
                return true;
        return false;
    }

    public boolean isCyclic(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] path) {
        if (vis[node] && path[node])
            return true;
        if (vis[node])
            return false;
        vis[node] = true;
        path[node] = true;
        for (int i : adj.get(node)) {
            if (isCyclic(i, adj, vis, path))
                return true;
        }
        path[node] = false;
        return false;
    }
}