import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        HashMap<String, Integer> allMsg = new HashMap<>();
        HashMap<String, Integer> importantMsg = new HashMap<>();
        char[] arr = message.toCharArray();
        boolean[] arrB = new boolean[arr.length];
        
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) arrB[i] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isContainSpoiled = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ' ) {
                if (sb.length() > 0){
                    String word = sb.toString();
                allMsg.put(word, allMsg.getOrDefault(word, 0) + 1);
                if(isContainSpoiled) {
                    importantMsg.put(word, importantMsg.getOrDefault(word, 0) + 1);
                    isContainSpoiled = false;
                }
                    
                }
                
                sb = new StringBuilder();
                continue;
            } else {
                sb.append(arr[i]);
                if (arrB[i]) isContainSpoiled = true;
            }
        }
        if (sb.length() > 0){
                    String word = sb.toString();
                allMsg.put(word, allMsg.getOrDefault(word, 0) + 1);
                if(isContainSpoiled) {
                    importantMsg.put(word, importantMsg.getOrDefault(word, 0) + 1);
                    isContainSpoiled = false;
                }
        } 
        
        
        for (String key : importantMsg.keySet()) {
            if (importantMsg.get(key) == allMsg.get(key)) answer++;
        }
        
        return answer;
    }
}
