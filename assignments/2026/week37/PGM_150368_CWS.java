// PGM 150368 - 이모티콘 할인행사
// 완전탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/150368

import java.util.*;

class Solution {

    static int[][] USERS;
    static int[] numbers = {10,20,30,40};
    static int[] input, EMOTICONS, temp;
    static int N, R, answer1, answer2;


    public int[] solution(int[][] users, int[] emoticons) {

        USERS = users;
        Arrays.sort(emoticons);
        EMOTICONS = emoticons;
        R = emoticons.length;
        N = numbers.length;
        input = new int[emoticons.length];
        temp = new int[emoticons.length];

        per(0);

        int[] answer = {answer1, answer2};
        return answer;
    }

    public static void per(int cnt){
        if(cnt == R){
            for(int i = 0; i < R; i++){
                temp[i] = EMOTICONS[i] - EMOTICONS[i] / 100 * input[i];
            }
            int tempAnswer1 = 0;
            int tempAnswer2 = 0;

            for(int i = 0; i < USERS.length; i++){
                int sum = 0;
                for(int j = 0; j < EMOTICONS.length; j++){
                    if(input[j] >= USERS[i][0]){
                        sum += temp[j];
                    }
                }
                if(sum >= USERS[i][1]){
                    tempAnswer1++;
                }else{
                    tempAnswer2 += sum;
                }
            }
            if(answer1 < tempAnswer1){
                answer1 = tempAnswer1;
                answer2 = tempAnswer2;
            }else if(answer1 == tempAnswer1){
                if(answer2 < tempAnswer2){
                    answer2 = tempAnswer2;
                }
            }
            return;
        }
        for(int i = 0; i < N; i++){
            input[cnt] = numbers[i];
            per(cnt + 1);
        }
    }

}