class Solution {
    public int maxProfit(int[] prices) {
       int profit=0,i=0,j=1;
        while(j<prices.length)
        {
            if(prices[i]<prices[j])
                profit=Math.max(profit,prices[j]-prices[i]);
            else
                i=j;
            j++;
        }
        return profit;
    }
}