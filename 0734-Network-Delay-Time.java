class Solution {

  class Node {
    int cost;
    int neigh;

    Node(int neigh, int cost) {
      this.cost = cost;
      this.neigh = neigh;
    }
  }

  Map < Integer, List < Node >> adjList = null;
  PriorityQueue < Node > minHeap = null;
  Set < Integer > visited = null;
  public int networkDelayTime(int[][] times, int n, int k) {
    adjList = new HashMap < > ();
    minHeap = new PriorityQueue < > ((n1, n2) -> n1.cost - n2.cost);
    visited = new HashSet < > ();

    for (int i = 0; i < times.length; i++) {
      Node neigh = new Node(times[i][1], times[i][2]);
      List < Node > neighs = null;
      if (adjList.containsKey(times[i][0])) {
        neighs = adjList.get(times[i][0]);
      } else {
        neighs = new ArrayList < > ();
      }
      neighs.add(neigh);
      adjList.put(times[i][0], neighs);
    }

    Node start = new Node(k, 0);
    minHeap.add(start);
    return compute(n);
  }

  public int compute(int totalNodes) {

    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();

      if (!visited.contains(node.neigh)) {
        visited.add(node.neigh);
        if (visited.size() == totalNodes) {
          return node.cost;
        }
        if (adjList.containsKey(node.neigh)) {
          for (Node n: adjList.get(node.neigh)) {
            n.cost = node.cost + n.cost;
            minHeap.add(n);
          }
        }
      }

    }

    return -1;

  }

}
