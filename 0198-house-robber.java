class Solution {
  int[] dp;
  int maxAmount;
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    dp = new int[nums.length];
    maxAmount = 0;
    for (int i = 0; i < nums.length; i++) {
      maxAmount = Math.max(maxAmount, robMoney(nums, i));
    }

    return maxAmount;
  }

  int robMoney(int[] nums, int index) {

    if (nums[index] == 0) {
      return 0;
    }

    if (dp[index] != 0) {
      return dp[index];
    }

    if (index > nums.length - 1) {
      return 0;
    }

    if (index == nums.length - 1 || index + 2 > nums.length - 1) {
      dp[index] = nums[index];
      return dp[index];
    }

    for (int i = index + 2; i < nums.length; i++) {
      dp[index] = Math.max(dp[index], robMoney(nums, i) + nums[index]);
    }

    return dp[index];
  }
}
