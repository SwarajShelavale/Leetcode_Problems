class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
       
        return editDistance(n,m,word1,word2,dp);
    }

    int editDistance(int n,int m,String word1,String word2,int dp[][])
    {
        if(n==0)
            return dp[n][m]=m;
        if(m==0)
            return dp[n][m]=n;
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        if(word1.charAt(n-1)==word2.charAt(m-1))
            return dp[n][m]=editDistance(n-1,m-1,word1,word2,dp);
        else
        {
            int insert=editDistance(n,m-1,word1,word2,dp);
            int delete=editDistance(n-1,m,word1,word2,dp);
            int replace=editDistance(n-1,m-1,word1,word2,dp);

            return dp[n][m]=1+Math.min(replace,Math.min(insert,delete));
        }
    }
    
}


