// PGM 181832 - 정수를 나선형으로 배치하기 - 기본
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181832

class Solution {
    public int[][] solution(int n) {
       int[][] answer = new int[n][n];
        
        int num = 1;       
        int rowStart = 0;  
        int rowEnd = n - 1; 
        int colStart = 0;  
        int colEnd = n - 1; 

        while (num <= n * n) { //컬럼증가 ,행증가, 컬럼감소, 행감소 ...
            // 컬럼증가
            for (int i = colStart; i <= colEnd; i++) {
                answer[rowStart][i] = num++;
            }
            rowStart++;   

            // 행증가
            for (int i = rowStart; i <= rowEnd; i++) {
                answer[i][colEnd] = num++;
            }
            colEnd--;  

            // 컬럼감소
            for (int i = colEnd; i >= colStart; i--) {
                answer[rowEnd][i] = num++;
            }
            rowEnd--;  

            // 행감소
            for (int i = rowEnd; i >= rowStart; i--) {
                answer[i][colStart] = num++;
            }
            colStart++;  
        }

        return answer;
    }
}
