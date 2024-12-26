class Solution {
    
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        int minCoins = dfs(coins.length - 1, amount, coins);
        return  minCoins == (int) 1e9 ? -1 : minCoins;
    }


    public int dfs(int idx, int target, int[] coins){

        if(idx >= 0 && target >= 0 && dp[idx][target] != 0){
            return dp[idx][target];
        }

        if(idx == 0){
            if(target % coins[idx] == 0){
                return target / coins[idx];
            }else{
                return (int)1e9;
            }
        }

        if(target < 0){
            return (int)1e9;
        }

        if(target == 0){
            return 0;
        }

        int noTake = 0 + dfs(idx - 1, target, coins);
        int take = 1 + dfs(idx, target - coins[idx], coins);

        int minCoins = Math.min(take, noTake);
        dp[idx][target] = minCoins;
        return dp[idx][target];
    }
}
