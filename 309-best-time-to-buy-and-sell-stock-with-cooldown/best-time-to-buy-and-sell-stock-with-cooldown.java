class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        int dp[][] = new int[n+1][3];
        //0-can buy
        //1-can sell
        //2-can cooldown
        for (int i = n-1; i >=0; i--) {
            int toBuy = -prices[i] + dp[i + 1][1];
            int notToBuy = dp[i+1][0];

            int toSell = prices[i] + dp[i+1][2];
            int notToSell = dp[i+1][1];

            int toCoolDown = dp[i+1][0];

            dp[i][0] = Math.max(Math.max(toBuy, notToBuy),toCoolDown);
            dp[i][1] = Math.max(toSell, notToSell);
            dp[i][2] = toCoolDown;
        }

        return dp[0][0];
    }
}