class Solution {

  public Set < String > visited = null;
  public boolean exist(char[][] board, String word) {

    //search the location for the first char
    int r = 0;
    int c = 0;

    boolean res = false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          r = i;
          c = j;
          visited = new HashSet < > ();
          res = searchWordInGrid(r, c, word, 0, board);
          if (res) {
            return res;
          }
        }
      }
    }

    return res;
  }

  public boolean searchWordInGrid(int r, int c, String word, int idx, char[][] board) {

    if (idx >= word.length()) {
      return true;
    }

    boolean res = false;
    if (r >= board.length || r < 0 || c >= board[0].length ||
      c < 0 || visited.contains(r + "*" + (c)) ||
      board[r][c] != word.charAt(idx)) {
      return res;
    }

    visited.add(r + "*" + c);
    res = searchWordInGrid(r, c - 1, word, idx + 1, board) ||
      searchWordInGrid(r, c + 1, word, idx + 1, board) ||
      searchWordInGrid(r - 1, c, word, idx + 1, board) ||
      searchWordInGrid(r + 1, c, word, idx + 1, board);

    visited.remove(r + "*" + (c));
    return res;
  }
}
