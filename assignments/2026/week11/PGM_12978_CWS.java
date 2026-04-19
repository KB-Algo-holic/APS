// PGM 12978 - 배달
// 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.*;

class Solution {

    static boolean[] chk;
    static int[][] map;
    static int[] answerArr, shortArr;
    static int k, sumTime;

    public int solution(int N, int[][] road, int K) {

        k = K;
        map = new int[N+1][N+1];
        answerArr = new int[N+1];
        shortArr = new int[N+1];
        sumTime = 0;
        for(int i = 0; i < road.length; i++){
            if(map[road[i][0]][road[i][1]] == 0){
                map[road[i][0]][road[i][1]] = map[road[i][1]][road[i][0]] = road[i][2];
            }else{
                if(map[road[i][0]][road[i][1]] > road[i][2]){
                    map[road[i][0]][road[i][1]] = map[road[i][1]][road[i][0]] = road[i][2];
                }
            }
        }

        for(int i = 0; i < map.length; i++){
            chk = new boolean[N+1];
            chk[1] = true;
            if(map[1][i] != 0){
                move(i, map[1][i]);
            }
        }

        int answer = 1;
        for(int num : answerArr){
            if(num == 1){
                answer++;
            }
        }

        return answer;
    }

    public static void move(int city, int time){
        if(sumTime + time > k || chk[city]){
            return;
        }

        if(shortArr[city] == 0){
            shortArr[city] = sumTime + time;
        }else{
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