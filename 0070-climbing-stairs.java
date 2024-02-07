class Solution {
  int[][] res;
  public int climbStairs(int n) {
    //create a matrix for step and stepRemain
    res = new int[3][n + 1];
    takeStep(0, n);
    return res[0][n];
  }

  public int takeStep(int step, int stepRemain) {
    if (stepRemain < 0) {
      return 0;
    }

    if (res[step][stepRemain] != 0) {
      return res[step][stepRemain];
    }

    if (stepRemain == 0) {
      return 1;
    }

    int totalWay = takeStep(1, stepRemain - 1) + takeStep(2, stepRemain - 2);

    res[step][stepRemain] = totalWay;

    return totalWay;
  }
}
