import java.util.*;

class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (vis[i])
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int x = q.poll();
                if (vis[x])
                    continue;
                ans.add(x);
                vis[x] = true;
                for (int y : adj.get(x))
                    q.add(y);
            }
        }
        return ans;
    }
}