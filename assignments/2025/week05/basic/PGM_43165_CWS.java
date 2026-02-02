// PGM 43165 - 타겟 넘버
// 유형: DFS/BFS
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165

import java.util.*;

class Solution {
    private static int N, R, total, target, answer;
    private static int[] number, input;
    private static boolean[] isSelected;
    public int solution(int[] numbers, int target) {

        N = numbers.length;
        input = new int[N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            input[i] = numbers[i];
            total += numbers[i];
        }

        for(int i = 1; i < N ; i++){
            R = i;
            isSelected = new boolean[N + 1];
            number = new int[R];
            combination(0, 0, target);
        }


        return answer;
    }

    private static void combination(int cnt, int start, int target) {

        if (cnt == R) {
            int sum = 0;
            for(int i = 0; i < R; i++){
                sum += number[i] * 2;
            }

            if(target == total - sum){

                answer++;
            }

            return;
        }

        for (int i = start; i < N; i++) {
            number[cnt] = input[i];
            combination(cnt + 1, i + 1, target);
        }
    }
}