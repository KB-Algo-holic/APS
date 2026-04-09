// PGM - 42576 완주하지못한 선수
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java


import java.util.HashMap;

class Solution {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);

        for (String c : completion)
            map.put(c, map.get(c) - 1);

        for (var entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return entry.getKey();
        }

        return "";
    }
}