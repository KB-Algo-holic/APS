// PGM 161989 - 덧칠하기
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/161989

import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int painted = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] > painted) {
                answer++;
                painted = section[i] + m - 1;
            }
        }

        return answer;
    }
}}