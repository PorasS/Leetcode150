class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {

    int len1 = nums1.length;
    int len2 = nums2.length;

    Set < Integer > set = new HashSet < > ();

    int[] toSet = null;
    int[] iter = null;
    if (len1 < len2) {
      toSet = nums2;
      iter = nums1;
    } else {
      toSet = nums1;
      iter = nums2;
    }

    //O(n)
    for (Integer e: toSet) {
      set.add(e);
    }

    //space : O(n)
    Set < Integer > resSet = new HashSet < > ();
    for (int i = 0; i < iter.length; i++) { //O(n)
      if (set.contains(iter[i])) { //O(1)
        resSet.add(iter[i]);
      }
    }

    int[] res = new int[resSet.size()];

    int idx = 0;
    for (int n: resSet) { //O(n)
      res[idx++] = n;
    }

    //Total Complexity :  O(n)
    //Space Complexity : O(n)      
    return res;

  }
}
