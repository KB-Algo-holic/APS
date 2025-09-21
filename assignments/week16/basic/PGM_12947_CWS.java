// PGM 12947 - 하샤드 수
// 유형: 문자열
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12947

class Solution {
    public boolean solution(int x) {

        // 정수 문자열 변환
        String s = Integer.toString(x);
        int num = 0;

        for(int i = 0; i < s.length(); i++){
            num += s.charAt(i) - '0';
        }

        // x가 나누어떨어지면 하샤드 수
        if(x % num == 0){
            return true;
        }else
            return false;
    }
}