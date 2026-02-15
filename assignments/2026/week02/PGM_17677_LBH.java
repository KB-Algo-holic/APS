// PGM 17677 - [1차] 뉴스 클러스터링
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/17677


import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> words = new HashSet<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
            if('a' <= str1.charAt(i) && str1.charAt(i) <= 'z' && 'a' <= str1.charAt(i + 1) && str1.charAt(i + 1) <= 'z') {
                String word = "" + str1.charAt(i) + str1.charAt(i + 1);
                if(map1.get(word) == null) {
                    map1.put(word, 1);
                } else {
                    map1.put(word, map1.get(word) + 1);
                }

                words.add(word);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
            if('a' <= str2.charAt(i) && str2.charAt(i) <= 'z' && 'a' <= str2.charAt(i + 1) && str2.charAt(i + 1) <= 'z') {
                String word = "" + str2.charAt(i) + str2.charAt(i + 1);
                if(map2.get(word) == null) {
                    map2.put(word, 1);
                } else {
                    map2.put(word, map2.get(word) + 1);
                }

                words.add(word);
            }
        }
        
        int interSectionSize = 0;
        int unionSize = 0;
        
        for(String word : words) {
            int map1Word = map1.get(word) != null ? map1.get(word) : 0;
            int map2Word = map2.get(word) != null ? map2.get(word) : 0;
            interSectionSize += Math.min(map1Word, map2Word);
            unionSize += Math.max(map1Word, map2Word);
        }
        
        if(interSectionSize == unionSize) {
            return 65536;
        } else {
            return (int)((interSectionSize * 1.0f / unionSize * 1.0f) * 65536);
        }
    }
}