// PGM 12947 - 하샤드 수
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
    public boolean solution(int x) {
        int xCopy = x;

        int digitsSum = 0;
        while(xCopy >= 10) {
            digitsSum += xCopy % 10;
            xCopy /= 10;
        }
        digitsSum += xCopy % 10;

        return x % digitsSum == 0 ? true : false;
    }
}