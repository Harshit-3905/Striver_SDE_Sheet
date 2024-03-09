class Celebrity_Problem {
    int celebrity(int M[][], int n) {
        int ans = -1;
        for (int j = 0; j < n; j++) {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < n; i++) {
                if (M[j][i] == 0) {
                    count1++;
                }
                if (M[i][j] == 1) {
                    count2++;
                }
            }
            if (count1 == n && count2 == n - 1)
                ans = j;
        }
        return ans;
    }
}