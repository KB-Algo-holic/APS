// PGM 42883 - 큰 수 만들기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java

public class PGM_42883_PST {
    class Solution {
        public String solution(String number, int k) {

            int n = number.length();

            char[] arrayStack = new char[n - k];
            int top = 0;

            for (int i = 0; i < n; i++) {
                char num = number.charAt(i);

                while (top > 0 && arrayStack[top - 1] < num && k > 0) {
                    top--;
                    k--;
                }

                if (top < arrayStack.length) {
                    arrayStack[top] = num;
                    top++;
                } else {

                    k--;
                }
            }

            return new String(arrayStack);
        }
    }
}
