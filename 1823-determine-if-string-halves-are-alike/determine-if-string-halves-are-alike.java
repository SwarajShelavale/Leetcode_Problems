class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n=s.length(),count=0;
        for(int i=0;i<n/2;i++)
        {
            if(isVoewl(s.charAt(i)))
                count++;
        }

        for(int i=n/2;i<n;i++)
        {
            if(isVoewl(s.charAt(i))) {
               count--;
            }            
        }

        return count==0;
    }

    boolean isVoewl(Character ch)
    {
        return ch=='a' || ch=='e' || ch=='i' ||ch=='o' || ch=='u' ||ch=='A' ||ch=='E' ||ch=='I' ||ch=='O' ||ch=='U';
    }
}