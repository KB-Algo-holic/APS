// PGM - 신규아이디
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/72410?language=java


class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = toLowerCase(new_id);
        // 2단계
        new_id = removeInvalidChars(new_id);
        // 3단계
        new_id = collapseDots(new_id);
        // 4단계
        new_id = trimDots(new_id);
        // 5단계
        new_id = handleEmpty(new_id);
        // 6단계
        new_id = limitLength(new_id);
        // 7단계
        new_id = extendShortId(new_id);

        return new_id;
    }

    // 1단계: 대문자를 소문자로 치환
    String toLowerCase(String s) {
        return s.toLowerCase();
    }

    // 2단계: 허용된 문자만 남기기 (정규식 없이 구현)
    String removeInvalidChars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9') ||
                    c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 3단계: 연속된 마침표(.)를 하나로 치환
    String collapseDots(String s) {
        StringBuilder sb = new StringBuilder();
        boolean dot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (!dot) { // 이전이 점이 아니면 추가
                    sb.append(c);
                    dot = true;
                }
            } else {
                sb.append(c);
                dot = false;
            }
        }
        return sb.toString();
    }

    // 4단계: 처음과 끝의 마침표 제거
    String trimDots(String s) {
        if (s.length() == 0) return s;
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == '.') start++;
        while (end >= start && s.charAt(end) == '.') end--;
        return s.substring(start, end + 1);
    }

    // 5단계: 빈 문자열이면 "a" 대입
    String handleEmpty(String s) {
        return s.isEmpty() ? "a" : s;
    }

    // 6단계: 16자 이상이면 15자까지 자르고, 끝의 마침표 제거
    String limitLength(String s) {
        if (s.length() >= 16) {
            s = s.substring(0, 15);
            s = trimDots(s);
        }
        return s;
    }

    // 7단계: 길이가 2 이하라면 마지막 문자를 길이 3이 될 때까지 반복
    String extendShortId(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }
        return sb.toString();
    }

}