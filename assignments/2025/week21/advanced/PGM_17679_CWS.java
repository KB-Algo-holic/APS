// PGM 17679 - 프렌즈4블록
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;

class Solution {

    static char[][] map;
    static boolean[][] checked;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        checked = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        boolean t = true;

        // 블록이 더 이상 터지지 않을 때까지 반복
        while(t){
            t = false;

            // 오른쪽, 아래쪽, 오른아래쪽 체크
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j < n-1; j++){
                    if(map[i][j] != ' '
                            && map[i][j] == map[i+1][j]
                            && map[i][j] == map[i][j+1]
                            && map[i][j] == map[i+1][j+1]
                    ){
                        t = true; // 제거 대상 발견
                        checked[i][j] = true;
                        checked[i+1][j] = true;
                        checked[i][j+1] = true;
                        checked[i+1][j+1] = true;
                    }
                }
            }

            // 제거된 블록을 공백(' ')으로 변경
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(checked[i][j]){
                        map[i][j] = ' ';
                        answer++; // 제거된 블록 수 카운트
                    }
                }
            }

            // 블록이 아래로 떨어지는 처리
            for(int i = m-1; i > 0; i--){
                for(int j = 0; j < n; j++){
                    if(map[i][j] == ' '){
                        for(int k = i-1; k >= 0; k--){
                            if(map[k][j] != ' '){
                                // 위 블록을 아래로 내림
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }

            // 한 턴 끝나면 checked 배열 초기화
            if(t)
                checked = new boolean[m][n];
        }

        return answer;
    }


}