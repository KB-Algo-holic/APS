// PGM 161988 - 연속 펄스 부분 수열의 합
// 유형: 동적계획법
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/161988

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        for(int i = 0; i < sequence.length; i++) {
            sequence[i] = i % 2 == 0 ? sequence[i] : -sequence[i];
        }

        // min and max
        long minSum = sequence[0];
        long currentMinSum = sequence[0];
        long maxSum = sequence[0];
        long currentMaxSum = sequence[0];

        for(int i = 1; i < sequence.length; i++) {
            currentMaxSum = Math.max(sequence[i], currentMaxSum + sequence[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
            currentMinSum = Math.min(sequence[i], currentMinSum + sequence[i]);
            minSum = Math.min(minSum, currentMinSum);
        }

        return maxSum > -minSum ? maxSum : -minSum;
    }
}