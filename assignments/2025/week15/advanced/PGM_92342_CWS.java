// PGM 92342 - 양궁대회
// 유형: 조합
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92342

import java.util.*;

class Solution {

    static int[] numbers, input, sinfo, answerArr, arr;
    static int N, answer;

    public int[] solution(int n, int[] info) {
        arr = new int[11];
        answerArr = new int[11];
        sinfo = info;
        N = n;
        answer = 0;

        numbers = new int[11];
        input = new int[11];

        for(int i = 0; i < 11; i++){
            input[i] = i;
        }

        // 1점부터 11점까지 쏠 수 있는 모든 조합 탐색
        for(int i = 1; i <= 11; i++){
            combi(0, 0, i);
        }

        // 승리 못하는 경우
        if(answer == 0){
            answerArr = new int[1];
            answerArr[0] = -1;
        }

        return answerArr;
    }

    public static void combi(int cnt, int start, int t){
        // t개 뽑았으면 점수 계산
        if(cnt == t){
            int tempN = N;
            arr = new int[11];

            // 선택한 점수 구간에 어피치보다 1발 더 쏘기
            for(int i = 0; i < t; i++){
                int scoreIndex = numbers[i];
                int arrowsToWin = sinfo[scoreIndex] + 1;
                arr[scoreIndex] = arrowsToWin;
                tempN -= arrowsToWin;
            }

            if(tempN < 0)
                return;

            // 남은 화살은 0점에 몰아주기
            arr[10] += tempN;

            int a = 0; // 어피치 점수
            int r = 0; // 라이언 점수

            // 점수 계산
            for(int i = 0; i < 11; i++){
                if (sinfo[i] == 0 && arr[i] == 0) continue;
                if(sinfo[i] >= arr[i]){
                    a += 10 - i;
                } else {
                    r += 10 - i;
                }
            }

            // 라이언이 이긴 경우
            if(r > a){
                int diff = r - a;
                if(answer < diff){
                    answer = diff;
                    answerArr = arr.clone();
                } else if (answer == diff) {
                    // 점수 차이가 같으면 낮은 점수(인덱스 10부터) 많이 맞춘 경우 선택
                    for(int i = 10; i >= 0; i--){
                        if(arr[i] > answerArr[i]){
                            answerArr = arr.clone();
                            break;
                        } else if (arr[i] < answerArr[i]) {
                            break;
                        }
                    }
                }
            }
            return;
        }

        // 조합 탐색
        for(int i = start; i < 11; i++){
            numbers[cnt] = input[i];
            combi(cnt + 1, i + 1, t);
        }
    }
}
