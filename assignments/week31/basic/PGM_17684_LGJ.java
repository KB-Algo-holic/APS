// PGM - 17684 3차 압축
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/17684?language=java

import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        int nextIdx = 1;

        // 1) 사전 초기화: A~Z => 1~26
        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put(String.valueOf(c), nextIdx++);
        }

        List<Integer> output = new ArrayList<>();

        int i = 0;
        while (i < msg.length()) {
            // 2) i에서 시작하는 "사전에 있는 가장 긴 문자열 w" 찾기
            String w = String.valueOf(msg.charAt(i));
            int j = i + 1;

            while (j <= msg.length()) {
                String candidate = msg.substring(i, j);
                if (dict.containsKey(candidate)) {
                    w = candidate;
                    j++;
                } else {
                    break;
                }
            }

            // w의 인덱스 출력
            output.add(dict.get(w));

            // 3) w 다음 글자가 존재하면 w + nextChar 를 사전에 추가
            int wLen = w.length();
            if (i + wLen < msg.length()) {
                String newEntry = msg.substring(i, i + wLen + 1);
                if (!dict.containsKey(newEntry)) {
                    dict.put(newEntry, nextIdx++);
                }
            }

            // 4) i 이동
            i += wLen;
        }

        // List -> int[]
        int[] answer = new int[output.size()];
        for (int k = 0; k < output.size(); k++) {
            answer[k] = output.get(k);
        }
        return answer;
    }
}
