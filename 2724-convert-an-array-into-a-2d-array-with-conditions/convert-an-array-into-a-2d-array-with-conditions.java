class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<nums.length;i++)
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        
        List<List<Integer>> res = new ArrayList<>();

         while (mp.size() > 0) {
            List<Integer> temp = new ArrayList<>();
        
            Set<Integer> keySetCopy = new HashSet<>(mp.keySet());
            
            for (Integer key : keySetCopy) {
                int value = mp.get(key);
                temp.add(key);
                mp.put(key, value - 1);

                if (mp.get(key) == 0)
                    mp.remove(key);
            }
            res.add(temp);
        }

        return res;
    }
}