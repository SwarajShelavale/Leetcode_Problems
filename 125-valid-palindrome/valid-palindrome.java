class Solution {
    public boolean isPalindrome(String s) {
        String str = new String();
        int n=s.length();
        int left=0,right=n-1;

        while(left<right)
        {
            Character a = s.charAt(left);
            Character b = s.charAt(right);
            if(!checkAlphaNumeric(a))
                left++;
            else if(!checkAlphaNumeric(b))
                right--;
            else if (Character.toLowerCase(a)!=Character.toLowerCase(b))
                return false;
            else
            {
                left++;
                right--;
            }
        }
        return true;
    }

    public Boolean checkAlphaNumeric(Character i)
    {
        if( (i>='a' && i<='z') || (i>='A' && i<='Z') || (i>='0' && i<='9')) 
                return true;
        
        return false;
    }
}