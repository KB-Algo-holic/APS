// PGM 178871 - 달리기 경주
// 유형 : 문자열
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/178871

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> idxMap = new HashMap<>();
        for(int i=0; i<players.length; i++){
            idxMap.put(players[i],i);
        }
        
        for(String call : callings){
            Integer idx = idxMap.get(call);
            players[idx]  = players[idx-1];
            players[idx-1] = call;
            idxMap.put(call,idx-1);
            idxMap.put(players[idx], idx);
        }

        return players;
    }
}
