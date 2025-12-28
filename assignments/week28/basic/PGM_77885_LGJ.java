// PGM - 2개 이하로 다른 비트
// 비트 연산
// https://school.programmers.co.kr/learn/courses/30/lessons/77885


class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            if ((x & 1L) == 0L) {
                // 짝수
                answer[i] = x + 1L;
            } else {
                // 홀수: (x+1) + ((x^(x+1)) >> 2)
                long diff = x ^ (x + 1L);
                answer[i] = (x + 1L) + (diff >> 2);
            }
        }
        return answer;
    }
}
