// PGM 42576 - 완주하지 못한 선수
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Boolean> map = new HashMap<>();

        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], true);
        }

        for(int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) == null) {
                return participant[i];
            }
        }

        return "";
    }
}