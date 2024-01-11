class Solution {
    public int deleteAndEarn(int[] nums) {
        int n= 100001;
        int points[] = new int[n];
        for(int x:nums)
            points[x]+=x;
        
        int dp[] = new int[n];
        dp[0]= points[0];
        dp[1]= points[1];

        for(int i=2;i<n;i++)
            dp[i]=Math.max(points[i]+dp[i-2],dp[i-1]);
        
        return dp[n-1];

    }
}