https://leetcode.com/problems/kth-largest-element-in-a-stream/solutions/5850679/easy-java-solution-minheap-of-size-k-with-explanation
class KthLargest {

  int k;
  PriorityQueue < Integer > minHeap;
  public KthLargest(int k, int[] nums) {
    this.k = k;

    minHeap = new PriorityQueue < > ();

    if (nums.length != 0) {
      for (int i = 0; i < nums.length; i++) {
        minHeap.add(nums[i]);
      }

      int diff = minHeap.size() - k;

      for (int i = 0; i < diff; i++) {
        minHeap.remove();
      }
    }

  }

  public int add(int val) {
    minHeap.add(val); //O(log n) adding an element in a queue

    if (minHeap.size() > k) {
      minHeap.remove();
    }

    return minHeap.peek(); //O(1) fetching the first element 
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
