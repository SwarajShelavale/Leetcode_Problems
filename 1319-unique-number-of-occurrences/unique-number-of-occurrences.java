class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x:arr)
            mp.put(x,mp.getOrDefault(x,0)+1);
        
        HashSet<Integer> hs = new HashSet<>(mp.values());

        return hs.size()==mp.size();
    }
}