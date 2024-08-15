class Solution {
  public int findDuplicate(int[] nums) {

    //slow fast algorithm (Floyd warshall)
    //begining of the cycle
    int slow = 0;
    int fast = 0;

    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) {
        break;
      }
    }

    int start = 0;

    while (true) {
      start = nums[start];
      slow = nums[slow];
      if (slow == start) {
        return slow;
      }
    }
  }
}
