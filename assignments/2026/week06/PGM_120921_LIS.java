// PGM 120921 - 문자열 밀기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/120921
class Solution {
    public int solution(String code1, String code2) {
        
        int codeSize = code1.length();
        String temp;
        
        // 값이 같은경우 0
        if (code1.equals(code2)) {
            return 0;
        }

        for(int cnt = 1; cnt < codeSize; cnt++) {
            
            temp = code1.charAt(codeSize -1) + code1.substring(0, codeSize -1);            

            if (code2.equals(temp)) {
                return cnt;
            } else {
                code1 = temp;
            }

        }       

        return -1;
    }
}
