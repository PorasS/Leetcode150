class Solution {
  public String replaceWords(List < String > dictionary, String sentence) {

    // 1. create a trie from dictionary
    // 2. check in trie
    // 3. if match use the smallest prefix, else use the whole word
    Node root = new Node();
    List < String > sortedDic = new ArrayList < > ();
    for (String str: dictionary) {
      int lr = 0;
      while (lr < str.length()) {
        String substr = str.substring(0, lr + 1);
        if (dictionary.contains(substr)) {
          if (!sortedDic.contains(substr)) {
            sortedDic.add(substr);
          }
          break;
        }
        lr++;
      }
    }
    dictionary = sortedDic;

    for (String word: dictionary) {
      addWordToTrie(root, word, dictionary);
    }

    //Create a sentence list
    int l = 0;
    int r = 0;
    List < String > sentenceList = new ArrayList < > ();
    while (r <= sentence.length()) {

      if (r == sentence.length()) {
        sentenceList.add(sentence.substring(l, r));
        break;
      }

      if (sentence.charAt(r) == ' ') {
        sentenceList.add(sentence.substring(l, r));
        r++;
        l = r;
      } else {
        r++;
      }
    }

    String res = "";

    for (String word: sentenceList) {
      res += checkInTrie(root, word, dictionary) + " ";
    }

    return res.substring(0, res.length() - 1);

  }

  public String checkInTrie(Node root, String word, List < String > dictionary) {
    Node[] nodes = root.nodes;

    int val = word.charAt(0) - 'a';
    if (nodes[val] == null) { //not exist in trie
      return word;
    }

    String str = "";
    for (int i = 0; i < word.length(); i++) {
      int chVal = word.charAt(i) - 'a';
      if (nodes[chVal] != null) {
        nodes = nodes[chVal].nodes;
      } else {
        str = word.substring(0, i);
        break;
      }
    }

    return dictionary.contains(str) ? str : word;
  }

  public void addWordToTrie(Node root, String word, List < String > dictionary) {
    Node[] nodes = root.nodes;
    int l = 0;
    while (l < word.length()) {
      int chVal = word.charAt(l) - 'a';
      if (nodes[chVal] == null) {
        Node node = new Node();
        nodes[chVal] = new Node();
        nodes = nodes[chVal].nodes;
      } else {
        nodes = nodes[chVal].nodes;
      }

      l++;
    }
  }

  class Node {
    Node[] nodes = null;
    Node() {
      nodes = new Node[26];
    }
  }

}
