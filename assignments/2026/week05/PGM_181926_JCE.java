class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        // 1. 문자열 control의 문자 하나씩 스캔
        for (int i = 0; i < control.length(); i++) {
            char c = control.charAt(i);
            
            // 2. "w", "a", "s", "d" 각 문자에 따라 n 값 변경
            switch(c) {
                case 'w': n += 1; break;
                case 's': n -= 1; break;
                case 'd': n += 10; break;
                default: n -= 10; break;
            }
        }
        
        // 3. 최종 n의 값 리턴
        answer = n;
        return answer;
    }
}
