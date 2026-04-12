// PGM - 42576 완주하지 못한 선수
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.HashMap;
import java.util.Map;

public class PGM_42576_YHS {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<completion.length; i++){
            if(map.get(completion[i]) == null){
                map.put(completion[i], 1);
            }else{
                map.put(completion[i], map.get(completion[i])+1);
            }
        }

        for(int i=0; i<participant.length; i++){
            if(map.get(participant[i]) == null){
                return participant[i];
            }

            map.replace(participant[i], map.get(participant[i])-1);
            if(map.get(participant[i]) == 0){
                map.remove(participant[i]);
            }
        }

        return answer;
    }
}
