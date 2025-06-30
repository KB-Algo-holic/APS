// PGM 42576 - 완주하지 못한 선수
// 유형 : 해시
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42576


import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        for (String pc : participant) {
            int cnt = 0;
            for (String p : participant) {
                if (pc.equals(p)) {
                    cnt++;
                }
            }
            for (String c : completion) {
                if (pc.equals(c)) {
                    cnt--;
                }
            }
            if (cnt > 0) {
                return pc;
            }
        }
        return "";
    }
}
