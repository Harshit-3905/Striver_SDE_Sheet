import java.util.*;

class Maximum_Sum_Combination {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int b[] = new int[n];
        for (int i = 0; i < n; i++)
            b[i] = in.nextInt();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        // ans = Brute_Force(n, k, a, b);
        ans = Optimised(n, k, a, b);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        in.close();
    }

    static ArrayList<Integer> Brute_Force(int n, int k, int a[], int b[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = a[i] + b[j];
                pq.add(sum);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    static ArrayList<Integer> Optimised(int n, int k, int a[], int b[]) {
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            B.add(b[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0])
                return y[1] - x[0];
            return y[0] - x[0];
        });
        for (int i = 0; i < k; i++) {
            pq.add(new int[] { A.get(i) + B.get(0), 0 });
        }
        while (!pq.isEmpty() && k-- > 0) {
            int sum = pq.peek()[0];
            int index = pq.peek()[1];
            pq.poll();
            arr.add(sum);
            if (index + 1 < B.size()) {
                pq.add(new int[] { sum - B.get(index) + B.get(index + 1), index + 1 });
            }
        }
        return arr;
    }
}
