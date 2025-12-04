class Solution {

    int[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        int minCoins = minCoins(coins, coins.length - 1, amount);
        return minCoins == (int) 1e9 ? -1 : minCoins;
    }

    public int minCoins(int[] coins, int idx, int target) {

        if (idx < 0 || target < 0) {
            return (int) 1e9;
        }

        if (target == 0) {
            return 0;
        }

        if (dp[idx][target] > 0) {
            return dp[idx][target];
        }

        int take = 1 + minCoins(coins, idx, target - coins[idx]);
        int noTake = 0 + minCoins(coins, idx - 1, target);

        dp[idx][target] = Math.min(take, noTake);

        return dp[idx][target];

    }

}
