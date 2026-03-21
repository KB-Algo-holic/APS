// PGM 181832 - 정수를 나선형으로 배치하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181832?language=java

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 1;  //채우는값
        int row = 0;    //현재 행 위치
        int col = 0;    //현재 열 위치
        int direction = 0;  //이동방향 0=우, 1=하, 2=상, 3=위
        
        while(value <= n*n){    //배열에 모두채워지면 종료
            answer[row][col] = value++;
            
            //다음이동계산
            if(direction == 0){ //우
                if(col == n-1 || answer[row][col + 1] != 0){
                    direction = 1;
                    row++;
                }else{
                    col++;
                }
            }else if(direction == 1){ //하
                if(row == n-1 || answer[row + 1][col] != 0){
                    direction = 2;
                    col--;
                }else{
                    row++;
                }
            }else if(direction == 2){ //좌
                if(col == 0 || answer[row][col - 1] != 0){
                    direction = 3;
                    row--;
                }else{
                    col--;
                }
            }else if(direction == 3){ //상
                if(row == 0 || answer[row - 1][col] != 0){
                    direction = 0;
                    col++;
                }else{
                    row--;
                }
            }
        }
        
        return answer;
    }
}
