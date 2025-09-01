//PGM 달리기 경주
// 구현 (맵)
//https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=java

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        List<String> list = Arrays.asList(players);
        //System.out.println(list);

        HashMap<Integer, String> ranks = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<players.length; i++) {
            ranks.put(i, players[i]);
            map.put(players[i], i);
        }

        for (int i=0; i<callings.length; i++) {
            String p1 = callings[i];
            int p1_rank = map.get(p1);
            String p2 = ranks.get(p1_rank-1);

            ranks.put(p1_rank-1, p1);
            ranks.put(p1_rank, p2);
            map.put(p1, p1_rank-1);
            map.put(p2, p1_rank);

        }

        for (int i=0; i<players.length; i++) {
            answer[i] = ranks.get(i);
        }

        return answer;
    }
}