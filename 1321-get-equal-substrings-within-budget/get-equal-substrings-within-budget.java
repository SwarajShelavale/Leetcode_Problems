class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int cost = 0;
        int difference[] = new int[n];
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=t.charAt(i))
            {
                difference[i]=Math.abs(s.charAt(i) - t.charAt(i));
                
                cost += difference[i];
            }
        }
        if(cost<=maxCost)
            return n;
        
        int i=0,j=0,maxLength=0;
        int currentCost  = 0;
        while(j<n)
        {
            currentCost += difference[j];
            
           if (currentCost <= maxCost) {
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }
            else {
                while (currentCost > maxCost && i <= j) {
                    currentCost -= difference[i];
                    i++;
                }
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }
        }

        return maxLength;
    }
}
