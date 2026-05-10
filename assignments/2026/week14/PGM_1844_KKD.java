# PGM 1844 - 게임 맵 최단거리
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844
import java.util.*;

class Solution {
    static private int[] dx = {1,-1,0,0};
    static private int[] dy = {0,0,1,-1};
    static private int x_size;
    static private int y_size;
    public int solution(int[][] maps) {
        int answer = 0;
        
        x_size = maps.length;
        y_size = maps[0].length;
        int[][] visit = new int[x_size][y_size];
        visit[0][0] = 1;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0,0,0});
        
        
        answer = bfs(visit,queue,maps);
        
        return answer;
    }
    
    public int bfs(int[][] visit, Queue<Integer[]> q,int[][] map)
    {
        if(q.isEmpty())
        {
            return -1;
        }

        int x = q.peek()[0];
        int y = q.peek()[1];
        int cnt = q.peek()[2];
        q.poll();
        //System.out.println(x+" "+y+" "+cnt);
        if(x == x_size-1 && y == y_size-1)
        {
            return cnt+1;
        }
        
        for(int i=0;i<4;i++)
        {
            int ax = x+dx[i];
            int ay = y+dy[i];
            if(ax >= 0 && ay >= 0 && ax<x_size && ay<y_size)
            {
                if(visit[ax][ay] == 0 && map[ax][ay] == 1)
                {
                    visit[ax][ay] = 1;
                    q.add(new Integer[]{ax,ay,cnt+1});
                }
            }
        }
        return bfs(visit,q,map);
    }
}
