// PGM 87946 - 피로도
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/87946

import java.util.*;

class Solution {

    static int[] input, numbers;
    static int N, answer;
    static boolean[] chk;

    public int solution(int k, int[][] dungeons) {

        N = dungeons.length;
        input = new int[N];
        numbers = new int[N];
        chk = new boolean[N];
        answer = 0;

        for(int i = 0; i < dungeons.length; i++)
            input[i] = i;

        permutation(0,k,dungeons);

        return answer;
    }

    public static void permutation(int cnt, int k, int[][] dungeons){
        if(cnt == N){
            int result = 0;
            for(int i = 0; i < N; i++){
                int n = numbers[i];
                if(k >= dungeons[n][0]){
                    k-=dungeons[n][1];
                    result++;
                }
            }
            answer = Math.max(answer, result);
            return;
        }
        for(int i = 0; i < N; i++){
            if(chk[i]) continue;
            numbers[cnt] = input[i];
            chk[i] = true;
            permutation(cnt+1, k, dungeons);
            chk[i] = false;
        }
    }
}