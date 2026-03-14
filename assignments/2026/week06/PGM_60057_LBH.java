// 문자열 압축
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/60057

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for(int unit = 1; unit <= s.length() / 2; unit++) {

            String compression = "";
            String lastWord = s.substring(0, unit);
            int count = 1;
            int i = unit;

            while(true) {
                if(i + unit > s.length()) {
                    compression += (count > 1 ? Integer.toString(count) + lastWord : lastWord) + s.substring(i, s.length());
                    break;
                } else {
                    String target = s.substring(i, i + unit);

                    if (lastWord.equals(target)) {
                        count++;
                    } else {
                        if (count > 1) {
                            compression += Integer.toString(count) + lastWord;
                            count = 1;
                        } else {
                            compression += lastWord;
                        }

                        lastWord = target;
                    }
                }

                i += unit;
            }

            if(compression.length() < answer) {
                answer = compression.length();
            }
        }

        return answer;
    }
}