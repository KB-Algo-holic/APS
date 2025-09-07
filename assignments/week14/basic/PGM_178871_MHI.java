import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        for (String call : callings) {
            int i = map.get(call);
            String tmp = answer[i-1];
            answer[i-1] = call;
            answer[i] = tmp;
            map.put(tmp, i);
            map.put(call, i-1);
        }
        return answer;
    }
}