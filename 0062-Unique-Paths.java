class Solution {
    int[][] dp;
    int row;
    int col;

    public int uniquePaths(int m, int n) {

        row = m;
        col = n;

        dp = new int[m][n];

        return dfs(0, 0);
    }

    public int dfs(int r, int c) {

        if (r > row - 1 || c > col - 1) {
            return 0;
        }

        if (r == row - 1 && c == col - 1) {
            return 1;
        }

        if (dp[r][c] > 0) {
            return dp[r][c];
        }

        //down
        int down = dfs(r + 1, c);
        //right
        int right = dfs(r, c + 1);

        dp[r][c] = down + right;

        return dp[r][c];
    }
}
