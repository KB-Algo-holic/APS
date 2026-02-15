// PGM 49994 - 방문 길이
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;

class Solution {
    public int solution(String dirs) {

        boolean[][] chk = new boolean[21][21];

        int x = 10;
        int y = 10;

        int answer = 0;

        for(int i = 0; i < dirs.length(); i++){
            int nx = x;
            int ny = y;

            if(dirs.charAt(i) == 'U'){
                ny += 2;
            }else if(dirs.charAt(i) == 'D'){
                ny -= 2;
            }else if(dirs.charAt(i) == 'L'){
                nx -= 2;
            }else{
                nx += 2;
            }

            // 좌표 범위를 벗어나면 이동 무시
            if (nx < 0 || nx > 20 || ny < 0 || ny > 20) continue;

            int mx = (x + nx) / 2;
            int my = (y + ny) / 2;

            if (!chk[mx][my]) {
                chk[mx][my] = true;
                answer++;
            }

            // 현재 위치 갱신
            x = nx;
            y = ny;
        }

        return answer;
    }
}
