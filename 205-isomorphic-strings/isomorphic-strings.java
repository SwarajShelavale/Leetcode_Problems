class Solution {
    public boolean isIsomorphic(String s, String t) {
    Map<Character,Character>mp = new HashMap<>();
    Map<Character,Character>mp2 = new HashMap<>();
    for(int i=0;i<s.length();i++)
    {
        if(mp.containsKey(s.charAt(i)))
        {
            if(t.charAt(i)!=mp.get(s.charAt(i)))
                return false;
        }
        else
        {
            if(mp2.containsKey(t.charAt(i)))
                return false;
            else {
            mp.put(s.charAt(i),t.charAt(i));
            mp2.put(t.charAt(i),s.charAt(i));
            }
        }
    }
    return true;
    }
}


