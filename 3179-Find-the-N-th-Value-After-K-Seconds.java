class Solution {
  public int valueAfterKSeconds(int n, int k) {
    int[] a = new int[n];
    Arrays.fill(a, 1);
    int mod = 1_000_000_007;

    int counter = 0;
    while (counter < k) {
      for (int i = 1; i < n; i++) {
        a[i] = (a[i - 1] + a[i]) % mod;
      }

      counter++;
    }

    return a[a.length - 1];
  }
}

//use mod = 1_000_000_007 for not going out of space
