import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap();

        for (String word : completion) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }

        for (String word : participant) {
            if (map.containsKey(word)) {
                if (map.get(word) == 0) return word;
                else map.put(word, map.get(word) - 1);
            } else {
                return word;
            }
        }

        return "";
    }
}