import java.util.*;

class Topological_Sort_BFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int ans[] = new int[V];
        int indegree[] = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (int x : list) {
                indegree[x]++;
            }
        }
        int ind = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int p = q.poll();
            ans[ind++] = p;
            for (int x : adj.get(p)) {
                indegree[x]--;
                if (indegree[x] == 0)
                    q.add(x);
            }
        }
        return ans;
    }
}
