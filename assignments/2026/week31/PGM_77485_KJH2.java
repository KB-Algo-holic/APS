// PGM 77485 행렬 테두리 회전하기
// https://school.programmers.co.kr/learn/courses/30/lessons/77485
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int num = 1;
        int[][] square = new int[rows][columns];
        // 행렬 초기화
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < columns; j++){
                square[i][j] = num;
                num++;
            }
        }
        
        // 반복문 돌면서 회전하기
        for(int i = 0 ; i < queries.length; i++){
            int fromX = queries[i][0] - 1;
            int toX = queries[i][2] - 1;
            int fromY = queries[i][1] - 1;
            int toY = queries[i][3] - 1;
            
            int tmp = square[fromX][fromY];
            int min = tmp;
            // 오른쪽으로 이동
            for(int y = fromY + 1; y <= toY; y++){
                int next = square[fromX][y];
                square[fromX][y] = tmp;
                tmp = next;
                
                if(min > tmp)
                    min = tmp;
            }
            // 아래로 이동
            for(int x = fromX + 1; x <= toX; x++){
                int next = square[x][toY];
                square[x][toY] = tmp;
                tmp = next;
                
                if(min > tmp)
                    min = tmp;
            }
            // 왼쪽으로 이동
            for(int y = toY - 1; y >= fromY; y--){
                int next = square[toX][y];
                square[toX][y] = tmp;
                tmp = next;
                
                if(min > tmp)
                    min = tmp;
            }
            // 위로 이동
            for(int x = toX - 1; x >= fromX; x--){
                int next = square[x][fromY];
                square[x][fromY] = tmp;
                tmp = next;
                
                if(min > tmp)
                    min = tmp;
            }
            answer[i] = min;
        }
        
        return answer;
    }
}
