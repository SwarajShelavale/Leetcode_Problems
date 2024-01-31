class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int i=0,j=0,n=s.length();
        int longestSubstring=0;
        while(j<n)
        {
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(j-i+1 == map.size())
                longestSubstring = Math.max(longestSubstring, j-i+1);
            else
            {
                while(j-i+1 > map.size())
                {
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0)
                        map.remove(s.charAt(i));
                    i++;
                }
                longestSubstring = Math.max(longestSubstring, j-i+1);
            }
            j++;
        }

        return  longestSubstring;
    }
}