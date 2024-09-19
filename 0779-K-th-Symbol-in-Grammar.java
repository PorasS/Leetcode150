class Solution {

  public int kthGrammar(int n, int k) {

    int l = 0;
    int r = (int) Math.pow(2, n - 1);

    int curr = 0;

    for (int i = 1; i < n; i++) {
      int mid = (l + r) / 2;

      if (k <= mid) {
        r = mid;
      } else {
        l = mid + 1;
        curr = curr == 0 ? 1 : 0;
      }
    }

    return curr;
  }
}
