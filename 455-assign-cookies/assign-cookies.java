class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
       while(i<s.length)
        {
            if(j<g.length && g[j]<=s[i])
            {
                count++;
                j++;
            }
            i++;
        }

        return count;
    }
}