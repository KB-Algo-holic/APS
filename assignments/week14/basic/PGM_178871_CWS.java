// PGM 178871 - 달리기 경주
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/178871

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map1 = new LinkedHashMap<>();
        Map<Integer, String> map2 = new LinkedHashMap<>();

        //초기 선수 세팅
        for(int i = 0; i < players.length; i++){
            map1.put(players[i], i);
            map2.put(i, players[i]);
        }
        for(String s : callings){
            String name1 = s;
            int num1 = map1.get(name1);
            String name2 = map2.get(num1-1);
            int num2 = num1 - 1;

            // 순위 변경 자리교체
            map1.put(name1, num2);
            map1.put(name2, num1);
            map2.put(num2, name1);
            map2.put(num1, name2);
        }

        String[] answer = new String[map1.size()];
        for(int i = 0; i < map1.size(); i++){
            answer[i] = map2.get(i);
        }
        return answer;
    }
}