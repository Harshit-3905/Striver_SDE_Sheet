import java.util.*;

class Check_Bipartite_using_BFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (color[i] != 0)
                continue;
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()) {
                int y = q.poll();
                for (int g : adj.get(y)) {
                    if (color[g] == 0) {
                        color[g] = color[y] == 1 ? 2 : 1;
                        q.add(g);
                    } else {
                        if (color[y] == color[g])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
