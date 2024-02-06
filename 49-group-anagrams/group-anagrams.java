class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>>mp = new HashMap<>();
       int n=strs.length;

        for(int i=0;i<n;i++)
        {
            String temp=strs[i];
            char arr[]= temp.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if(!mp.containsKey(sorted))
            {
                mp.put(sorted,new ArrayList<>());
                mp.get(sorted).add(temp);
            }
            else
            {
                mp.get(sorted).add(temp);
            }
        }
        return new ArrayList<>(mp.values());
    }
}