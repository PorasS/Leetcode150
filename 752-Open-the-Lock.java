class Solution {
  public int openLock(String[] deadends, String target) {

    int level = 0;
    int targetInt = Integer.parseInt(target);

    if (target.equals("0000")) {
      return level;
    }

    Set < String > visited = new HashSet < > ();
    for (String de: deadends) {
      if (de.equals("0000")) {
        return -1;
      }
      visited.add(de);
    }

    Queue < String > queue = new LinkedList < > ();
    queue.add("0000");

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size--> 0) { //run upto level, and add the neighbours to queue
        String start = queue.poll();
        if (visited.contains(start)) {
          continue;
        }
        visited.add(start);
        for (String str: neighbours(start)) {
          if (str.equals(target)) {
            return level + 1;
          }
          if (visited.contains(str)) {
            continue;
          }
          queue.add(str);
        }
      }
      level++;
    }

    return -1;
  }

  public Set < String > neighbours(String lock) {
    Set < String > set = new HashSet < > ();
    for (int i = 0; i < 4; i++) {
      char[] chars = lock.toCharArray();
      char c = chars[i];
      chars[i] = c == '9' ? '0' : (char)(c + 1);
      set.add(new String(chars));

      chars = lock.toCharArray();
      chars[i] = c == '0' ? '9' : (char)(c - 1);
      set.add(new String(chars));
    }

    return set;
  }
}
