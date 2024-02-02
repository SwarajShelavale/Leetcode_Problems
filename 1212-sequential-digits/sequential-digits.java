class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for(int i=1;i<9;i++)
            findsequentialDigits(i,i,low,high,result);

        Collections.sort(result);
        return result;
    }
    
    void findsequentialDigits(int num,int lastDigit,int low,int high,List<Integer> result)
    {
        if(num>high)
            return;

        if(lastDigit>9)
            return;
        
        if(num>=low && num<=high)
            result.add(num);

        num=num*10+(lastDigit+1);

        findsequentialDigits(num,lastDigit+1,low,high,result);
    }
}