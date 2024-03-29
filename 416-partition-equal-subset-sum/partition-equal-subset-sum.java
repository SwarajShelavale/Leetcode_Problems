class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)
            sum+=x;
        
        if(sum%2==1)
            return false;
        
        int targetSum=sum/2;
        int n=nums.length;

        boolean dp[][] = new boolean[n+1][targetSum+1];

        for(int i=0;i<=n;i++)
            dp[i][0]=true;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=targetSum;j++)
            {
                if(nums[i-1]<=j)
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][targetSum];
    }
}