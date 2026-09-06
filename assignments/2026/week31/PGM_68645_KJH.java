// PGM 68645 - 삼각달팽이
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
class Solution {
    public int[] solution(int n) {
        
        int[][] triangle = new int[n][n];
        int totalCount = n * (n + 1) / 2;
        int[] answer = new int[totalCount];

        int row = -1;  
        int col = 0;
        int num = 1;
 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    row++;          // 아래로 이동
                } else if (i % 3 == 1) {
                    col++;          // 오른쪽으로 이동
                } else {
                    row--;          // 대각선 위로 이동
                    col--;
                }
                triangle[row][col] = num++;
            }
        }
 
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}
