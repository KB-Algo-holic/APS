import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
 
        HashMap<String, Integer> closet = new HashMap<>();
        
        for (String[] cloth : clothes) {
            closet.put(cloth[1], closet.getOrDefault(cloth[1],0) + 1);
        }
        
        for (String key : closet.keySet()) {
            answer *= (closet.get(key) + 1);
        }
        
        return answer - 1;
       
    }
}
