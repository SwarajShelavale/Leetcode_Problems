class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer,String> people = new TreeMap<>(Collections.reverseOrder());
        String[] str = new String[names.length];
        for(int i=0;i<names.length;i++)
            people.put(heights[i],names[i]);
        int i=0; 
        for(Integer height:people.keySet())
            {
                str[i] = people.get(height);
                i++;
            }

        return str;
    }
}