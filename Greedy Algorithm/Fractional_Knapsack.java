import java.util.*;

class Fractional_Knapsack {

    // Time Complexity : O(nlog n)
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        Item a[] = new Item[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            a[i] = new Item(x, y);
        }
        Arrays.sort(a, (x, y) -> (y.amt * x.wt) - (x.amt * y.wt));
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            if (a[i].wt <= w) {
                ans += a[i].amt;
                w -= a[i].wt;
            } else {
                ans += (w / (a[i].wt * 1.0)) * a[i].amt;
                break;
            }
        }
        System.out.println(ans);
        in.close();
    }
}

class Item {
    int wt;
    int amt;

    Item(int a, int b) {
        wt = a;
        amt = b;
    }
}