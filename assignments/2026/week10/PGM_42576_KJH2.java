// PGM_42576 완주하지못한 선수
// HashMap 이용하여 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        // 중복이 있을 수 있으니 해시맵으로 생성
        HashMap<String, Integer>pmap = new HashMap<>();
        
        // 이름을 key로 ,이름이 등장한 횟수를 value로 기록
        for(String x : participant){
            pmap.put(x, pmap.getOrDefault(x, 0) + 1);
        }
        
        // 완주자목록에 이름이 있으면 value값을 -1
        for(String x : completion){
            pmap.put(x, (pmap.get(x) - 1));
            
        }
        
        // value값이 1인걸 추출해서 리턴
        for(String key : pmap.keySet()){
            if(pmap.get(key) == 1)
                return key;
        }
        
        return "";
    }
}
