import java.util.*;

class Compare_Version_Number {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String version1 = in.next();
        String version2 = in.next();
        System.out.println(Solution(version1, version2));
        in.close();
    }

    static int Solution(String version1, String version2) {
        String a[] = version1.split("\\.");
        String b[] = version2.split("\\.");
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int n = Integer.parseInt(a[i]);
            int m = Integer.parseInt(b[i]);
            i++;
            j++;
            if (n < m)
                return -1;
            else if (n > m)
                return 1;
        }
        while (i < a.length) {
            if (Integer.parseInt(a[i]) != 0)
                return 1;
            i++;
        }
        while (j < b.length) {
            if (Integer.parseInt(b[j]) != 0)
                return -1;
            j++;
        }
        return 0;
    }
}