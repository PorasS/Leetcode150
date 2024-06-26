class Solution {
    public int minimumArea(int[][] grid) {

        //we need to find the height and the width for the 1's cell
        int n = grid.length;
        int m = grid[0].length;

        int x_min = n;
        int x_max = 0;
        int y_min = m;
        int y_max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    x_min = Math.min(x_min, i);
                    x_max = Math.max(x_max, i);
                    y_min = Math.min(y_min, j);
                    y_max = Math.max(y_max, j);
                }
            }
        }

        if(x_min <= x_max && y_min <= y_max){
            return (x_max - x_min + 1) * (y_max - y_min + 1);
        }

        return 0;
        
    }
}
