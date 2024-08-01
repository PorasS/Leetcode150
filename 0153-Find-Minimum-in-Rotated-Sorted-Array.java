class Solution {
  public int findMin(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    int l = 0;
    int r = nums.length - 1;

    while (l <= r) {
      int mid = (l + r) / 2;

      if (nums[mid] == nums[r]) {
        return nums[mid];
      } else if (nums[mid] > nums[r]) {
        l = mid + 1;
      } else if (nums[mid] < nums[r]) {
        r = mid;
      }
    }

    return nums[0];

  }
}
