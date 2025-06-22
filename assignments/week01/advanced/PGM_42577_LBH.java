// PGM 42577 - 전화번호 목록
// 유형: 해시
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String number : phone_book) {
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < number.length() - 1; i++) {
                prefix.append(number.charAt(i));
                if (set.contains(prefix.toString())) {
                    return false;
                }
            }
        }

        return true;
    }
}