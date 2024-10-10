class WordDictionary {

  Node root;
  public WordDictionary() {
    root = new Node();
  }

  public void addWord(String word) {
    Node curr = root;

    for (char ch: word.toCharArray()) {
      int idx = ch - 'a';
      if (curr.arr[idx] == null) {
        curr.arr[idx] = new Node();
      }
      curr = curr.arr[idx];
    }
    curr.isWord = true;
  }

  public boolean search(String word) {
    return searchAfterDot(word, root);
  }

  public boolean searchAfterDot(String word, Node root) {
    Node curr = root;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int idx = ch - 'a';
      if (ch == '.') {
        for (Node n: curr.arr) {
          if (n != null && searchAfterDot(word.substring(i + 1), n)) {
            return true;
          }
        }
        return false;
      } else {
        if (curr.arr[idx] == null) {
          return false;
        }

        curr = curr.arr[idx];
      }
    }

    return curr.isWord;
  }

  class Node {
    Node[] arr;
    boolean isWord;

    Node() {
      arr = new Node[27];
    }
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
