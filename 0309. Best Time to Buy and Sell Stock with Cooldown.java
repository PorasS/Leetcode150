class Solution {

    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        return stockProfit(0, 1, prices);
    }

    public int stockProfit(int idx, int buy, int[] prices) {

        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][buy] > 0) {
            return dp[idx][buy];
        }

        if (buy == 1) {
            dp[idx][buy] = Math.max((-prices[idx] + stockProfit(idx + 1, 0, prices)),
                    (0 + stockProfit(idx + 1, 1, prices)));
            return dp[idx][buy];
        }

        dp[idx][buy] = Math.max((prices[idx] + stockProfit(idx + 2, 1, prices)),
         (0 + stockProfit(idx + 1, 0, prices)));

        return dp[idx][buy];

    }
}
