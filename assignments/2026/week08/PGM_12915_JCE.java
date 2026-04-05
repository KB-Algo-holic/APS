import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            
            // n번째 글자 같으면 사전순 정렬 
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            // n번째 글자 기준 오름차순 정렬
            return a.charAt(n) - b.charAt(n);
        });
        return strings;
    }
}
