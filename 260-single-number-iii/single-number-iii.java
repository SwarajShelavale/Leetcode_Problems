class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR = 0;
        for (int i = 0; i < nums.length; i++)
            XOR ^= nums[i];

        XOR = XOR & ~(XOR - 1); // Find the lowest set bit

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((XOR & nums[i]) != 0)
                a ^= nums[i];
            else
                b ^= nums[i];
        }

        return new int[]{a, b};
    }
}