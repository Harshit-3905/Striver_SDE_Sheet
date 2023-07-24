import java.util.*;

class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (vis[i])
                continue;
            ans.add(i);
            vis[i] = true;
            dfs(vis, ans, i, adj);
        }
        return ans;
    }

    void dfs(boolean vis[], ArrayList<Integer> ans, int i, ArrayList<ArrayList<Integer>> adj) {
        for (int x : adj.get(i)) {
            if (vis[x])
                continue;
            ans.add(x);
            vis[x] = true;
            dfs(vis, ans, x, adj);
        }
    }
}