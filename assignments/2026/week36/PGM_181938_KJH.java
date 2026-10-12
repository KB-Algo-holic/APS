// PGM 181938 - 두 수의 연산값 비교하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181938
class Solution {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt("" + a + b), 2 * a * b);
    }
}
