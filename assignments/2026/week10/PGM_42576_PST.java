// PGM 42576 - 완주하지 못한 선수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;

public class PGM_42576_PST {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            HashMap<String, Integer> map = new HashMap<>();

            for (String part : participant) {
                map.put(part, (map.containsKey(part))? map.get(part) + 1 : 1);
            }

            for (String part : completion) {
                map.put(part, map.get(part) - 1);
            }

            for (String key : map.keySet()) {
                if (map.get(key) != 0) {
                    answer = key;
                    break;
                }
            }

            return answer;
        }
    }
}
