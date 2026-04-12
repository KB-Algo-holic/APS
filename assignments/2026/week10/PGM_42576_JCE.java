import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }
        
        for (String key : hm.keySet()) {
            if (hm.get(key) == 1) answer = key;
        }

        return answer;
    }
}
