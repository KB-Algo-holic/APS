import java.util.*;
class Solution {
    static private boolean[][] visit;
    static private int x_size;
    static private int y_size;
    static private int[] dx = {1,-1,0,0};
    static private int[] dy = {0,0,1,-1};
    public int solution(String[] board) {
        int answer = 0;
        x_size = board.length;
        y_size = board[0].length();
        char[][] map = new char[x_size][y_size];
        visit = new boolean[x_size][y_size];
        int sx=0;
        int sy=0;
        Queue<Integer[]> q = new LinkedList();
        
        for(int i=0;i<x_size;i++)
        {
            String tmp = board[i];
            for(int j=0;j<y_size;j++)
            {
                if(tmp.charAt(j) == 'R')
                {
                    sx = i;
                    sy = j;
                }
                map[i][j] = tmp.charAt(j);
            }
        }
        q.add(new Integer[] {sx,sy,0});
        visit[sx][sy] = true;
        answer = bfs(map,q);
        
        return answer;
    }
    
    public int re_X(int x,int y,int d,char[][] map)
    {
        if(d>1)
            return x;
        while(true)
        { 
            if(x<0 || x>=x_size || map[x][y] == 'D' )
                break;
            x = x+dx[d];
        }
        
        return x-dx[d];
    }
    
    public int re_Y(int x,int y,int d,char[][] map)
    {
        if(d<2)
            return y;
        while(true)
        {
            if( y<0 || y>=y_size || map[x][y] == 'D')
                break;
                
            y = y+dy[d];
        }
        
        return y-dy[d];
    }
    
    public int bfs(char[][] map,Queue<Integer[]> q)
    {
        if(q.isEmpty())
        {
            return -1;
        }
        int x = q.peek()[0];
        int y = q.peek()[1];
        int cnt = q.peek()[2];
        //System.out.println(x+" "+y+" "+cnt);
        q.poll();
        if(map[x][y]=='G')
        {
            return cnt;
        }
        
        for(int i=0;i<4;i++)
        {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if(ax>=0 && ax<x_size && ay>=0 && ay<y_size)
            {
                if(map[ax][ay] !='D')
                {
                    ax = re_X(ax,ay,i,map);
                    ay = re_Y(ax,ay,i,map);
                    if(!visit[ax][ay])
                    {
                        visit[ax][ay] = true;
                        q.add(new Integer[] {ax,ay,cnt+1});
                    }
                }
            }        
        }
        return bfs(map,q);
    }
}
