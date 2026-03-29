// 문자열 내 마음대로 정렬하기
// 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if(s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            } else {
                return s1.charAt(n) - s2.charAt(n);
            }
        });

        return strings;
    }
}