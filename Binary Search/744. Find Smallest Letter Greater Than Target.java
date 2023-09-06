//Problem Link : https://leetcode.com/problems/find-smallest-letter-greater-than-target/

// Difficulty: Easy
// Time  Complexity : O(LogN)
// Space Complexity : O(1)

//Code:
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1;
        int index=0;
        while(low<=high)
        {
            int mid= low + (high-low)/2;

            if(letters[mid]>target)
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return letters[index];
    }
}
