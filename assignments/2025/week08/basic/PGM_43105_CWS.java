// PGM 43105 - 정수 삼각형
// 유형: 동적계획법
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43105
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j==0){//왼쪽 대각선 끝 계산
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == i){//오른쪽 대각선 끝 계산
                    triangle[i][j] += triangle[i-1][j-1];
                }else{//아래 두 방향 중 합이 더 큰값으로 계산
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            answer = Math.max(answer,triangle[n-1][i]);
        }
        return answer;
    }
}