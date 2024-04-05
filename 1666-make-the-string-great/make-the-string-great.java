class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for(int i=0;i<s.length();i++)
        {
                Character ch1=s.charAt(i);
          
                if (!st.isEmpty() && Character.isLowerCase(ch1))
                {
                    if(Character.toUpperCase(ch1)==st.peek())
                        st.pop();
                    else
                        st.push(s.charAt(i));
                }
                else {
                    if(!st.isEmpty() && Character.toLowerCase(ch1)==st.peek())
                        st.pop();
                    else
                        st.push(s.charAt(i));
                }                    
           
        }

        while(!st.isEmpty())
            res=st.pop()+res;
        
        return res;
    }
}