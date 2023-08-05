class Search_in_2D_matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m - 1;
        int row = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                row = mid;
                break;
            } else if (matrix[mid][0] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}