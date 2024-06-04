class Solution {
    public String compressedString(String word) {
        int prev=-1,count=0;
        StringBuilder str = new StringBuilder();
        char ch = ' ';
        for(int i=0;i<word.length();i++)
        {
            if(count==0)
            {
                ch=word.charAt(i);
                count++;
                if(i== (word.length()-1))
                {
                    str.append(count);
                    str.append(ch);
                }
            }
            else if(ch == word.charAt(i))
            {
                
                if(i== (word.length()-1))
                {
                    str.append(count+1);
                    str.append(ch);
                }
                else if(count<8)
                    count++;
                else if(count==8)
                {
                    str.append('9');
                    str.append(ch);
                    count=0;
                    System.out.println("C PRINTED");
                }
            }
            else
            {
                str.append(count);
                str.append(ch);
                ch=word.charAt(i);
                count=1;
                if(i== (word.length()-1))
                {
                    System.out.println("Printed "+count+" "+ch);
                    str.append(count);
                    str.append(ch);
                }
            }
            
        }

        return str.toString();
    }
}