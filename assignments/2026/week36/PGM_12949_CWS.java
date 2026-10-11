// PGM 12949 - 행렬의곱셈
// 행렬
// https://school.programmers.co.kr/learn/courses/30/lessons/12949

import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length, k = arr2.length, n = arr2[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int t = 0; t < k; t++)
                    answer[i][j] += arr1[i][t] * arr2[t][j];
        return answer;
    }
}