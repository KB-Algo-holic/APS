// PGM 12918 문자열다루기 기본
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/12918

class Solution {
    public boolean solution(String s) {


        if (s.length() != 4 && s.length() != 6) return false;

        for (char ch : s.toCharArray()) {
            if (!Character.isDigit(ch)) return false;
        }
        return true;
    }
}