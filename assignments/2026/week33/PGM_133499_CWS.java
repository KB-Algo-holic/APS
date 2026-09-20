// PGM 133499 - 옹알이2
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/133499

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] words = {"aya", "ye", "woo", "ma"};
        String[] repeats = {"ayaaya", "yeye", "woowoo", "mama"};

        for (String b : babbling) {
            boolean t = false;
            for (String r : repeats) {
                if (b.contains(r)) {
                    t = true;
                    break;
                }
            }
            if (t) continue;
            for (String w : words) {
                b = b.replace(w, " ");
            }

            if (b.trim().length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}