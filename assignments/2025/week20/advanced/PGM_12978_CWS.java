// PGM 12978 - 배달
// 유형: BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;

class Solution {

    static boolean[] chk;
    static int[][] map;
    static int[] answerArr;
    static int[] shortArr;
    static int k, sumTime;

    public int solution(int N, int[][] road, int K) {

        k = K;
        map = new int[N+1][N+1];
        answerArr = new int[N+1];
        shortArr = new int[N+1];
        sumTime = 0;

        // 정보 저장
        for(int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            if(map[a][b] == 0){
                map[a][b] = map[b][a] = c;
            }else{
                if(map[a][b] > c){
                    map[a][b] = map[b][a] = c;
                }
            }
        }

        // 1번 부터 전부 이동 탐색
        for(int i = 0; i < map.length; i++){
            chk = new boolean[N+1];
            chk[1] = true;
            if(map[1][i] != 0){ // 도로가 존재시 이동
                move(i, map[1][i]);
            }
        }

        // 배달 가능하면 카운트
        int answer = 1;
        for(int num : answerArr){
            if(num == 1){
                answer++;
            }
        }

        return answer;
    }

    public static void move(int city, int time){
        // 배달 시간 초과 또는 방문한 마을이면 리턴
        if(sumTime + time > k || chk[city]){
            return;
        }


        if(shortArr[city] == 0){
            shortArr[city] = sumTime + time;
        }else{
            // 기존 최단 거리보다 길면 중단
            if(shortArr[city] < sumTime + time)
                return;
        }

        answerArr[city] = 1;

        for(int i = 0; i < map.length; i++){
            if(map[city][i] != 0){
                chk[city] = true;
                sumTime += time;
                move(i, map[city][i]);
                chk[city] = false;
                sumTime -= time;
            }
        }
    }


}