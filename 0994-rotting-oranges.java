class Solution {
  Queue < String > q = null;
  Set < String > visited = null;

  int fresh = 0;
  public int orangesRotting(int[][] grid) {

    q = new LinkedList < > ();
    visited = new HashSet < > ();

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          String cell = i + "::" + j + "::" + 0;
          q.add(cell);
        }
        if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }

    return fresh == 0 ? 0 : bfs(grid);
  }

  public int bfs(int[][] grid) {
    int maxTime = -1;
    while (!q.isEmpty()) {
      String cell = q.poll();
      String args[] = cell.split("::");
      int r = Integer.parseInt(args[0]);
      int c = Integer.parseInt(args[1]);
      int time = Integer.parseInt(args[2]);

      cell = r + "::" + (c + 1);
      if (!visited.contains(cell) && r >= 0 && r < grid.length && c + 1 >= 0 && c + 1 < grid[0].length && grid[r][c + 1] == 1) {
        grid[r][c + 1] = 2;
        fresh--;
        int newTime = time + 1;
        maxTime = Math.max(maxTime, newTime);
        visited.add(cell);
        cell = cell + "::" + newTime;
        q.add(cell);
      }

      cell = r + "::" + (c - 1);
      if (!visited.contains(cell) && r >= 0 && r < grid.length && c - 1 >= 0 && c - 1 < grid[0].length && grid[r][c - 1] == 1) {
        grid[r][c - 1] = 2;
        fresh--;
        int newTime = time + 1;
        maxTime = Math.max(maxTime, newTime);
        visited.add(cell);
        cell = cell + "::" + newTime;
        q.add(cell);
      }

      cell = (r + 1) + "::" + c;
      if (!visited.contains(cell) && r + 1 >= 0 && r + 1 < grid.length && c >= 0 && c < grid[0].length && grid[r + 1][c] == 1) {
        grid[r + 1][c] = 2;
        fresh--;
        int newTime = time + 1;
        maxTime = Math.max(maxTime, newTime);
        visited.add(cell);
        cell = cell + "::" + newTime;
        q.add(cell);
      }

      cell = (r - 1) + "::" + c;
      if (!visited.contains(cell) && r - 1 >= 0 && r - 1 < grid.length && c >= 0 && c < grid[0].length && grid[r - 1][c] == 1) {
        grid[r - 1][c] = 2;
        fresh--;
        int newTime = time + 1;
        maxTime = Math.max(maxTime, newTime);
        visited.add(cell);
        cell = cell + "::" + newTime;
        q.add(cell);
      }
    }

    return fresh == 0 ? maxTime : -1;
  }
}
