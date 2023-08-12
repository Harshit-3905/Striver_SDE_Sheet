import java.util.*;

class Check_Bipartite_using_DFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (color[i] != 0)
                continue;
            color[i] = 1;
            if (dfs(adj, color, i) == false)
                return false;
        }
        return true;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> adj, int color[], int i) {
        for (int x : adj.get(i)) {
            if (color[x] == 0) {
                color[x] = color[i] == 1 ? 2 : 1;
                if (dfs(adj, color, x) == false)
                    return false;
            } else if (color[x] == color[i])
                return false;
        }
        return true;
    }
}