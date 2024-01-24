class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int dp[][] = new int[n+1][2];
        //0-can buy
        //1-can sell
        for (int i = n-1; i >=0; i--) {
            int toBuy = -prices[i] + dp[i + 1][1];
            int notToBuy = dp[i+1][0];

            int toSell = prices[i] + dp[i+1][0];
            int notToSell = dp[i+1][1];

            dp[i][0] = Math.max(toBuy, notToBuy);
            dp[i][1] = Math.max(toSell, notToSell);
        }

        return dp[0][0];
    }
}