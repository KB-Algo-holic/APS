// PGM 17684 - [3차] 압축
// 해쉬
// https://school.programmers.co.kr/learn/courses/30/lessons/17684

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int cnt = 27;

        for(int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }

        for(int i = 0; i < msg.length(); i++) {
            String word = "" + msg.charAt(i);
            int index = map.get(word);

            for(int j = i + 1; j < msg.length(); j++) {
                word += msg.charAt(j);
                i = j - 1;
                if(map.get(word) == null) {
                    map.put(word, cnt++);
                    break;
                } else {
                    index = map.get(word);
                    if(j == msg.length() - 1) {
                        i = msg.length();
                    }
                }
            }

            answer.add(index);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}