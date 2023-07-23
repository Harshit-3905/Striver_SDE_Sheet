import java.util.*;

class K_Frequent_Elements {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        int ans[] = Solution(a, k);
        for (int x : ans)
            System.out.print(x + " ");
        in.close();
    }

    static int[] Solution(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.x - a.x);
        for (Map.Entry<Integer, Integer> s : map.entrySet()) {
            pq.add(new Pair(s.getValue(), s.getKey()));
        }
        int ans[] = new int[k];
        int j = 0;
        while (k-- > 0) {
            ans[j] = pq.poll().y;
            j++;
        }
        return ans;
    }
}

class Pair {
    int x;
    int y;

    Pair(int a, int b) {
        x = a;
        y = b;
    }
}