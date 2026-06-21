// PGM 43238 - 입국심사
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java

import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1] * (long)n; 
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            for (int i = 0; i < times.length; i++)
                complete += mid / times[i];
            if (complete < n) 
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid; 
            }
        }  
        return answer;
    }
}
