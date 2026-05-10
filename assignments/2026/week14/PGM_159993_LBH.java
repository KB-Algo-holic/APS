// 미로 탈출
// BFS
// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.*;

class Solution {

    // if 'O' == 4방향 추가
    // visited > count, 밖으로 나가지 않는다면 추가
    // start -> lever + lever -> end
    // BFS 두 번 사용

    Pos start;
    Pos lever;

    int[][] visited;
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

    int BFS(String[] maps, Pos start, char target){

        Queue<Pos> bfsQueue = new LinkedList<>();

        bfsQueue.add(start);

        for(int[] row : visited)
            Arrays.fill(row, Integer.MAX_VALUE);

        while(true){
            Pos front = bfsQueue.poll();

            if(front == null)
                return -1;

            if(maps[front.row].charAt(front.col) == target){
                return front.count;
            }

            // 밖으로 나가지 않고, 벽이 아니고, visited[row][col]보다 작을 때
            for(int i = 0; i < 4; i++){
                Pos newPos = new Pos(front.row + dir[i][0], front.col + dir[i][1], front.count + 1);

                if(newPos.row >= 0 && newPos.col >= 0 && newPos.row < maps.length && newPos.col < maps[0].length()){
                    if(visited[newPos.row][newPos.col] > newPos.count){
                        if(maps[newPos.row].charAt(newPos.col) != 'X'){
                            visited[newPos.row][newPos.col] = newPos.count;
                            bfsQueue.add(new Pos(newPos.row, newPos.col, newPos.count));
                        }
                    }
                }
            }

        }
    }

    public int solution(String[] maps) {

        visited = new int[maps.length][];
        for(int i = 0; i < maps.length; i++){
            visited[i] = new int[maps[i].length()];
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new Pos(i, j, 0);
                }
                if(maps[i].charAt(j) == 'L'){
                    lever = new Pos(i, j, 0);
                }
            }
        }

        int startToLever = BFS(maps, start, 'L');
        int leverToEnd = BFS(maps, lever, 'E');

        if(startToLever == -1 || leverToEnd == -1)
            return -1;

        return startToLever + leverToEnd;
    }

    class Pos{
        int row;
        int col;
        int count;

        Pos(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}