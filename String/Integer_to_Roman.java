import java.util.*;

class Integer_to_Roman {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ans1 = Solution1(n);
        String ans2 = Solution2(n);
        System.out.println(ans1);
        in.close();
    }

    static String Solution1(int num) {
        StringBuilder ans = new StringBuilder();
        while (num >= 1000) {
            ans.append('M');
            num -= 1000;
        }
        while (num >= 900) {
            ans.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            ans.append('D');
            num -= 500;
        }
        while (num >= 400) {
            ans.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            ans.append('C');
            num -= 100;
        }
        while (num >= 90) {
            ans.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            ans.append("L");
            num -= 50;
        }
        while (num >= 40) {
            ans.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            ans.append("X");
            num -= 10;
        }
        while (num >= 9) {
            ans.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            ans.append("V");
            num -= 5;
        }
        while (num >= 4) {
            ans.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            ans.append("I");
            num -= 1;
        }
        return ans.toString();
    }

    static String Solution2(int num) {
        StringBuilder ans = new StringBuilder();
        String[] str = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] arr = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        for (int i = 0; i < 13; i++) {
            while (num >= arr[i]) {
                num -= arr[i];
                ans.append(str[i]);
            }
        }
        return ans.toString();
    }
}