// PGM 하샤드 수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12947#


class Solution {
    public boolean solution(int origin) {
        boolean answer = true;
        int n = Integer.toString(origin).length(); //자리수
        int copy = origin;
        int total = 0;
        for (int i=n-1; i>=0; i--) {
            total += copy / (int) Math.pow(10, i);
            copy = copy % (int) Math.pow(10, i);
        }

        return origin % total == 0 ? true : false;
    }
}