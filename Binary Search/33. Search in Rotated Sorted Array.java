//Problem Link : https://leetcode.com/problems/search-in-rotated-sorted-array/

// Difficulty: Medium
// Time  Complexity : O(LogN)
// Space Complexity : O(1)

//Code:
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length,low=0,high=n-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[low]<=nums[mid])
            {
                if(target > nums[mid] || target<nums[low])
                      low=mid+1;
                else
                    high=mid-1;
            }
            else
            {
                if(target<nums[mid] || target > nums[high])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return -1;
    }
}
