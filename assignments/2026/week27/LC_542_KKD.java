// 01 Matrix
// 그래프탐색
// https://leetcode.com/problems/01-matrix/

class Solution {

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int x_size;
    private static int y_size;

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Integer[]> q = new LinkedList();
        
        x_size = mat.length;
        y_size = mat[0].length;
        boolean[][] visit = new boolean[x_size][y_size];
        int[][] answer = new int[x_size][y_size];


        for(int i=0;i<x_size;i++)
        {
            for(int j=0;j<y_size;j++)
            {
                if(mat[i][j] == 0)
                {
                    q.add(new Integer[]{i,j});
                    visit[i][j] = true;
                }
            }
        }

        while(!q.isEmpty())
        {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int cnt = answer[x][y];

            q.poll();

            for(int i=0;i<4;i++)
            {
                int ax = x + dx[i];
                int ay = y + dy[i];

                if(ax >= 0 && ay >= 0 && ax < x_size && ay < y_size)
                {
                    if(visit[ax][ay] == false)
                    {
                        q.add(new Integer[] {ax,ay});
                        visit[ax][ay] = true;
                        answer[ax][ay] = cnt+1;
                    }
                }
            }
        }

        return answer;
    }

    public void bfs(int ox,int oy, int[][] mat, Queue<Integer[]> q)
    {
        if(q.isEmpty())
        {
            return;
        }
        int x = q.peek()[0];
        int y = q.peek()[1];
        int cnt = q.peek()[2];

        if(mat[x][y]==0)
        {
            mat[ox][oy] = cnt;
            q.clear();
            return;
        }

        q.poll();

        for(int i=0;i<4;i++)
        {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if(ax >= 0 && ay >= 0 && ax < x_size && ay < y_size)
            {
                q.add(new Integer[] {ax,ay,cnt+1});
            }
        }
        bfs(ox,oy,mat,q);
    }
}
