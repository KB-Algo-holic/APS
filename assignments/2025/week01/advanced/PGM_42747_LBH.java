// PGM 42747 - H-Index
// 유형: 정렬
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int hIndex = citations.length - i;
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }

        return 0;
    }
}