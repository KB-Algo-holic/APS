// PGM 12924 - 숫자의 표현
// 투포인터
// https://school.programmers.co.kr/learn/courses/30/lessons/12924?language=java


class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= n) {
            if (sum == n) {
                answer++;
                sum -= start;
                start++;
            } else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        return answer;
    }
}