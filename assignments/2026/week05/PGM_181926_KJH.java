// PGM_181926 - 수 조작하기 1
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181926

class Solution {
    public int solution(int n, String control) {
        for(int i = 0 ; i < control.length(); i ++){
            if('w' == control.charAt(i)) n += 1;
            else if('s' == control.charAt(i)) n -= 1;
            else if('d' == control.charAt(i)) n += 10;
            else if('a' == control.charAt(i)) n -= 10;
            
        }
        return n;
    }
}
