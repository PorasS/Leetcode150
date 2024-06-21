class Solution {

  int count;
  public int findTargetSumWays(int[] nums, int target) {
    count = 0;
    targetSumWays(0, 0, nums, target);
    return count;
  }

  public void targetSumWays(int idx, int currSum, int[] nums, int target) {
    if ((idx == nums.length && currSum == target)) {
      count++;
      return;
    }

    if (idx >= nums.length) {
      return;
    }

    targetSumWays(idx + 1, (currSum + nums[idx]), nums, target);
    targetSumWays(idx + 1, (currSum - nums[idx]), nums, target);
  }
}
