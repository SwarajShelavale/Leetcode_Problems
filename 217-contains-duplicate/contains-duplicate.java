class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        
        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        
        for(int val:mp.values()){
            if(val > 1)
                return true;
        }
        return false;
    }
}