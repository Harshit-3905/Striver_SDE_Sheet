import java.util.*;

class Kth_Largest_Element_in_a_Stream {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        KthLargest ob = new KthLargest(k, nums);
        int m = in.nextInt();
        while (m-- > 0) {
            int x = in.nextInt();
            System.out.println(ob.add(x));
        }
        in.close();
    }
}

class KthLargest {

    PriorityQueue<Integer> pq;
    int c;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        c = k;
        for (int x : nums)
            pq.add(x);
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size() > c)
            pq.remove();
        return pq.peek();
    }
}