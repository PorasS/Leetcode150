class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {

    Map < Integer, Integer > map = new HashMap < > ();

    int[] arr = null;
    int[] iter = null;

    if (nums1.length > nums2.length) {
      arr = nums2;
      iter = nums1;
    } else {
      arr = nums1;
      iter = nums2;
    }

    for (int i = 0; i < arr.length; i++) { //O(n)
      if (!map.containsKey(arr[i])) {
        map.put(arr[i], 0);
      }

      map.put(arr[i], map.get(arr[i]) + 1);
    }

    List < Integer > resList = new ArrayList < > ();
    for (int j = 0; j < iter.length; j++) { //O(m)
      if (map.containsKey(iter[j]) && map.get(iter[j]) > 0) {
        resList.add(iter[j]);
        map.put(iter[j], map.get(iter[j]) - 1);
      }
    }

    int[] res = new int[resList.size()];

    int idx = 0;
    for (int num: resList) { //O(m)
      res[idx++] = num;
    }

    //O(n + m)
    return res;

  }
}
