class Solution {
  public double myPow(double x, int n) {
    //Space Complexity O(1)
    //time Complexity O(log n)
    double res = helper(x, n);
    return n < 0 ? 1 / res : res;
  }

  public double helper(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (x == 0) {
      return 0;
    }

    double res = helper(x, n / 2);
    res = res * res;

    return n % 2 == 0 ? res : res * x;
  }
}
