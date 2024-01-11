class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        
        StringBuilder str = new StringBuilder(s).reverse();
        String p = str.toString();

        int dp[][] = new int[n+1][n+1];

        int maxLps = 0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1))
                {
                   dp[i][j]=1+dp[i-1][j-1];
                   maxLps=Math.max(maxLps,dp[i][j]);
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return maxLps;

    }
}