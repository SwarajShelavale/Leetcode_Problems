class Solution {
    //States:
    //      0 - Buy
    //      1 - Sell
    //      2 - CoolDown

    private int dp[][];
    public int maxProfit(int[] prices) {
        
        dp = new int[prices.length][3];
        for(int i=0;i<prices.length;i++)
            Arrays.fill(dp[i],-1);
        return profit(0,prices,2);
    }

    int profit(int index,int[] prices,int current_state)
    {
        if(index==prices.length)
            return 0;
        
        if(dp[index][current_state]!=-1)
            return dp[index][current_state];

        if(current_state==2) //current_State is cooldown
        {
            return dp[index][current_state]=Math.max(-prices[index]+profit(index+1,prices,0),profit(index+1,prices,2));
        }
        else if(current_state==1) //current_State is sell
        {
            return dp[index][current_state]=profit(index+1,prices,2);
        }
        else //current_State is buy
        {
            return dp[index][current_state]=Math.max(prices[index]+profit(index+1,prices,1),profit(index+1,prices,0));
        }
    }
}