import java.util.*;

class Check_Anagram {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        if (checkAnagram(s1, s2))
            System.out.println("YES");
        else
            System.out.println("NO");
        in.close();
    }

    // Time Complexity : O(|s1|+|s2|)
    static boolean checkAnagram(String s1, String s2) {
        int a[] = new int[26];
        for (int i = 0; i < s1.length(); i++)
            a[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++)
            a[s2.charAt(i) - 'a']--;
        for (int x : a)
            if (x != 0)
                return false;
        return true;
    }
}