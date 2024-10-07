class Trie {

  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode curr = root;
    for (char ch: word.toCharArray()) {
      int idx = ch - 'a';
      if (curr.arr[idx] == null) {
        TrieNode newNode = new TrieNode();
        newNode.str = curr.str + ch;
        curr.arr[idx] = newNode;
        curr = curr.arr[idx];
      } else {
        curr = curr.arr[idx];
      }
    }

    curr.isWord = true;
  }

  public boolean search(String word) {
    TrieNode curr = root;
    for (char ch: word.toCharArray()) {
      int idx = ch - 'a';

      if (curr.arr[idx] == null) {
        return false;
      } else {
        curr = curr.arr[idx];
      }
    }

    return curr.isWord;

  }

  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (char ch: prefix.toCharArray()) {
      int idx = ch - 'a';

      if (curr.arr[idx] == null) {
        return false;
      } else {
        curr = curr.arr[idx];
      }
      if (curr.str.equals(prefix)) {
        return true;
      }
    }
    return false;
  }
}

class TrieNode {
  TrieNode[] arr;
  String str = "";
  boolean isWord;
  TrieNode() {
    arr = new TrieNode[26];
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
