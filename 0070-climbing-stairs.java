class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        return totalWays(n, dp);
    }


    public int totalWays(int n, int[] dp){

        if(n < 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        int totalSteps = totalWays(n-1, dp) + totalWays(n-2, dp);

        dp[n] = totalSteps;
        return totalSteps;
    }
}
