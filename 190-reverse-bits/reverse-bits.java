public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       int reverseInteger = 0;
        for(int i=0;i<32;i++){
          if((n & (1<<i)) !=0)
            reverseInteger = reverseInteger <<1 | 1;
          else
            reverseInteger = reverseInteger <<1;
        }
        return reverseInteger;
    }
}