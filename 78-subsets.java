class Solution {
  List < List < Integer >> res = null;
  public List < List < Integer >> subsets(int[] nums) {

    res = new ArrayList < > ();
    powerSet(new ArrayList < > (), 0, nums);
    return res;
  }

  public void powerSet(List < Integer > list, int idx, int[] nums) {
    if (idx > nums.length - 1) {
      List < Integer > newList = new ArrayList < > (list);
      res.add(newList);
      return;
    }

    list.add(nums[idx]);
    powerSet(list, idx + 1, nums);

    list.remove(list.size() - 1);
    powerSet(list, idx + 1, nums);
  }
}
