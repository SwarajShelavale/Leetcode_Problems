class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        
        for(int x:nums){
            if(mp.containsKey(x))
            {
                return true;
            }
            mp.put(x,1);
        }
        return false;
    }
}