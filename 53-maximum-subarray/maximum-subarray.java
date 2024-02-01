class Solution {
    public int maxSubArray(int[] nums) {
         int largestSum=nums[0],sum=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>=(sum+nums[i]))
                sum=nums[i];
            else
                sum+=nums[i];
            largestSum=Math.max(largestSum,sum);
        }
        return largestSum;
    }
}