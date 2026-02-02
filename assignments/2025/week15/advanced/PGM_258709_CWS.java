// PGM 258709 - 주사위 고르기
// 유형: 조합
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/258709

import java.util.*;

class Solution {

    static int[][] sDice;     // 주어진 주사위 정보
    static int[] numbers, numbers2, input, diceA, diceB, answerArr;
    static int N, answer;

    public int[] solution(int[][] dice) {

        int n = dice.length;  // 주사위 개수
        answer = 0;
        sDice = dice;
        N = n;

        numbers = new int[N/2];   // A 주사위
        numbers2 = new int[N/2];  // B 주사위
        input = new int[n];       // 전체 주사위
        answerArr = new int[N/2]; // 최종 답

        for(int i = 1; i <= n; i++){
            input[i-1] = i; // 주사위 번호
        }
        combi(0,0); // A 조합 시작

        return answerArr;
    }
    public static void combi(int cnt, int start){

        // 주사위 합 배열
        diceA = new int[501];
        diceB = new int[501];

        if(cnt == N/2){
            int num = 0;
            int num2 = 0;
            for(int i = 1; i <= N; i++) {
                if (num < N / 2 && numbers[num] == i) {
                    num++;
                } else {
                    numbers2[num2] = i;
                    num2++;
                }
            }
            diceSumA(0,0);
            diceSumB(0,0);

            int win = 0; // A가 이긴 경우 수

            // 모든 조합 비교
            for(int i = 1; i< 501; i++){
                for(int j =1; j<501; j++){
                    if(i<j && diceA[j] > 0 && diceB[i] > 0){
                        // A > B 인 경우 경우의 수 곱해줌
                        win+= diceA[j] * diceB[i];
                    }
                }
            }

            if(answer < win){
                answer = win;
                answerArr = numbers.clone();
            }
            return;
        }

        for(int i = start; i < N; i++){
            numbers[cnt] = input[i];
            combi(cnt +1, i+1);
        }
    }

    // A 모든 경우의 수 카운트
    public static void diceSumA(int cnt, int num){
        if(cnt == N/2){
            diceA[num] += 1;
            return;
        }

        for(int i =0; i< 6; i++){
            diceSumA(cnt+1, sDice[numbers[cnt] -1][i] + num);
        }
    }

    // B 모든 경우의 수 카운트
    public static void diceSumB(int cnt, int num){
        if(cnt == N/2){
            diceB[num] += 1;
            return;
        }

        for(int i =0; i< 6; i++){
            diceSumB(cnt+1, sDice[numbers2[cnt] -1][i] + num);
        }
    }
}
