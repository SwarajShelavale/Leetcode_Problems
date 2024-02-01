class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1)
            return true;
       
        int arr[] = new int[n];
        arr[0] = nums[0];
        
        for(int i=1; i<n; i++)
        {
            if(arr[i-1]>=i)
                arr[i] = Math.max(arr[i-1],nums[i]+i);
            else
                return false;
        }
        return true;    
    }
}