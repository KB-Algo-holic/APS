// PGM 181926 - 수조작하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181926

class Solution {
    public int solution(int n, String control) {
        int answer = n;
            
        for(int i=0 ; i<control.length() ; i++){
            char command = control.charAt(i);
            
            if (command == 'w') {
                answer += 1;
            } else if (command == 's') {
                answer -= 1;
            } else if (command == 'd') {
                answer += 10;
            } else if (command == 'a') {
                answer -= 10;
            }
        }
        return answer;
    }
}
