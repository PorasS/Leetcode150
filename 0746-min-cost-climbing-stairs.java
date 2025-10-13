class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }

        return Math.min(minCost(0, cost, dp), minCost(1, cost, dp));
    }

    public int minCost(int n, int[] cost, int[] dp){

        if(n > cost.length - 1){ //reach to top
            return 0;
        }

        if(dp[n] >= 0){
            return dp[n];
        }

        dp[n] = cost[n] + Math.min(minCost(n+1, cost, dp), minCost(n+2, cost, dp));

        return dp[n];
    }
}
