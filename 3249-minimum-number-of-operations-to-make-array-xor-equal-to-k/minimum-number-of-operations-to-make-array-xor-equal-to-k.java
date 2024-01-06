class Solution {
    public int minOperations(int[] nums, int k) {

        for(int x:nums)
            k=k^x;
        
        return Integer.bitCount(k);
    }
}
// 2 1 3 4

// 010
// 001
// 011
// 100
// 100