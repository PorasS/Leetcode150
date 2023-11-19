class Solution {

  public class Node {
    int t;
    int r;
    int c;

    Node(int t, int r, int c) {
      this.t = t;
      this.r = r;
      this.c = c;
    }
  }

  Set < String > visited = null;
  PriorityQueue < Node > minHeap = null;
  public int swimInWater(int[][] grid) {
    visited = new HashSet < > ();
    minHeap = new PriorityQueue < > ((n1, n2) -> n1.t - n2.t);

    minHeap.add(new Node(grid[0][0], 0, 0));

    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      if (node.r == grid.length - 1 && node.c == grid[0].length - 1) {
        return node.t;
      }

      String cell = node.r + "" + node.c;
      if (!visited.contains(cell)) {
        visited.add(cell);
        //upper cell
        Node n = null;
        if (node.r + 1 < grid.length) {
          n = new Node(Math.max(node.t, grid[node.r + 1][node.c]), node.r + 1, node.c);
          minHeap.add(n);
        }

        //lower cell
        if (node.r - 1 >= 0) {
          n = new Node(Math.max(node.t, grid[node.r - 1][node.c]), node.r - 1, node.c);
          minHeap.add(n);
        }

        //right cell
        if (node.c + 1 < grid[0].length) {
          n = new Node(Math.max(node.t, grid[node.r][node.c + 1]), node.r, node.c + 1);
          minHeap.add(n);
        }

        //left cell
        if (node.c - 1 >= 0) {
          n = new Node(Math.max(node.t, grid[node.r][node.c - 1]), node.r, node.c - 1);
          minHeap.add(n);
        }
      }
    }

    return 0;
  }

}
