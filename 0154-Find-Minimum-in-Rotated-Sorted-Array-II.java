class Solution {
  public int findMin(int[] nums) {

    int l = 0;
    int r = nums.length - 1;
    int mid = 0;
    while (l <= r) {
      mid = (l + r) / 2;

      if (l == r) {
        return nums[l];
      }

      if (nums[mid] < nums[r]) {
        r = mid;
      } else if (nums[mid] == nums[r]) {
        r--;
      } else {
        l = mid + 1;
      }
    }

    return nums[l];

  }
}
