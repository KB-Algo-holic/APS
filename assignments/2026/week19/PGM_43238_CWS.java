// PGM 43238 - 입국심사
// 이분탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/43238


class Solution {
    public long solution(int n, int[] times) {

        long maxTime = 0;
        for(long i : times){
            if(i > maxTime) maxTime = i;
        }

        long l = 1;
        long r = maxTime * n;
        long answer = r;

        while(l <= r){
            long sum = 0;
            long mid = l + (r-l)/2;

            for(long i : times){
                sum += mid/i;
                if(sum >= n){
                    break;
                }
            }

            if(sum >= n){
                answer = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }


        return answer;
    }
}