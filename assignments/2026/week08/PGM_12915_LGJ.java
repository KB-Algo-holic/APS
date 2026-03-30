// PGM - 12915
// 구현 - 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/12915

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {

        for (int i=0; i<strings.length-1; i++) {
            for (int j=0; j<strings.length-1-i; j++) {
                String s1 = strings[j];
                String s2 = strings[j+1];

                int c1 = s1.charAt(n);
                int c2 = s2.charAt(n);

                if (c1 > c2) {
                    String temp = s1;
                    strings[j] = s2;
                    strings[j+1] = temp;
                } else if (c1 == c2 && s1.compareTo(s2) > 0) {
                    String temp = s1;
                    strings[j] = s2;
                    strings[j+1] = temp;
                }

            }
        }

        return strings;
    }
}