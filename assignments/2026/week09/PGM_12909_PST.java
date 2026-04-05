// PGM 12909 - 올바른 괄호
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
class Solution {
    boolean solution(String s) {
        int num = 0;
        for (char sArr : s.toCharArray()) {

            num += (sArr == '(') ? 1 : -1;

            if (num < 0) {
                return false;
            }
        }

        return num == 0;
    }
}