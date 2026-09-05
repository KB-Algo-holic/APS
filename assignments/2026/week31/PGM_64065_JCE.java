// https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] parts = s.split("[{},]");
        Map<Integer, Integer> map = new HashMap<>();

        for  (String part : parts) {
            if (part.isEmpty()) continue;
            int num = Integer.parseInt(part);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] answer = new int[map.size()];

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            int num = entry.getKey();
            answer[cnt++] = num;
        }
        return answer;
    }
}
