// PGM_60058 괄호변환
// 재귀함수 사용
// https://school.programmers.co.kr/learn/courses/30/lessons/60058

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = convert(p);
        return answer;
    }
    
    public String convert(String p){
        if(p.length() == 0)
            return "";
        String str = "";
        boolean flag = true;
        int count = 0;
        for(int i =0;i < p.length();i++){
            if(p.charAt(i) == ')'){
                count--;
                if(count < 0)
                    flag = false;
            }
            else
                count++;
            if(count == 0){
                String u = p.substring(0, i + 1);
                String v = p.substring(i + 1);    
                if(flag){
                    return u + convert(v);
                }
                else{
                    return "(" + convert(v) + ")" + replacer(u);
                }
            }
        }
        return "";
    }
    
    public String replacer(String u){
        String str = u.substring(1, u.length() - 1);
        if(str.length() == 0)
            return "";
        str = str.replace("(", "A");
        str = str.replace(")", "(");
        str = str.replace("A", ")");
        return str;
    }
}
