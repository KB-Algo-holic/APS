// PGM - 120921
// 문자열 (구현)
// https://school.programmers.co.kr/learn/courses/30/lessons/120921

class Solution {
    public int solution(String A, String B) {
        // A+A 풀이 추가
        String cur = A;

        for (int i = 0; i < A.length(); i++) {
            if (cur.equals(B)) return i;
            cur = cur.charAt(A.length()-1) + cur.substring(0, A.length()-1);
        }

        return -1;
    }
}