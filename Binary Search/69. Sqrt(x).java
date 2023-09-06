//Problem Link : https://leetcode.com/problems/sqrtx/

// Difficulty: Easy
// Time  Complexity : O(logN)
// Space Complexity : O(1)

// Code:
class Solution {
    public int mySqrt(int x) {
        long low=0,high=x;

        while(low<=high)
        {
            long mid= low+(high-low)/2;

            if(mid*mid==x || (mid*mid<x && (mid+1)*(mid+1)>x))
                return (int)mid;
            else if(mid*mid< x)
                low=mid+1;
            else
                high=mid-1;
        }
        return (int)low;
    }
}
