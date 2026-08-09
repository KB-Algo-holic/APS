// PGM 250136 석유시추 
// https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java
// bfs

import java.util.*;
import java.io.*;

class Solution {
    int N;
    int M;
    int[][] map;
    boolean[][] isVisited;
    Map<Integer, Integer> adj = new HashMap<>();
    Set<Integer> set;
    int result = 0;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    public int solution(int[][] land) {
        
        N = land.length;
        M = land[0].length;
        int num=1;
        
        map = new int[N][M];
        isVisited = new boolean[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j]==0) continue;
                if(isVisited[i][j]) continue;
                bfs(i,j,num,land);
                num+=1;
            }
        }
        int sum = 0;
        
        for(int j=0;j<M;j++){
            sum =0;
            set = new HashSet<>();
            for(int i=0;i<N;i++){
                int n = map[i][j];
                if(set.contains(n)) continue;
                if(!adj.containsKey(n)) continue;
                sum+=adj.get(n);
                set.add(n);
            }
            
           result = Math.max(result, sum);
        }
        
        
        
        
        return result;
        
    }
    
    public void bfs(int x, int y, int num, int[][] land){
        int sum=0;
        isVisited[x][y] = true;
        map[x][y] = num;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            sum+=1;
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(!inRange(nx, ny)) continue;
                if(isVisited[nx][ny]) continue;
                if(land[nx][ny] == 0) continue;
                
                isVisited[nx][ny] = true;
                map[nx][ny] = num;
                q.add(new int[]{nx,ny});
            }
        }
        
        adj.put(num, sum);
    }
    
    public boolean inRange(int x, int y){
        if(x<0 || y<0 || x>N-1 || y>M-1) return false;
        return true;
    }
    
    public void print(){
        for(int i=0;i<N;i++){
            for(int j=0; j<M;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
