//Problem Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Difficulty: Medium
// Time  Complexity : O(LogN)
// Space Complexity : O(1)

//Code:
class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        if(n==1 || nums[0]<nums[n-1])
            return nums[0];
        if(nums[n-1]<nums[n-2])
            return nums[n-1];
        
        int low=1,high=n-2;
        while(low<=high)
        {
            int mid=low+(high-low)/2;

            if(nums[mid]<nums[mid-1] &&  nums[mid]<nums[mid+1])
            {
                return nums[mid];
            }
            else if(nums[mid]>nums[high])
                low=mid+1;
            else
                high=mid-1;
        }
        return nums[low];
    }
}
