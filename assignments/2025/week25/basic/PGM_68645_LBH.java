// PGM 68645 - 삼각 달팽이
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/68645

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(int)((n * (n + 1)) / 2)];

        int[][] snailArr = new int[n][n];
        int move = 0;
        int num = 1;
        int r = -1, c = 0;

        while(n > 0) {

            if(move == 0) {
                for(int i = 0; i < n; i++) {
                    snailArr[++r][c] = num++;
                }
            } else if(move == 1) {
                for(int i = 0; i < n; i++) {
                    snailArr[r][++c] = num++;
                }
            } else if(move == 2) {
                for(int i = 0; i < n; i++) {
                    snailArr[--r][--c] = num++;
                }
            }

            move++;
            move %= 3;

            n--;
        }

        int index = 0;
        for(int i = 0; i < snailArr.length; i++) {
            for(int j = 0; j < i + 1; j++) {
                answer[index++] = snailArr[i][j];
            }
        }

        return answer;
    }
}