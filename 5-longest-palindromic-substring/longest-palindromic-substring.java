class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n <= 1)
            return s;

        int dp[][] = new int[n][n];
        int maxLength=0;
        String lps = "";

        for(int length = 1;length<=n;length++)
        {
            for(int i=0,j=i+length-1;j<n;i++,j++)
            {
                if(length==1)
                    dp[i][j]=1;
                else if(length==2)
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) ? 2:0;
                else 
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]!=0)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                }

                if(dp[i][j] >  0 && j-i+1> maxLength )
                {
                    maxLength = j-i+1;
                    lps = s.substring(i,j+1);
                }

            }
        }

        return lps;
    }
}