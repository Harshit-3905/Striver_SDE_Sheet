import java.util.*;

class Power {

    // Binary Exponentiation
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int x = in.nextInt();
        // long ans = Recursive(n, x);
        long ans = Iterative(n, x);
        System.out.println(ans);
        in.close();
    }

    static long Recursive(long n, int x) {
        if (x == 1)
            return n;
        if (x % 2 != 0)
            return n * Recursive(n * n, x / 2);
        else
            return Recursive(n * n, x / 2);
    }

    // Time Complexity : O(log x)
    static long Iterative(long n, int x) {
        long ans = 1;
        while (x != 0) {
            if (x % 2 != 0)
                ans *= n;
            n *= n;
            x /= 2;
        }
        return ans;
    }
}