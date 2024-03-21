class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        palindromePartitioning(s,new ArrayList<>(),res);
        return res;
    }

    void palindromePartitioning(String s,List<String> list, List<List<String>>res)
    {
        if(s.length()==0 || s==null) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=1;i<=s.length();i++)
        {
            String temp = s.substring(0,i);

            if(!isPalindrome(temp))
                continue;
            
            list.add(temp);
            palindromePartitioning(s.substring(i,s.length()),list,res);   
            list.remove(list.size()-1);
        }
    }

    boolean isPalindrome(String s)
    {
        int left=0,right=s.length()-1;
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
                return false;
            
            left++;
            right--;
        }
        return true;
    }
}