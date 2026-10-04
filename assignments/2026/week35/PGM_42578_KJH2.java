// PGM 42578 의상
// 맵 사용
// https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> maps = new HashMap<>();
        
        for(String[] x : clothes){
            maps.put(x[1], maps.getOrDefault(x[1], 1) + 1);
        }
        
        for(int num : maps.values()){
            answer *= num;
        }
        
        answer -= 1;
        return answer;
    }
    
}
