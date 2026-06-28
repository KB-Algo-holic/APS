// [LC] 994 - Rotting Oranges
// https://leetcode.com/problems/rotting-oranges/

class Solution {
    public int orangesRotting(int[][] grid) {
        int ret = 0;
        int orange = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        for(int i = 0 ; i< grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1){
                    orange++;
                }
            }
        }
        if(orange == 0) return 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean flag = false;
            for(int k = 0 ; k < size; k++){
                int[] current = queue.poll();
                for(int i = 0 ;i < 4; i++){
                    int nx = current[0] + x[i];
                    int ny = current[1] + y[i];
                    if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        orange--;
                        flag = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            if(flag) ret++;
        }
        return orange == 0 ? ret : -1;
    }
}
