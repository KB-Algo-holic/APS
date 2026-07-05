// PGM 43105 - 정수 삼각형
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
               if(j == 0) {
                   triangle[i][j] += triangle[i-1][j];
               } else if(i == j) {
                   triangle[i][j] += triangle[i-1][j-1];
               } else {
                   triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
               }
            }
        }
        
        for(int j = 0; j < n; j++) {
            answer = Math.max(triangle[n-1][j], answer);
        }
        
        return answer;
    }
}
