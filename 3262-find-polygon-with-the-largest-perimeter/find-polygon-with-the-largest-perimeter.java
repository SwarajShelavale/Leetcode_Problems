class Solution {
   
    public long largestPerimeter(int[] nums) {
         
        Arrays.sort(nums);
        long ans=0;
        long prefixSum= nums[0]+nums[1];
        
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]<prefixSum)
                ans=Math.max(ans,prefixSum+nums[i]);
            prefixSum+=nums[i];
        }
        
        return ans==0 ? -1:ans;
        
    }
}