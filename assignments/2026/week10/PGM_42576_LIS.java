// PGM 42576 - 완주하지 못한 선수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> pMap = new HashMap<>();        
                
        for(int i = 0; i < participant.length; i++) {
            pMap.merge(participant[i], 1, (v1, v2) -> v1 + v2);
        }
        
        for(int i = 0; i < completion.length; i++) {
            pMap.merge(completion[i], -1, (v1, v2) -> v1 + v2);
            if(pMap.get(completion[i]) == 0) {
                pMap.remove(completion[i]);
            }
        }
        
        return pMap.keySet().stream().findFirst().get();
    }
}
