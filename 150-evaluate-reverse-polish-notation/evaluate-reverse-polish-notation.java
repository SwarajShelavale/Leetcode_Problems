class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++)
        {
            if(isOperator(tokens[i]))
            {
                int b = st.pop();
                int a = st.pop();
                
                st.push(findOutput(a,b,tokens[i]));
            }
            else 
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.peek();
    }

    boolean isOperator(String x)
    {
        return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
    }

    int findOutput(int a,int b,String x)
    {
        if(x.equals("+"))
            return a+b;
        else if(x.equals("-"))
            return a-b;
        else if(x.equals("*"))
            return a*b;
        else
            return a/b;
    }
}