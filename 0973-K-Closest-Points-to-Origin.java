class Solution {
  public int[][] kClosest(int[][] points, int k) {

    if (points.length == 1) {
      return points;
    }

    PriorityQueue < Node > minHeap = new PriorityQueue < Node > ((n1, n2) -> Double.compare(n1.disToOrg, n2.disToOrg));

    for (int i = 0; i < points.length; i++) {
      int[] point = points[i];

      int x2 = point[0];
      int y2 = point[1];

      double dis = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

      Node node = new Node(point, dis);
      minHeap.offer(node);
    }

    int[][] res = new int[k][2];

    for (int l = 0; l < k; l++) {
      Node n = minHeap.poll();
      res[l] = n.points;
    }

    return res;
  }

  class Node {
    int[] points;
    double disToOrg;

    Node(int[] points, double disToOrg) {
      this.points = points;
      this.disToOrg = disToOrg;
    }
  }
}
