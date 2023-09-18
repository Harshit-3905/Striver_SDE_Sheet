import java.util.*;

class Majority_Element_II {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        // List<Integer> ans = Solution1(n, a);
        // List<Integer> ans = Solution2(n, a);
        List<Integer> ans = Solution3(n, a);
        for (int x : ans)
            System.out.print(x + " ");
        in.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static List<Integer> Solution1(int n, int a[]) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue() > n / 3) {
                ans.add(x.getKey());
            }
        }
        return ans;
    }

    // Time Complexity : O(nlogn)
    static List<Integer> Solution2(int n, int a[]) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(a);
        int count = 1;
        int x = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] == x)
                count++;
            else {
                if (count > n / 3)
                    ans.add(x);
                x = a[i];
                count = 1;
            }
        }
        if (count > n / 3)
            ans.add(x);
        return ans;
    }

    // Time Complexity : O(nlogn)
    static List<Integer> Solution3(int n, int a[]) {
        List<Integer> ans = new ArrayList<>();
        int c1 = 0, c2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (c1 == 0 && a[i] != el2) {
                el1 = a[i];
                c1 = 1;
            } else if (c2 == 0 && a[i] != el1) {
                el2 = a[i];
                c2 = 1;
            } else if (a[i] == el1)
                c1++;
            else if (a[i] == el2)
                c2++;
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int x : a) {
            if (x == el1)
                c1++;
            else if (x == el2)
                c2++;
        }
        if (c1 > n / 3)
            ans.add(el1);
        if (c2 > n / 3)
            ans.add(el2);
        return ans;
    }
}