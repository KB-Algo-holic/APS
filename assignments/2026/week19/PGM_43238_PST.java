// PGM 43238 - 입국심사
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java

import java.util.Arrays;

public class PGM_43238_PST {
    class Solution {
        public long solution(int n, int[] times) {

            Arrays.sort(times);

            long left = 1;
            long right = (long) times[times.length - 1] * n;
            long answer = right;

            while (left <= right) {
                long mid = (left + right) / 2;
                long totalPassed = 0;

                for (int time : times) {
                    totalPassed += mid / time;

                    if (totalPassed >= n) {
                        break;
                    }
                }
                if (totalPassed >= n) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return answer;
        }
    }
}

