class Solution {
    public int pivotInteger(int n) {

        int prefixArr[] = new int[n+1];
        for(int i=0;i<=n;i++)
            prefixArr[i]= i == 0  ? i : prefixArr[i-1]+i;
        
        
        for(int i=1;i<=n;i++)
            if(prefixArr[i]==(prefixArr[n]-prefixArr[i]+i))
                return i;
        return -1;
    }
}
