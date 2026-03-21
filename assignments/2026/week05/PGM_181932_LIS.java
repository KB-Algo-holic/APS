// PGM 181932 - 코드 처리하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/181932
class Solution {
    
    public String solution(String code) {
        String mode = "0";
        String ret = "";
        int codeSize = code.length();
        
        for(int i = 0; i < codeSize; i++) {
            // mode 가 0인경우
            if("0".equals(mode)) {
                // 값이 1이면 mode 변경
                if('1' == code.charAt(i)) {
                    mode = "1";
                } else {
                    // i가 짝수인경우 ret에 값추가
                    if(i%2 == 0) {
                        ret = ret + code.charAt(i);
                    }
                } // end if('1' == code.charAt(i))
            } else {
                // 값이 1이면 mode 변경
                if('1' == code.charAt(i)) {
                    mode = "0";
                } else {
                    // i가 짝수인경우 ret에 값추가
                    if(i%2 == 1) {
                        ret = ret + code.charAt(i);
                    }
                } // end if('1' == code.charAt(i))
            }
        } // end for
        
        if("".equals(ret)) {
            ret = "EMPTY";
        }
        
        return ret;
    }
}
