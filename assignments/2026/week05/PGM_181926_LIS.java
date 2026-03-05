// PGM 181926 - 수 조작하기 1
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181926
class Solution {
    public int solution(int n, String control) {

        char charA;
        int cSize = control.length();
        for(int i = 0; i < cSize; i++) {
            charA = control.charAt(i);
            // w 1증가
            if(charA == 'w') {
                n+=1;
            }
            // s 1감소
            else if(charA == 's') {
                n-=1;
            }
            // d 10 증가
            else if(charA == 'd') {
                n+=10;
            }
            // a 10 감소
            else if(charA == 'a') {
                n-=10;
            }
        }

        return n;
    }
}
