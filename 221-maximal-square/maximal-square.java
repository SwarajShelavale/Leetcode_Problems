class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length, m = matrix[0].length;

        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    continue;
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
            }
        }

        return maxArea;
    }
}
