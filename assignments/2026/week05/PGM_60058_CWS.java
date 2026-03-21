// PGM 60058 - 괄호 변환
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/60058

class Solution {
    public String solution(String p) {
        return move(p);
    }

    static String move(String w){
        //1 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(w.equals("")) return "";

        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.

        int l = 0;
        int r = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while(true){
            if(w.charAt(cnt) == '('){
                sb.append('(');
                l++;
            }else{
                sb.append(')');
                r++;
            }
            cnt++;
            if(l == r) break;
        }
        String u = sb.toString();
        String v = w.substring(cnt);

        l = 0;
        r = 0;
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') l++;
            else r++;

            if(l < r){//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
                //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                String answer = "(";
                //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
                answer += move(v);
                //  4-3. ')'를 다시 붙입니다.
                answer += ")";
                //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
                for(int j = 1; j < u.length()-1; j++){
                    answer += u.charAt(j) == '(' ? ')' : '(';
                }
                //  4-5. 생성된 문자열을 반환합니다.
                return answer;
            }
        }
        u += move(v);
        //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        return u;
    }
}