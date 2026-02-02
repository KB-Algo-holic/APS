// PGM 42889 - 실패율
// 유형 : 문자열
https://school.programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] array = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            array[stages[i]]++;
        }
        double[] probability = new double[array.length];
        probability[1] = (double) array[1] / stages.length;
        int sum = 0;
        for (int i = 2; i < array.length - 1; i++) {
            sum += array[i - 1];
            if (stages.length - sum == 0) {
                probability[i] = 0.0;
            } else {
                probability[i] = (double) array[i] / (stages.length - sum);
            }
        }
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int maxIdx = 0;
            double maxFailureRate = -1.0;
            for (int j = 1; j <= N; j++) {
                if (probability[j] > maxFailureRate) {
                    maxFailureRate = probability[j];
                    maxIdx = j;
                }
            }
            answer[i] = maxIdx;
            probability[maxIdx] = -1.0;
        }
        return answer;
    }
}
