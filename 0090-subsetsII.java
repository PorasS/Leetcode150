class Solution {

  List < List < Integer >> res = null;
  public List < List < Integer >> subsetsWithDup(int[] nums) {

    res = new ArrayList < > ();
    if (nums.length == 0) {
      return new ArrayList < > (res);
    }

    Arrays.sort(nums);
    subSetsII(0, nums, new ArrayList < > ());
    return res;

  }

  public void subSetsII(int idx, int[] nums, List < Integer > list) {

    if (idx >= nums.length) {
      res.add(new ArrayList < > (list));
      return;
    }

    list.add(nums[idx]);
    subSetsII(idx + 1, nums, list);
    list.remove(list.size() - 1);
    int uniqueIdx = idx + 1;
    while (uniqueIdx < nums.length && nums[idx] == nums[uniqueIdx]) {
      uniqueIdx++;
    }

    subSetsII(uniqueIdx, nums, list);
  }
}
