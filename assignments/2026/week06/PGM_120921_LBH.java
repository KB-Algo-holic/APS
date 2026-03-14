// 문자열 밀기
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/120921

class Solution {
    public int solution(String A, String B) {

        String target = A.substring(0);

        for(int i = 0; i <= A.length(); i++) {
            if(target.equals(B)) {
                return i;
            }

            target = target.charAt(A.length() - 1) + target.substring(0, A.length() - 1);
        }

        return -1;
    }
}