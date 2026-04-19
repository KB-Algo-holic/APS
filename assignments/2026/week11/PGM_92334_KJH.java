// PGM 92334 - 신고 결과 받기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        
        //신고당한 사람 
       Map<String, Long> banMap = Arrays.stream(report)
            .distinct()
            .collect(Collectors.groupingBy(
            s -> s.split(" ")[1],    
            Collectors.counting()   
        ));   
        
        //정지될 사람
        banMap.entrySet().removeIf(entry -> entry.getValue() < k);
        
        //정지될 사람을 신고한 사람
        Map<String, Long> alertMap = Arrays.stream(report)
            .distinct()  
            .filter(s -> banMap.containsKey(s.split(" ")[1]))
            .collect(Collectors.groupingBy(
                s -> s.split(" ")[0], Collectors.counting()    
        ));
        answer = Arrays.stream(id_list)
        .mapToInt(id -> alertMap.getOrDefault(id, 0L).intValue())
        .toArray();
        
        return answer;
    }
}
