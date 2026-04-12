// PGM 468370 - 중요한 단어를 스포 방지
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/468370

import java.util.*;

class Solution {

    public String replaceRangeWithSpace(String src, int start, int end) {
        StringBuilder sb = new StringBuilder(src);
        String spaces = " ".repeat(end - start);
        sb.replace(start, end, spaces);

        return sb.toString();
    }

    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        String spoileredMessage = message;
        for(int[] spoiler: spoiler_ranges) {
            int start = spoiler[0];
            int end = spoiler[1];

            while(start > 0) {
                if(message.charAt(start) == ' ') {
                    break;
                }
                start--;
            }

            while(end <= message.length() - 1) {
                if(message.charAt(end) == ' ') {
                    break;
                }
                end++;
            }

            spoileredMessage = replaceRangeWithSpace(spoileredMessage, start, end);

            spoiler[0] = start;
            spoiler[1] = end;
        }

        String[] spoileredSplitArray = spoileredMessage.split(" ");
        for(String word : spoileredSplitArray) {
            if(!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for(int[] spoiler: spoiler_ranges) {
            int start = spoiler[0];
            int end = spoiler[1];

            String[] words = message.substring(start, end).split(" ");
            for(String word : words) {
                if(!word.isEmpty() && map.getOrDefault(word, 0) == 0) {

                    map.put(word, 1);
                    answer++;
                }
            }
        }

        return answer;
    }
}