class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            res[i] = countSetBits(i);
        }
        
        return res;
    }

    int countSetBits(int n)
    {
        int count=0;
        for(int i=0;i<31;i++)
        {
                count+= (n&1)==1 ? 1:0;
            n=n>>1;
        }
        return count;
    }
}