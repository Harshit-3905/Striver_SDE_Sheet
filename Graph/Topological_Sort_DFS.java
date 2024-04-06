import java.util.*;

class Topological_Sort_DFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int ans[] = new int[V];
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i])
                continue;
            helper(i, vis, st, adj);
        }
        int ind = 0;
        while (!st.isEmpty())
            ans[ind++] = st.pop();
        return ans;
    }

    static void helper(int i, boolean vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        for (int x : adj.get(i)) {
            if (vis[x])
                continue;
            helper(x, vis, st, adj);
        }
        st.push(i);
    }
}
