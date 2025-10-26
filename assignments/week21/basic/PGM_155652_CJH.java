// PGM 155652 - 둘만의 암호
// 유형 : 문자열
https://school.programmers.co.kr/learn/courses/30/lessons/155652

import java.util.*;

public class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();        
        Set<Character> skipSet = new HashSet<>();
        
        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }
        
        for(char cha : s.toCharArray()) {
            int shifts = index;
            char newChar = cha;
            
            while(shifts > 0) {
                newChar++;
                
                if (newChar > 'z'){
                    newChar = 'a';
                }
                
                if (!skipSet.contains(newChar)){
                    shifts--;
                }
            }
            answer.append(newChar);
        }
        return answer.toString();
    }
}
