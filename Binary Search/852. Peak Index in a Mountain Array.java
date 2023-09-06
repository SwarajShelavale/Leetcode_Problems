//Problem Link : https://leetcode.com/problems/peak-index-in-a-mountain-array/

// Difficulty: Medium
// Time  Complexity :  O(logN)
// Space Complexity :  O(1)

// Code:
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       
        int n=arr.length;
        if(arr[0]>arr[1])
            return 0;
        if(arr[n-1]>arr[n-2])
            return n-1;

        int low=1,high=n-2;

        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
            {
                return mid;
            }
            else if(arr[mid]>arr[mid-1])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return low;
    }
}
