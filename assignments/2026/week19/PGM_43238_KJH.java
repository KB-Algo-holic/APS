// PGM 43238 - 입국심사
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43238
import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
       
        long left = 1; 
        long right = (long) times[times.length - 1] * n;  
        
        long answer = right; 
         
        while (left <= right) {
            long mid = (left + right) / 2;  
            
            long totalPeople = 0; // 이 시간 동안 모든 심사관이 처리할 수 있는 총 사람 수
             
            for (int time : times) {
                totalPeople += (mid / time); 
            }
             
            if (totalPeople >= n) {
                answer = mid;        
                right = mid - 1;     
            } 
            // 목표한 n명보다 적게 처리했다면 
            else {
                left = mid + 1;     
            }
        }
        
        return answer;
    }
}
