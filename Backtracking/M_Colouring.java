import java.util.*;

class M_Colouring {
    public boolean isSafe(boolean graph[], int fill, int[] color) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == true && color[i] == fill)
                return false;
        }
        return true;
    }

    public boolean fillColorNodes(int curr, boolean graph[][], int m, int n, int[] color) {
        if (curr == n)
            return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(graph[curr], i, color)) {
                color[curr] = i;
                if (fillColorNodes(curr + 1, graph, m, n, color))
                    return true;
                color[curr] = 0;
            }
        }
        return false;
    }

    public boolean graphColoring(boolean graph[][], int m, int n) {
        int color[] = new int[n];
        Arrays.fill(color, 0);
        if (fillColorNodes(0, graph, m, n, color))
            return true;

        return false;
    }
}