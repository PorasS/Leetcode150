class Solution {
  int result = 0;
  public int findPeakElement(int[] nums) {
    findPeak(0, nums.length - 1, nums);
    return result;
  }

  public void findPeak(int l, int r, int[] nums) {

    if (l > r) {
      return;
    }

    int mid = (l + r) / 2;

    if (mid - 1 < 0 && mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
      result = mid;
      return;
    }

    if (mid + 1 >= nums.length && mid - 1 >= 0 && nums[mid - 1] < nums[mid]) {
      result = mid;
      return;
    }

    if ((mid - 1) >= 0 && (mid + 1) < nums.length && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
      result = mid;
      return;
    }

    if (mid - 1 >= 0) {
      findPeak(l, mid - 1, nums);
    }

    if (mid + 1 < nums.length) {
      findPeak(mid + 1, r, nums);
    }

  }
}
