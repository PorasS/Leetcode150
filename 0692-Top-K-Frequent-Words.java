class Solution {
  public List < String > topKFrequent(String[] words, int k) {

    Map < String, Integer > map = new HashMap < > ();
    for (String word: words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue < String > heap = new PriorityQueue < > (new Comparator < String > () {
      @Override
      public int compare(String word1, String word2) {
        int frequency1 = map.get(word1);
        int frequency2 = map.get(word2);
        if (frequency1 == frequency2) {
          return word2.compareTo(word1);
        }
        return frequency1 - frequency2;
      }
    });

    for (Map.Entry < String, Integer > entry: map.entrySet()) {
      heap.add(entry.getKey());
      if (heap.size() > k) {
        heap.poll();
      }
    }

    List < String > res = new ArrayList < > ();

    while (!heap.isEmpty()) {
      res.add(heap.poll());
    }

    Collections.reverse(res);

    return res;

  }
}
