class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength=-1;
        int fpos[] = new int[26];
        int lpos[] = new int[26];

        for(int i=0;i<26;i++)
        {
            fpos[i]=-1;
            lpos[i]=-1;
        }

        for(int i=0;i<s.length();i++)
        {
            int ind=s.charAt(i)-'a';
            if(fpos[ind]==-1)
                fpos[ind]=i;
            else
                lpos[ind]=i;
        }

        for(int i=0;i<26;i++)
        {
            if(fpos[i]!=-1 && lpos[i]!=-1)
            {
                maxLength=Math.max(maxLength,lpos[i]-fpos[i]-1);
            }
        }

        return maxLength;

    }
}