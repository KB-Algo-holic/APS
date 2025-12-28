// PGM 달리기 경주
// 구현 (맵)
// https://school.programmers.co.kr/learn/courses/30/lessons/178871

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {       
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int indx = 0; indx < players.length; indx++) {
            map.put(players[indx], indx);
        }
        
        String temp;
        int front, behind;
        for(String calling : callings) {
            behind = map.get(calling);
            front = behind - 1;
            
            temp = players[front];
            players[front] = players[behind];
            players[behind] = temp;
            
            map.put(temp, behind);
            map.put(calling, front);
        }
        
        return players;
    }
}