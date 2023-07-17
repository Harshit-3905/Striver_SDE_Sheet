import java.util.*;

class Palindrome_Partitioning {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        Solution(s, 0, n, list, ans);
        for (List<String> y : ans) {
            for (String x : y)
                System.out.print(x + " ");
            System.out.println();
        }
        in.close();
    }

    static void Solution(String s, int i, int n, List<String> list, List<List<String>> ans) {
        if (i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        StringBuilder t = new StringBuilder();
        for (int j = i; j < n; j++) {
            t.append(s.charAt(j));
            if (isPalindrome(t)) {
                list.add(t.toString());
                Solution(s, j + 1, n, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean isPalindrome(StringBuilder s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}