// [LC] 542 01Matrix
// https://leetcode.com/problems/01-matrix/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] ret = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];

        for(int i = 0;i < mat.length;i++){
            for(int j = 0 ; j < mat[i].length; j++){
                if(mat[i][j] == 0){
                    que.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!que.isEmpty()){
            int[] now = que.poll();
            for(int i = 0;i < dirs.length; i++){
                int nx = now[0] + dirs[i][0];
                int ny = now[1] + dirs[i][1];

                if(nx >= 0 && nx < mat.length && ny >= 0 && ny < mat[0].length){
                    if(mat[nx][ny] == 1 && !visited[nx][ny] ){
                        visited[nx][ny] = true;
                        ret[nx][ny] = ret[now[0]][now[1]] + 1;
                        que.add(new int[] {nx, ny});
                    }
                }
            }
        }
    return ret;
    }
}
