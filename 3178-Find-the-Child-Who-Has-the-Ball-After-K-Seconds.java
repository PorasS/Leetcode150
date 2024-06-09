class Solution {
  public int numberOfChild(int n, int k) {
    int current = 0;
    int dir = 1;
    int next = 0;

    for (int i = 1; i <= k; i++) {
      next = current + dir;
      if (next < 0 || next >= n) {
        dir *= -1;
      }

      current = current + dir;
    }

    return current;
  }
}

//Note: for changing the direction once we reach to end
//initialise dir = 1, once reach to either end multiple by -1;
//dir = dir * -1;
