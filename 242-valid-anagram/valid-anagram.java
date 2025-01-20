class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        int n=s.length(),m=t.length();
        if(n!=m)
            return false;
        for(int i=0;i<n;i++)
        {
            //For String1
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);   
        }

        for(int i=0;i<n;i++)
        {
            //For String2
            char ch = t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)-1);  
            if(mp.get(ch) == 0)
            {
                mp.remove(ch);
            } 
        }
        return mp.isEmpty();

    }
} 


