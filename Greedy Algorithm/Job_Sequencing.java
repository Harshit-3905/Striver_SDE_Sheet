import java.util.*;

class Job_Sequencing {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Job a[] = new Job[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            a[i] = new Job(x, y, z);
        }
        Arrays.sort(a, (x, y) -> x.profit == y.profit ? x.deadline - y.deadline : y.profit - x.profit);
        HashSet<Integer> deadline = new HashSet<>();
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int p = a[i].profit;
            int d = a[i].deadline;
            for (int j = d; j >= 1; j--) {
                if (!deadline.contains(j)) {
                    ans += p;
                    count++;
                    deadline.add(j);
                    break;
                }
            }
        }
        System.out.println(count + " " + ans);
        in.close();
    }
}

class Job {
    int id;
    int deadline;
    int profit;

    Job(int x, int y, int z) {
        id = x;
        deadline = y;
        profit = z;
    }
}