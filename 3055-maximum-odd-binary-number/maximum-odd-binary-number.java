class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count=0,n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
                count++;
        }
        String res="";
        for(int i=0;i<n-1;i++)
        {
            if(count>1)
            {
                res+="1";
                count--;
            }
            else
                res+="0";
            
        }
        res+="1";
        
        return res;
    }
}