class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n <= 1)
            return s;

        int[][] dp = new int[n][n];
        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }

        // Check for substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    if (length > maxLength) {
                        start = i;
                        maxLength = length;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
