class Solution {
    Map<String, Boolean> dp;

    public boolean canPartition(int[] nums) {
  
        //here we are asked to find two subset with equal value

        //1. sum all the elements in the nums[]
        //2. keep target as sum/2
        //3. check the subset for sum/2 is there is a subset for sum/2
        // then there will be the subset remaining with the same sum/2 value.
      
        dp = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return search(nums, nums.length - 1, sum / 2);

    }

    public boolean search(int[] nums, int idx, int target) {
        if (idx < 0) {
            return false;
        }

        if (target == 0) {
            return true;
        }

        if (idx == 0 && target == nums[idx]) {
            return true;
        }

        String cell = Integer.valueOf(idx) + ":" + Integer.valueOf(target);
        if (dp.containsKey(cell)) {
            return dp.get(cell);
        }

        boolean take = false;
        if (nums[idx] <= target) {
            take = search(nums, idx - 1, target - nums[idx]);
        }

        boolean noTake = search(nums, idx - 1, target);

        boolean res = take || noTake;

        dp.put(cell, res);

        return dp.get(cell);
    }

}
