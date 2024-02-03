class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        for(String w : words)
        {
            for(int i=1;i<w.length();i++)
            {
                if(set.contains(w.substring(i)))
                    set.remove(w.substring(i));
            }
        }

        int lengthOfShortestReferance = 0;

        for(String w : set)
            lengthOfShortestReferance += w.length()+1;
        

        return lengthOfShortestReferance;
    }
}