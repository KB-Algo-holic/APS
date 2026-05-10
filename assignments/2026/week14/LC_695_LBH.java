// Max Area of Island
// DFS
// https://leetcode.com/problems/max-area-of-island/

class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int area = 0;
    int maxArea = 0;

    public void DFS(int[][] grid, int row, int col) {
        area++;
        grid[row][col] = 0;

        for(int d = 0; d < 4; d++) {
            int newRow = row + dir[d][0];
            int newCol = col + dir[d][1];

            if(0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length) {
                if(grid[newRow][newCol] == 1) {
                    DFS(grid, newRow, newCol);
                }
            }
        }

        if(maxArea < area) {
            maxArea = area;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1) {
                    area = 0;
                    DFS(grid, r, c);
                }
            }
        }

        return maxArea;
    }
}