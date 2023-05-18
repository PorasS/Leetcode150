class LRUCache {

  Map < Integer, CacheNode > cacheMap;

  CacheNode old;
  CacheNode latest;

  int cacheSize = 0;
  int capacity = 0;

  class CacheNode {
    CacheNode prev;
    int value;
    int key;
    CacheNode next;

    CacheNode(int key, int value) {
      this.key = key;
      this.value = value;
    };
  }

  public LRUCache(int capacity) {
    cacheMap = new HashMap < > ();
    this.capacity = capacity;
  }

  private void removeAndInsert(CacheNode node) {
    if (node.prev == null) {
      node.prev = latest;
      latest.next = node;
      CacheNode temp = node.next;
      node.next = null;
      temp.prev = null;
      latest = node;
      old = temp;
    } else if (node.prev != null && node.next != null) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.prev = latest;
      latest.next = node;
      node.next = null;
      latest = node;
    }
  }

  public int get(int key) {
    if (cacheMap.containsKey(key)) {
      CacheNode node = cacheMap.get(key);
      removeAndInsert(node);
      return node.value;
    }

    return -1;
  }

  public void put(int key, int value) {
    CacheNode node = new CacheNode(key, value);

    if (cacheMap.containsKey(key)) {
      CacheNode existingNode = cacheMap.get(key);
      existingNode.value = value;
      removeAndInsert(existingNode);
    } else {
      if (old == null && latest == null) {
        old = node;
        latest = node;
      } else {
        latest.next = node;
        node.prev = latest;
        latest = node;
      }

      if (capacity == cacheSize) {
        cacheMap.remove(old.key);
        CacheNode temp = old.next;
        old.next.prev = null;
        old.next = null;
        old = temp;
        cacheSize--;
      }

      cacheSize++;
      cacheMap.put(key, node);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
