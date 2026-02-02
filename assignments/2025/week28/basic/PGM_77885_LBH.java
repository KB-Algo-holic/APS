// PGM 77885 - 2개 이하로 다른 비트
// 문자열, 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/77885

import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String s = Long.toString(numbers[i], 2);
            boolean flag = false;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == '0') {
                    s = s.substring(0, j) + '1' + s.substring(j + 1);

                    if (j < s.length() - 1) {
                        s = s.substring(0, j + 1) + '0' + s.substring(j + 2);
                    }

                    flag = true;
                    break;
                }
                if (j == 0 && !flag) {
                    s = s.substring(0, 1) + '0' + s.substring(1);
                }
            }

            answer[i] = Long.parseLong(s, 2);
        }

        return answer;
    }
}