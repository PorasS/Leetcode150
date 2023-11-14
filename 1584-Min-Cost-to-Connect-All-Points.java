class Solution {
  class Node {
    int[] point;
    int cost;
    int index;

    Node(int index, int cost, int[] point) {
      this.point = point;
      this.cost = cost;
      this.index = index;
    }
  }

  PriorityQueue < Node > minHeap = null;
  Map < Integer, List < Node >> adjList = null;
  int cost = 0;
  Set < Integer > visited = null;
  int pointsLength = 0;
  public int minCostConnectPoints(int[][] points) {

    if (points.length == 1) {
      return 0;
    }

    minHeap = new PriorityQueue < > ((n1, n2) -> n1.cost - n2.cost);
    adjList = new HashMap < > ();
    visited = new HashSet < > ();
    pointsLength = points.length;

    for (int i = 0; i < pointsLength; i++) {
      int xi = points[i][0];
      int yi = points[i][1];
      for (int j = i + 1; j < pointsLength; j++) {
        int xj = points[j][0];
        int yj = points[j][1];

        int distance = Math.abs(xi - xj) + Math.abs(yi - yj);
        Node nodej = new Node(j, distance, points[j]);
        Node nodei = new Node(i, distance, points[i]);
        List < Node > nodeListi = null;
        if (adjList.containsKey(i)) {
          nodeListi = adjList.get(i);
        } else {
          nodeListi = new ArrayList < > ();
        }
        nodeListi.add(nodej);
        adjList.put(i, nodeListi);

        List < Node > nodeListj = null;
        if (adjList.containsKey(j)) {
          nodeListj = adjList.get(j);
        } else {
          nodeListj = new ArrayList < > ();
        }
        nodeListj.add(nodei);
        adjList.put(j, nodeListj);
      }
    }

    Node node = new Node(0, 0, points[0]);
    minHeap.add(node);
    minCost();
    return cost;
  }

  public void minCost() {
    while (!minHeap.isEmpty() && visited.size() != pointsLength) {
      Node node = minHeap.poll();
      int idx = node.index;

      if (!visited.contains(idx)) {
        visited.add(idx);
        cost += node.cost;
        for (Node n: adjList.get(idx)) {
          minHeap.add(n);
        }
      }
    }
  }
}
