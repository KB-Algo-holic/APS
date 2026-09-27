// PGM 석유시추 - 250136
// DFS/BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {
    
    static private boolean[][] visit;
    static private Set<Integer> hash;
    static int x_size,y_size,sum,n_sum;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] oil;
    
    public int solution(int[][] land) {
        int answer = 0;
        x_size = land.length;
        y_size = land[0].length;
        visit = new boolean[x_size][y_size];
        oil = new int[y_size];
        
        for(int i=0;i<y_size;i++)
        {    
            sum = 0;
            
            for(int j=0;j<x_size;j++)
            {
                if(!visit[j][i] && land[j][i] != 0)
                {
                    n_sum = 1;
                    Queue<Integer[]> q = new LinkedList();
                    visit[j][i] = true;
                    q.add(new Integer[] {j,i});
                    hash = new HashSet<>();
                    bfs(land,q);
                    
                    for(Integer item : hash)
                    {
                        oil[item] = oil[item] + n_sum;
                    }
                    //System.out.println(j+" "+i+" "+n_sum);
                }
            }
           
        }
        
        for(int i=0;i<y_size;i++)
        {
            if(answer < oil[i])
                answer = oil[i];
        }
        
        return answer;
    }
    
    public void bfs(int[][] land, Queue<Integer[]> q)
    {
        while(!q.isEmpty())
        {
            int x = q.peek()[0];
            int y = q.peek()[1];
            hash.add(y);
            q.poll();

            for(int i=0;i<4;i++)
            {
                int ax = x+dx[i];
                int ay = y+dy[i];
                if(ax>=0 && ay>=0 && ax<x_size && ay<y_size)
                {
                    if(!visit[ax][ay] && land[ax][ay]!=0)
                    {
                        n_sum++;
                        visit[ax][ay] = true;
                        q.add(new Integer[]{ax,ay});
                    }
                }
            }
        }
    }
}
