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

             if(mp.get(ch)==0)
                    mp.remove(ch);

            //For String2
            char ch2 = t.charAt(i);
            mp.put(ch2,mp.getOrDefault(ch2,0)-1);

            if(mp.get(ch2)==0)
                    mp.remove(ch2);
        }
        return mp.isEmpty();

    }
}