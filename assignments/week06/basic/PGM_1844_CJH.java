// PGM 1844 - 게임맵 최단거리
// 유형 : BFS
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Solution {

   public static int solution(int[][] maps) {
   
        int m = maps.length;
        int n = maps[0].length;
        
        int[][] visit = new int[m][n];

        int answer = bfs(maps,visit);
        return answer;
    }
    
    public static int bfs(int[][] maps, int [][] visit) {
    
        int [] dy = {1,-1,0,0};
        int [] dx = {0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        
        int [] start = new int[]{0,0,1};
        visit[start[0]][start[1]] = 1;
        queue.offer(start);
        
        while (!queue.isEmpty()) {
        
           int size  =  queue.size();
           
           for(int i = 0; i < size; i++) {
           
               int [] point = queue.poll();
               // (3)
               if(point[0] == maps.length -1 && point[1] == maps[0].length -1 ){
                    return point[2];
               }

               for(int j = 0; j < 4; j++) {
               
               	   // (4)
                   int newY = point[0] + dx[j];
                   int newX = point[1] + dy[j];
                   
                   if(newY > -1 && newY < maps.length
                           && newX > -1 && newX < maps[0].length
                           && maps[newY][newX] == 1
                           && visit[newY][newX] == 0) {

                       // (5)
                       queue.offer(new int[]{newY, newX,point[2]+1});
                       visit[newY][newX] = 1;
                   }
               }
           }
        }
           return -1;
    }
}