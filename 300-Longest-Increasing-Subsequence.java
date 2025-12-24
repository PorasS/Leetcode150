class Solution {
    Map<Integer, Integer> dp;

    public int lengthOfLIS(int[] nums) {
        dp = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, lts(nums, i));
        }

        return max;
    }

    public int lts(int[] nums, int idx) {
        if (idx > nums.length - 1) {
            return 0;
        }

        if (dp.containsKey(idx)) {
            return dp.get(idx);
        }

        //take
        int max = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > nums[idx]) {
                max = Math.max(max, lts(nums, i));
            }
        }

        dp.put(idx, 1 + max);
        return 1 + max;
    }
}
