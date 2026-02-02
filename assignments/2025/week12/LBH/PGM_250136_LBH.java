// PGM 250136 - 석유시추
// DFS
// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {
    // DFS로 석유 크기를 구하고
    // 한 열마다 최댓값을 찾는다.

    int N;
    int M;

    int visited[][];

    int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};

    int size = 1;
    int numbering = 1;
    void computeOilSize(int i, int j, int[][] land){
        visited[i][j] = 1;
        for(int[] d : dir){
            int newI = i + d[0];
            int newJ = j + d[1];
            if(newI >= 0 && newI <= N - 1 && newJ >= 0 && newJ <= M - 1){
                if(visited[newI][newJ] == 0 && land[newI][newJ] == 1){
                    size++;
                    computeOilSize(newI, newJ, land);
                }
            }
        }
    }

    void setOilSize(int i, int j, int[][] land){
        visited[i][j] = size;
        land[i][j] = numbering;
        for(int[] d : dir){
            int newI = i + d[0];
            int newJ = j + d[1];
            if(newI >= 0 && newI <= N - 1 && newJ >= 0 && newJ <= M - 1){
                if(land[newI][newJ] > 0 && visited[newI][newJ] == 1){
                    setOilSize(newI, newJ, land);
                }
            }
        }
    }

    public int solution(int[][] land) {
        int answer = 0;

        N = land.length;
        M = land[0].length;

        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(land[i][j] > 0 && visited[i][j] == 0) {
                    computeOilSize(i, j, land);
                    setOilSize(i, j, land);
                    size = 1;
                    numbering++;
                }
            }
        }

        for(int j = 0; j < M; j++){
            int sum = 0;
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if(land[i][j] > 0 && !l.contains(land[i][j])){
                    l.add(land[i][j]);
                    sum += visited[i][j];
                    while(i < N - 1){
                        i++;
                        if(land[i][j] == 0){
                            i--;
                            break;
                        }

                    }
                }
            }
            if(answer < sum){
                answer = sum;
            }
        }

        return answer;
    }
}