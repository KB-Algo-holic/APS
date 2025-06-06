import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        set.add(phone_book[0]);
        
        for(int i = 1; i < phone_book.length; i++) {
            int length = phone_book[i].length();
            
            for(int j = 1; j < length; j++) {
                if(set.contains(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
            
            set.add(phone_book[i]);
        }
        
        return answer;
    }
}