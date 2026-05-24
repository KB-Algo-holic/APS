// PGM 178870 - 연속된 부분 수열의 합
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/178870?language=java

public class PGM_178870_PST {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];

            int left = 0;
            int current = 0;
            int n = sequence.length;
            int length = Integer.MAX_VALUE;

            for (int right = 0; right < n; right++) {
                current += sequence[right];

                while (current > k) {
                    current -= sequence[left];
                    left++;
                }

                if (current == k) {
                    int currentLength = right - left + 1;

                    if (currentLength < length) {
                        length = currentLength;
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
            }

            return answer;
        }
    }
}
