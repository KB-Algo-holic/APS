// PGM 42883 - 큰 수 만들기
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42883


class Solution {

    public String solution(String number, int k) {

        StringBuilder stack = new StringBuilder();

        for (char c : number.toCharArray()) {

            while (
                    k > 0 &&
                            stack.length() > 0 &&
                            stack.charAt(stack.length() - 1) < c
            ) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(c);
        }

        // 아직 제거 횟수가 남은 경우
        return stack.substring(0, stack.length() - k);
    }
}