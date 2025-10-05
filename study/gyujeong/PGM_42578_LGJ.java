// PGM - 의상
// 해시 및 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42578


import java.util.*;

public class PGM_42578_LGJ {

    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> clothesMap = new HashMap<>();

            for (String[] clothe: clothes) {
                String category = clothe[1];
                if (clothesMap.get(category) == null) clothesMap.put(category, 2);
                else clothesMap.put(category, clothesMap.get(category)+1);
            }
            //System.out.println(clothesMap);

            for (String key: clothesMap.keySet()) {
                answer *= clothesMap.get(key);
            }

            return answer-1;
        }
    }
}
