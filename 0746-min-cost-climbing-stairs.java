class Solution {
  int[] dp;
  public int minCostClimbingStairs(int[] cost) {
    dp = new int[cost.length];

    return Math.min(minCost(cost, 0), minCost(cost, 1));

  }

  public int minCost(int[] cost, int index) {

    if (index == cost.length - 1) {
      return cost[index];
    }

    if (index > cost.length - 1) {
      return 0;
    }

    if (dp[index] != 0) {
      return dp[index];
    }

    int minCost = Math.min(minCost(cost, index + 1),
      minCost(cost, index + 2));

    dp[index] = minCost + cost[index];

    return dp[index];
  }
}
