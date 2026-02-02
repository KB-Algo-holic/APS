// PGM 42747 - H-index
// 유형: 정렬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java


import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;  // h번 이상 인용된 논문 개수
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}