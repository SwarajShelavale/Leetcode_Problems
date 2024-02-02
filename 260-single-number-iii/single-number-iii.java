class Solution {
    public int[] singleNumber(int[] nums) {
        int singleNumber=0;
        for(int i=0;i<nums.length;i++)
            singleNumber^=nums[i];

        singleNumber = singleNumber & ~(singleNumber-1); //Find the lowest set bit

        int a=0,b=0;
        for(int i=0;i<nums.length;i++)
        {
            if((singleNumber & nums[i])!=0)
                a^=nums[i];
            else
                b^=nums[i];

        }
       
        return new int[]{a,b};

    }
}
