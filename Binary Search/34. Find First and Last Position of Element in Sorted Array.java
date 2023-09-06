//Problem Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Difficulty: Medium
// Time  Complexity : O(LogN)
// Space Complexity : O(1)

//Code:
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPostion(nums,target);
        int lastPosition = findLastPostion(nums,target);
        return new int[]{firstPosition,lastPosition};
    }

    int findFirstPostion(int[] nums,int target)
    {
        int low=0,high=nums.length-1;
        int targetFoundIndex=-1;
        while(low<=high)
        {
            int mid=low+ (high-low)/2;

            if(nums[mid]==target)
            {
                targetFoundIndex=mid;
                high=mid-1;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }    
        }

        return targetFoundIndex;
    }

      int findLastPostion(int[] nums,int target)
    {
        int low=0,high=nums.length-1;
        int targetFoundIndex=-1;
        while(low<=high)
        {
            int mid=low+ (high-low)/2;

            if(nums[mid]==target)
            {
                targetFoundIndex=mid;
                low=mid+1;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }    
        }

        return targetFoundIndex;
    }
}
