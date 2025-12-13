class Solution {

    public int maxProduct(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int pre = 1;
        int suff = 1;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pre == 0) {
                pre = 1;
            }
            if (suff == 0) {
                suff = 1;
            }

            pre = pre * nums[i];
            suff = suff * nums[nums.length - i - 1];

            res = Math.max(res, Math.max(pre, suff));
        }

        return res;
    }
}
