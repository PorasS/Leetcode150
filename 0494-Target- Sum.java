class Solution {
    Map<String, Integer> dp;

    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();

        return targetSum(0, nums, target, 0);
    }

    public int targetSum(int idx, int[] nums, int target, int sum) {

        String cell = idx + ":" + sum;

        if (idx == nums.length) {
            return target == sum ? 1 : 0;
        }

        if (idx > nums.length) {
            return 0;
        }

        if (dp.containsKey(cell)) {
            return dp.get(cell);
        }

        int pos = targetSum(idx + 1, nums, target, sum + nums[idx]);
        int neg = targetSum(idx + 1, nums, target, sum - nums[idx]);

        int total = pos + neg;

        dp.put(cell, total);

        return dp.get(cell);
    }
}
