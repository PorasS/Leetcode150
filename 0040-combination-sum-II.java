class Solution {

  List < List < Integer >> res = null;
  public List < List < Integer >> combinationSum2(int[] candidates, int target) {
    res = new ArrayList < > ();
    if (candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    cs2(new ArrayList < > (), 0, target, candidates);
    return res;
  }

  public void cs2(List < Integer > list, int idx, int target, int[] candidates) {

    if (target == 0) {
      res.add(new ArrayList < > (list));
      return;
    }

    if (idx >= candidates.length || target < 0) {
      return;
    }

    list.add(candidates[idx]);
    cs2(list, idx + 1, target - candidates[idx], candidates);
    list.remove(list.size() - 1);
    int uniqueIdx = idx + 1;
    while (uniqueIdx < candidates.length && candidates[idx] == candidates[uniqueIdx]) {
      uniqueIdx++;
    }
    cs2(list, uniqueIdx, target, candidates);
  }

}
