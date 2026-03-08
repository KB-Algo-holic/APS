class Solution {
    public String solution(String code) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int mode = 0;       // 시작할 때 mode는 0
        // 1. code 문자열 하나씩 스캔
        for (int idx = 0; idx < code.length(); idx++) {
            char c = code.charAt(idx);
            // 1) mode가 0이고 c가 '1'일 때, 2) mode가 1이고 c가 '1'일 때
            if (c == '1') mode = ( mode == 0 ? 1 : 0);
            // 3) mode가 0이고 c가 '1'이 아닐 때
            else if (mode == 0 && idx % 2 == 0) sb.append(c);
            // 4) mode가 1이고 c가 '1'이 아닐 때
            else if (mode == 1 && idx % 2 == 1) sb.append(c);
              
        }
        if (sb.toString().isEmpty()) answer = "EMPTY";
        else answer = sb.toString();
        return answer;
    }
}
