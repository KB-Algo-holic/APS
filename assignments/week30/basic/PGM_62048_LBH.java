// PGM 62048 - 멀쩡한 사각형
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/62048

import java.util.*;

class Solution {
    public long solution(int w, int h) {
        long answer = 0;

        for(double i = 1; i < w; i++) {

            long block = (long)((double)h * i / (double)w);

            answer += block * 2;
        }

        return answer;
    }
}