
//Problem Link : https://leetcode.com/problems/binary-search/

// Time  Complexity : O(LogN)
// Space Complexity : O(1)


//Code:
class Solution {
    public int search(int[] nums, int target) {
        int start = 0 , end = nums.length-1;

        while(start<=end)
        {
            int mid =  start + (end - start)/2;            
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
