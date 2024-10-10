class MedianFinder {

  PriorityQueue < Double > minHeap;
  PriorityQueue < Double > maxHeap;
  public MedianFinder() {
    minHeap = new PriorityQueue < > ();
    maxHeap = new PriorityQueue < > ((n1, n2) -> Double.compare(n2, n1));
  }

  public void addNum(int num) {
    double dnum = num;
    if (maxHeap.isEmpty()) {
      maxHeap.offer(dnum);
      return;
    }

    if (dnum > maxHeap.peek()) {
      minHeap.offer(dnum);
    } else {
      maxHeap.offer(dnum);
    }

    if (maxHeap.size() != minHeap.size()) {
      if (maxHeap.size() > minHeap.size()) {
        minHeap.offer(maxHeap.remove());
      } else {
        maxHeap.offer(minHeap.remove());
      }
    }
  }

  public double findMedian() {

    if (maxHeap.size() == minHeap.size()) {
      return (maxHeap.peek() + minHeap.peek()) / 2;
    }

    return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
