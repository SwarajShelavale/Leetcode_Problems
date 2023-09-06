//Problem Link : https://leetcode.com/problems/single-element-in-a-sorted-array/

// Difficulty: Medium
// Time  Complexity : O(logN)
// Space Complexity : O(1)

// Code:
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length,low=0,high=n-1;

        while(low<high)
        {
            int mid=low+ (high-low)/2;

            if(mid==0 || mid==n-1)
                return nums[mid];
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            else if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2==1 && nums[mid]==nums[mid-1]))
                low=mid+1;
            else
                high=mid-1;

        }
        return nums[low];
    }
}
