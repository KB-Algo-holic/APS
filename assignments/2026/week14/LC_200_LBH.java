// Number of Islands
// DFS
// https://leetcode.com/problems/number-of-islands/

class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void DFS(char[][] grid, int row, int col) {
        grid[row][col] = '0';

        for(int d = 0; d < 4; d++) {
            int newRow = row + dir[d][0];
            int newCol = col + dir[d][1];

            if(0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length) {
                if(grid[newRow][newCol] == '1') {
                    DFS(grid, newRow, newCol);
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == '1') {
                    DFS(grid, r, c);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }
}