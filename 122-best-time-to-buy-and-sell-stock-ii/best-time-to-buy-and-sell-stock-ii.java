class Solution {
    //States:
    //      1 - can Buy
    //      0 - can Sell
    private int dp[][];
    public int maxProfit(int[] prices) {
        
        dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++)
            Arrays.fill(dp[i],-1);
        return profit(0,prices,1);
    }

    int profit(int index,int[] prices,int state)
    {
        if(index==prices.length)
            return 0;
        
        if(dp[index][state]!=-1)
            return dp[index][state];

        if(state==1)
            return dp[index][state]=Math.max(-prices[index]+profit(index+1,prices,0),profit(index+1,prices,1));
        else
            return dp[index][state]=Math.max(prices[index]+profit(index+1,prices,1),profit(index+1,prices,0));
        
    }
}