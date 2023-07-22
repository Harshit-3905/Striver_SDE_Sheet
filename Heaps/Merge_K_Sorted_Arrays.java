import java.util.*;

class Merge_K_Sorted_Arrays {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        // int a[][] = new int[n][m];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // a[i][j] = in.nextInt();
        // }
        // }
        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(in.nextInt());
            }
            b.add(list);
        }
        int ans[] = new int[n * m];
        // ans = Solution1(a, n, m);
        ans = Solution2(b, n, m);
        for (int x : ans)
            System.out.print(x + " ");
        in.close();
    }

    static int[] Solution1(int a[][], int n, int m) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(a[i][j]);
            }
        }
        int x = 0;
        int ans[] = new int[n * m];
        while (!pq.isEmpty()) {
            ans[x++] = pq.poll();
        }
        return ans;
    }

    static int[] Solution2(ArrayList<ArrayList<Integer>> b, int n, int m) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.x - y.x);
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(b.get(i).get(0), 0, i));
        }
        int ans[] = new int[n * m];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans[i++] = p.x;
            if (p.y + 1 < b.get(p.z).size()) {
                pq.add(new Pair(b.get(p.z).get(p.y + 1), p.y + 1, p.z));
            }
        }
        return ans;
    }
}

class Pair {
    int x;
    int y;
    int z;

    Pair(int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }
}