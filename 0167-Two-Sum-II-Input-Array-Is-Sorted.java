class Solution {
  public int[] twoSum(int[] numbers, int target) {

    int l = 0;
    int r = numbers.length - 1;

    //two pointer approach
    int[] res = new int[2];
    while (l < r) {
      int sum = numbers[l] + numbers[r];

      if (sum == target) {
        res[0] = l + 1;
        res[1] = r + 1;
        return res;
      } else if (sum > target) {
        r--;
      } else {
        l++;
      }
    }

    //Time Complexity : O(n)
    //Space Complexity : O(1)
    return res;
  }
}
