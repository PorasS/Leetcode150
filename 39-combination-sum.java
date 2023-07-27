class Solution {

  List < List < Integer >> res = null;
  public List < List < Integer >> combinationSum(int[] candidates, int target) {
    res = new ArrayList < > ();
    calculateSum(new ArrayList < > (), target, 0, 0, candidates);
    return res;
  }

  public void calculateSum(List < Integer > list, int target, int total, int idx, int[] candidates) {

    if (total > target || idx >= candidates.length) {
      return;
    }

    if (total == target) {
      List < Integer > newList = new ArrayList < > (list);
      res.add(newList);
      return;
    }

    list.add(candidates[idx]);
    calculateSum(list, target, total + candidates[idx], idx, candidates);
    list.remove(list.size() - 1);
    calculateSum(list, target, total, idx + 1, candidates);

  }

}
