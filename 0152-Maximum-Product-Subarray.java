class Solution {

  public int maxProduct(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    int prefix = 1;
    int suffix = 1;
    int maxProduct = 0;
    for (int i = 0; i < nums.length; i++) {
      prefix *= nums[i];
      suffix *= nums[nums.length - 1 - i];

      maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));

      if (nums[i] == 0) {
        prefix = 1;
      }

      if (nums[nums.length - 1 - i] == 0) {
        suffix = 1;
      }
    }

    return maxProduct;
  }

}
