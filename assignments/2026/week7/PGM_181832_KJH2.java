// PGM_181832 정수를 나선형으로 배치하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181832

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int top = 0;
        int bottom = n;
        int left = 0;
        int right = n;
        int val = 1;
        while(val <= n * n){
            //왼쪽 이동
            for(int i = left; i < right; i++){
                answer[top][i] = val++;
            }
            top++;
            //아래 이동
            for(int i = top; i < bottom; i++){
                answer[i][right - 1] = val++;
            }
            right--;
            //오른쪽 이동
            for(int i = right - 1;i >= left; i--){
                answer[bottom - 1][i] = val++;
            }
            bottom--;
            //위 이동
            for (int i = bottom - 1; i >= top; i--){
                answer[i][left] = val++;
            }
            left++;
        }
        return answer;
    }
}