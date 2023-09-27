class Solution {
  public void solve(char[][] board) {
    Set < String > visited = new HashSet < > ();

    // run a bfs on the outer rows and columns
    // add visited into the visited set
    // run a loop for inner zeros, those are not visited replace with 'X'

    // horizontal
    for (int i = 0; i < board[0].length; i++) {
      String cell = 0 + "::" + i;
      if (board[0][i] == 'O' && !visited.contains(cell)) {
        bfs(0, i, visited, board);
      }
      int brow = (board.length - 1);
      cell = brow + "::" + i;
      if (board[brow][i] == 'O' && !visited.contains(cell)) {
        bfs(brow, i, visited, board);
      }
    }

    //vertical
    for (int i = 0; i < board.length; i++) {
      String cell = i + "::" + 0;
      if (board[i][0] == 'O' && !visited.contains(cell)) {
        bfs(i, 0, visited, board);
      }

      int lCol = (board[0].length - 1);
      cell = i + "::" + lCol;
      if (board[i][lCol] == 'O' && !visited.contains(cell)) {
        bfs(i, lCol, visited, board);
      }
    }

    for (int i = 1; i < board.length - 1; i++) {
      for (int j = 1; j < board[0].length - 1; j++) {
        String rc = i + "::" + j;
        if (board[i][j] == 'O' && !visited.contains(rc)) {
          board[i][j] = 'X';
        }
      }
    }

  }

  public void bfs(int r, int c, Set < String > visited, char[][] board) {
    PriorityQueue < String > q = new PriorityQueue < > ();
    String cell = r + "::" + c;

    q.add(cell);

    while (!q.isEmpty()) {

      cell = q.poll();
      String[] args = cell.split("::");
      visited.add(cell);
      r = Integer.parseInt(args[0]);
      c = Integer.parseInt(args[1]);
      cell = r + "::" + (c + 1);
      if (r >= 0 && r < board.length && c + 1 >= 0 && c + 1 < board[0].length && board[r][c + 1] == 'O' && !visited.contains(cell)) {
        q.add(cell);
      }

      cell = r + "::" + (c - 1);
      if (r >= 0 && r < board.length && c - 1 >= 0 && c - 1 < board[0].length && board[r][c - 1] == 'O' && !visited.contains(cell)) {
        q.add(cell);
      }

      cell = (r + 1) + "::" + c;
      if (r + 1 >= 0 && r + 1 < board.length && c >= 0 && c < board[0].length && board[r + 1][c] == 'O' && !visited.contains(cell)) {
        q.add(cell);
      }

      cell = (r - 1) + "::" + c;
      if (r - 1 >= 0 && r - 1 < board.length && c >= 0 && c < board[0].length && board[r - 1][c] == 'O' && !visited.contains(cell)) {
        q.add(cell);
      }

    }
  }
}
