//Problem Link : https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

// Difficulty: Easy
// Time  Complexity : O(NLogN)
// Space Complexity : O(1)

//Code:
class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int totalCountOfNegatives=0;

        for(int row=0;row<m;row++)
        {
            totalCountOfNegatives+=CountOfNegativesInRow(row,grid,n);
        }
        return totalCountOfNegatives;
    }

    int CountOfNegativesInRow(int row,int[][] grid,int n)
    {
        int low=0,high=n-1;
        int index=n;
        while(low<=high)
        {
            int mid=low + (high-low)/2;
            if(grid[row][mid]< 0)
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return n-index;
    }
}

