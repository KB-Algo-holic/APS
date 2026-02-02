// PGM 키패드 누르기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/67256

import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int cur_left = -1; // 0 초기상태 > *
        int cur_right = -2; // 0 초기상태 > #
        int[][] pad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -2}};

        for (int num: numbers) {
            if (num == 1 || num == 4 || num == 7) {
                //왼손
                answer.append("L");
                cur_left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                //오른손
                answer.append("R");
                cur_right = num;
            } else {
                //체크
                int[] left_loc = findNum(cur_left, pad);
                int left_cnt = 0;
                int[] right_loc = findNum(cur_right, pad);
                int right_cnt = 0;
                int[] num_loc = findNum(num, pad);

                left_cnt += Math.abs(left_loc[0] - num_loc[0]) + Math.abs(left_loc[1] - num_loc[1]);
                right_cnt += Math.abs(right_loc[0] - num_loc[0]) + Math.abs(right_loc[1] - num_loc[1]);

                if (left_cnt < right_cnt) {
                    answer.append("L");
                    cur_left = num;
                } else if (right_cnt < left_cnt) {
                    answer.append("R");
                    cur_right = num;
                } else {// 동점
                    if (hand.equals("left")) {
                        answer.append("L");
                        cur_left = num;
                    } else {
                        answer.append("R");
                        cur_right = num;
                    }
                }
            }
        }

        return answer.toString();
    }
    public int[] findNum(int n, int[][] pad) {
        int[] location = new int[2];
        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                int num = pad[i][j];
                if (num == n) {
                    location[0] = i;
                    location[1] = j;
                    break;
                }
            }
        }
        return location;
    }

}