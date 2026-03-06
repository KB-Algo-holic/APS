// PGM 181926 - 수조작하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181926?language=java

class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        
        for (int i = 0; i < control.length(); i++){
            switch(control.charAt(i)){
                case 'w' : answer += 1;
                break;
                
                case 's' : answer -= 1;
                break;
                
                case 'd' : answer += 10;
                break;
                    
                case 'a' : answer -= 10;
                break;
            }
        }
        return answer;
    }
}
