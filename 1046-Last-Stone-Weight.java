https://leetcode.com/problems/last-stone-weight/solutions/5854768/easy-java-solution-with-explanation
class Solution {
  public int lastStoneWeight(int[] stones) {

    PriorityQueue < Integer > maxHeap = new PriorityQueue < > (Collections.reverseOrder());

    for (int i = 0; i < stones.length; i++) {
      maxHeap.offer(stones[i]);
    }

    while (maxHeap.size() > 1) {
      int x = maxHeap.poll();
      int y = maxHeap.poll();
      if (x != y) {
        y = Math.abs(y - x);
        maxHeap.offer(y);
      }
    }

    return maxHeap.size() != 0 ? maxHeap.poll() : 0;
  }
}
