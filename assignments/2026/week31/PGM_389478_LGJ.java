// PGM 389478 택배상자 꺼내기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/389478


import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n % w == 0 ? n / w : (n/w) +1;
        int[][] boxes = new int[h][w];
        int boxNum = 1;
        int[] target = new int[2];

        for (int r=0; r<h; r++) {
            boolean isRight = r % 2 == 0 ? true : false;

            if (isRight) {
                for (int c=0; c<w; c++) {
                    if (boxNum==num) {
                        target[0] = r;
                        target[1] = c;

                    }
                    if (boxNum > n) break;
                    boxes[r][c] = boxNum;
                    boxNum++;
                }
            } else {
                for (int c=w-1; c>=0; c--) {
                    if (boxNum==num) {
                        target[0] = r;
                        target[1] = c;

                    }
                    if (boxNum > n) break;
                    boxes[r][c] = boxNum;
                    boxNum++;
                }
            }
        }
        //System.out.println(Arrays.deepToString(boxes));

        int row = target[0];
        int col = target[1];

        for (int r=row; r<h; r++) {
            if (boxes[r][col] != 0) answer ++;

        }

        return answer;
    }
}