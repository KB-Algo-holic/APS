// PGM 43238 - 입국심사
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
import java.util.*;

class Solution {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long left = 1;
        long right = (long)times[times.length-1] * n; // 60
        
        while (left <= right) {
            long mid = (left + right) / 2; // 중간 시간
            long count = 0;

            // mid 시간 동안 처리 가능한 총 인원 계산
            for (int time : times) {
                count += mid / time;
                if (count >= n) break; 
            }

            if (count >= n) {
                answer = mid; // 더 작은 시간을 탐색
                right = mid - 1;
            } else {
                left = mid + 1; // 시간증가
            }
        }

        return answer;
    }
}
