// 미로 탈출 - 159993
// DFS/BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/159993#
import java.util.*;

class Solution {
    
    static private int[] dx = {1,-1,0,0};
    static private int[] dy = {0,-0,1,-1};
    static boolean[][] visit;
    static int x_size,y_size;
    static int result;
    static int l_x,l_y;
    static boolean isOk;
    
    public int solution(String[] maps) {
        int answer = 0;
        x_size = maps.length;
        y_size = maps[0].length();
        result = 0;
        Queue<Integer[]> q = new LinkedList();
        visit = new boolean[x_size][y_size];
        isOk = false;
        
        for(int i=0;i<x_size;i++)
        {
            for(int j=0;j<y_size;j++)
            {
                if(maps[i].charAt(j) == 'S')
                {
                    visit[i][j] = true;
                    q.add(new Integer[]{i,j,0});
                    bfs(q,maps,'L');
                    visit = new boolean[x_size][y_size];
                    visit[l_x][l_y] = true;
                    q.clear();
                    q.add(new Integer[]{l_x,l_y,result});
                    if(result == 0)
                        return -1;
                    
                    bfs(q,maps,'E');
                   // System.out.println(" ?? "+result);   
                }
            }
        }
        if(isOk == false)
            return -1;
        
        return result;
    }
    
    public void bfs(Queue<Integer[]> q, String[] maps, char d)
    {
        if(q.isEmpty())
            return;
        
        int x = q.peek()[0];
        int y = q.peek()[1];
        int cnt = q.peek()[2];
        q.poll();
        //System.out.println(x+" "+y+" "+cnt+" ");
        
        if(maps[x].charAt(y) == d)
        {
            result =  cnt;
            
            if(d == 'L')
            {
                l_x = x;
                l_y = y;
            }
            
            return;
        }
        
        for(int i=0;i<4;i++)
        {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if(ax >=0 && ay>=0 && ax<x_size && ay<y_size)
            {
                if(visit[ax][ay] == false && maps[ax].charAt(ay) != 'X')
                {
                    
                    visit[ax][ay] = true;
                    q.add(new Integer[] {ax,ay,cnt+1});  
                    if(maps[ax].charAt(ay) == 'E')
                        isOk = true;
                    
                }
            }
        }
        
        bfs(q,maps,d);
    }
}
