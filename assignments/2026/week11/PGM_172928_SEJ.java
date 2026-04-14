// PGM 172928 - 공원 산책
// 4방 탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/172928

import java.util.*;
class Solution {
    char [][] map;
    int x = 0;
    int y = 0;
    Map <String, int[]> dirInfo = new HashMap<>();
    
    public int[] solution(String[] park, String[] routes) {
        // 1. 방향정의
        dirInfo.put("N", new int[]{-1,0});
        dirInfo.put("S", new int[]{1,0});
        dirInfo.put("E", new int[]{0,1});
        dirInfo.put("W", new int[]{0,-1});
        
        // 2. map 정의
        map = new char[park.length][park[0].length()];
        for(int i=0;i<park.length;i++){
            for(int j=0; j< park[0].length();j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j]=='S'){
                    x = i;
                    y = j;
                }
            }
        }
        
        for(int i=0;i<park.length;i++){
            for(int j=0; j< park[0].length();j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        
        // 이제 움직인다~!~!
        for(String r : routes){
            String[] order = r.split(" ");
            int[] dir = dirInfo.get(order[0]);
            
            boolean isPossible = true;
            int nx = x;
            int ny = y;
            for(int i=0;i< Integer.parseInt(order[1]) ; i++){
                // 간다.
                nx = nx + dir[0];
                ny = ny + dir[1];
                
                if(!inRange(nx, ny) || map[nx][ny] == 'X') {
                    isPossible = false;
                    break;
                };    
            }
            if(isPossible){
                x = nx;
                y = ny;
            }
        }
        return new int[]{x, y};
    }
    
    boolean inRange(int x, int y){
        int maxX = map.length;
        int maxY = map[0].length;
        return x>=0 && x<maxX && y>=0 && y<maxY;
    }
}