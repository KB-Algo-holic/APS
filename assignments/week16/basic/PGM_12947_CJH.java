// PGM 12947 - 하샤드 수
// 유형 : 문자열
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=java

import java.util.*;

public class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        List<String> split = List.of(String.valueOf(x).split(""));
        
        int sum = 0;
        
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        
        if (x%sum != 0){
            answer = false;
        }
        return answer;
    }
}
