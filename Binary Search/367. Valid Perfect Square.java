//Problem Link : https://leetcode.com/problems/valid-perfect-square/

// Difficulty: Easy
// Time  Complexity :  O(logN)
// Space Complexity :  O(1)

// Code:
class Solution {
    public boolean isPerfectSquare(int num) {
        long low=1,high=num;

        while(low<=high)
        {
            long mid=low + (high-low)/2;

            if(mid*mid==num)
                return true;
            else if(mid*mid>num)
                high=mid-1;
            else
                low=mid+1;
        }

        return false;
    }
}
