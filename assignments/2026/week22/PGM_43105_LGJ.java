// PGM - 43105 정수삼각형
// DP
// https://school.programmers.co.kr/learn/courses/30/lessons/43105

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;

        for (int i=1; i < height; i++) {
            int[] currentRow = triangle[i];
            int currentRowLength = currentRow.length;

            int[] beforeRow = triangle[i-1];
            int beforeRowLength = beforeRow.length;

            // 첫번째 인덱스
            currentRow[0] += beforeRow[0];
            // 마지막 인덱스
            currentRow[currentRowLength-1] += beforeRow[beforeRowLength-1];
            // 나머지 인덱스
            for (int j=1; j < currentRowLength-1; j++) {
                currentRow[j] = currentRow[j] + Math.max(beforeRow[j-1], beforeRow[j]);
            }
            // 마지막 행에서 최댓값 출력
            if (i == height-1) { answer = Arrays.stream(currentRow).max().getAsInt();  }
        }
        return answer;
    }
}
