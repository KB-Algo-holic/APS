// 달리기 경주
// 해시
// https://school.programmers.co.kr/learn/courses/30/lessons/178871

import java.util.*;

class Solution{
    
    void swap(Map<String, Integer> map, String[] players, int front, int behind) {
        map.put(players[front], behind);
        map.put(players[behind], front);
        
        String temp = players[front];
        players[front] = players[behind];
        players[behind] = temp;
    }
    
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int front = map.get(callings[i]) - 1;
            int behind = map.get(callings[i]);
            
            swap(map, players, front, behind);
        }
        
        return players;
    }
}
