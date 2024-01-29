class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return lis(0,-1,nums,dp);
    }

    int lis(int index,int prevIndex , int[] nums,int[][] dp)
    {
        if(index==nums.length)
            return 0;
        if(dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];
            
        int skip = lis(index+1,prevIndex,nums,dp);
        int choose = -1;

        if(prevIndex == -1 || nums[index] > nums[prevIndex])
            choose = 1+ lis(index+1, index,nums,dp);

        return dp[index][prevIndex+1]=Math.max(skip,choose);
    }
}