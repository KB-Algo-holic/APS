// PGM 1844 - 게임 맵 최단거리
// 유형: BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/1844

import java.util.*;

class Pos {
    int x, y;
    int count;
    Pos(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {

    int[][] dir = {{-1,0}, {0,1}, {0,-1}, {1,0}};

    public int solution(int[][] maps) {
        int answer = -1;

        boolean[][] visited = new boolean[maps.length][];
        for(int i = 0; i < maps.length; i++) {
            visited[i] = new boolean[maps[0].length];
        }

        Queue<Pos> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Pos(maps.length, maps[0].length, 1));
        visited[maps.length - 1][maps[0].length - 1] = true;

        while(bfsQueue.size() > 0 && answer == -1){
            Pos nowPos = bfsQueue.poll();
            for(int[] direction : dir){
                int newPosX = nowPos.x + direction[0];
                int newPosY = nowPos.y + direction[1];

                if(newPosX == 1 && newPosY == 1) {
                    answer = nowPos.count + 1;
                    break;
                }

                if(1 <= newPosX && newPosX <= maps.length && 1 <= newPosY && newPosY <= maps[0].length) {
                    if(visited[newPosX - 1][newPosY - 1] == false && maps[newPosX - 1][newPosY - 1] == 1) {
                        bfsQueue.add(new Pos(newPosX, newPosY, nowPos.count + 1));
                        visited[newPosX - 1][newPosY - 1] = true;
                    }
                }
            }
        }

        return answer;
    }
}