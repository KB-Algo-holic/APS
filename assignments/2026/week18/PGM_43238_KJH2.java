// PGM_43238 입국심사
// 이분탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/43238?language=java
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = 1;
        int max = 0;
        for(int x : times){
            if(x > max)
                max = x;
        }
        right = (long) max * n;
        
        while(left <= right){
            long mid = ( left + right ) / 2;
            long sum = 0;
            for(int time : times){
                sum += mid / time;
                if(sum >= n){
                    answer = mid;
                    right = mid - 1;
                    break;
                }
            }
            if( sum < n ){
                    left = mid + 1;
            }
        }
        return answer;
    }
}
