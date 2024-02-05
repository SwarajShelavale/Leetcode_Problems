class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!mp.containsKey(s.charAt(i)))
                mp.put(s.charAt(i),i);
            else
                 mp.put(s.charAt(i),Integer.MAX_VALUE);
        }
        int minIndex = Integer.MAX_VALUE;
        for(int x:mp.values())
            minIndex = Math.min(minIndex,x);
        
        return minIndex == Integer.MAX_VALUE ? -1: minIndex;
    }
}