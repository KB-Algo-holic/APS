// PGM 42576 - 완주하지못한선
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
         
        HashMap<String,Integer> rstMap = new HashMap<String,Integer>();
         
        for (String p : participant) {
            rstMap.put(p, rstMap.getOrDefault(p, 0) + 1);
        }
 
        for (String c : completion) {
            rstMap.put(c, rstMap.get(c) - 1);
        }
        
        String answer =   rstMap.entrySet().stream().filter(r -> r.getValue() != 0).map(Map.Entry::getKey).findFirst().get(); 
        return answer;
    }
}
