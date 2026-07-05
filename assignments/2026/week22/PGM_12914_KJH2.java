// PGM 12914 멀리뛰기
// 피보나치수열
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
class Solution {
    public long solution(int n) {
        long answer = 1;
        int x_2 = 1;
        int x_1 = 1;
        for(int i = 2; i <= n; i++){
            int x = (x_2 + x_1) % 1234567;
            answer = x;
            x_2 = x_1;
            x_1 = x;
        }
         return answer;
    }
}
