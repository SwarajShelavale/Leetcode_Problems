class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        int res=0;
        for(int val: mp.values())
        {
            if(val==1)
                return -1;

            if(val%3==0)
            {
                res+=val/3;
            }
            else
            {
                res+=(val/3)+1;
            }
        }
        return res;
    }
}