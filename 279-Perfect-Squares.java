class Solution {
  public int numSquares(int n) {

    Queue < Node > queue = new LinkedList < > ();
    queue.add(new Node(n, n));
    int level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size--> 0) {
        Node el = queue.poll();
        if (el.remain == 0) {
          return level;
        }

        if (el.remain < 0) {
          continue;
        }

        for (int ps: findPerfectSquares(el.ps)) {
          int remain = el.remain - ps;
          queue.add(new Node(remain, ps));
        }

      }
      level++;
    }

    return level;
  }

  public List < Integer > findPerfectSquares(int num) {

    List < Integer > pSquares = new ArrayList < > ();

    int ps = 1;
    for (int i = 1; i <= num; i++) {
      ps = i * i;
      if (ps <= num) {
        pSquares.add(ps);
      }

      if (ps > num) {
        break;
      }
    }

    return pSquares;
  }

  class Node {
    public Node(int remain, int ps) {
      this.remain = remain;
      this.ps = ps;
    }
    int remain;
    int ps;
  }
}
