// PGM - 12915 문자열 내 마음대로 정렬하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12915

import java.util.Arrays;
import java.util.Comparator;

public class PGM_12915_YHS {
    public String[] solution(String[] strings, int n) {
        int size = strings.length;
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);
                if(c1 == c2){
                    return o1.compareTo(o2);
                }

                return Integer.compare(c1, c2);
            }

        });
        return strings;
    }
}
