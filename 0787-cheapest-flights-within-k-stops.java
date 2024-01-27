class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    if (src == dst) {
      return -1;
    }

    int stop = 0;

    int[] res = new int[n];

    Arrays.fill(res, Integer.MAX_VALUE);

    //src will be 0 at start
    res[src] = 0;

    while (stop <= k) {
      int[] temp = Arrays.copyOf(res, res.length);
      for (int l = 0; l < flights.length; l++) {
        int s = flights[l][0];
        int d = flights[l][1];
        int c = flights[l][2];
        if (res[s] == Integer.MAX_VALUE) {
          continue;
        }
        //update dst
        temp[d] = Math.min(temp[d], res[s] + c);
      }
      res = temp;
      stop++;
    }
    return res[dst] != Integer.MAX_VALUE ? res[dst] : -1;
  }
}
