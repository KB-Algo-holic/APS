// PGM - 17686 파일명정렬
// 구현 - 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;

class Solution {

    public String[] solution(String[] files) {

        Arrays.sort(files, (a, b) -> {
            // HEAD, NUMBER 분리
            String[] partA = split(a);
            String[] partB = split(b);

            // HEAD 정렬 문자열 오름차순
            int headCompare = partA[0].compareTo(partB[0]);

            if (headCompare != 0) {
                return headCompare;
            }

            // HEAD가 동일한 경우 NUMBER 정렬
            return Integer.compare(
                    Integer.parseInt(partA[1]),
                    Integer.parseInt(partB[1])
            );
        });

        return files;
    }

    // HEAD, NUMBER 분리 로직
    private String[] split(String file) {

        int idx = 0;

        // start Index -> 첫번째 숫자 발견
        while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
            idx++;
        }

        int start = idx;

        // end Index -> 숫자가 종료되는 인덱스
        while (idx < file.length()
                && Character.isDigit(file.charAt(idx))
                && idx - start < 5) {
            idx++;
        }

        String head = file.substring(0, start).toLowerCase();
        String number = file.substring(start, idx);

        return new String[]{head, number};
    }
}