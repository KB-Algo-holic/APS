// PGM 60058 - 괄호 변환 풀이 완료
// 유형: 구현
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60058?language=java

class Solution {
    public String solution(String p) {
        if("".equals(p)){   // 빈 문자열일 경우 걍 반환
            return "";
        }
        
        int idx = split(p);

        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1, p.length());
                
        if(isCorrect(u)){
            // u가 올바른 문자열일 경우? v만 다시 만들어준다.
            return u+solution(v);
        }else{
            String tmp = "";
            
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='('){
                    tmp+=")";
                }else{
                    tmp+="(";
                }
            }
            
            return "(" + solution(v)+")"+tmp;
        }
    }
    
    public int split(String str){
        int cnt=0;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(') {
                cnt+=1;
            }else{
                cnt-=1;
            }
            if(cnt==0){
                return i;
            }
        }
        return str.length();
    }
    
    public boolean isCorrect(String str){
        //올바른 문자열인지 판단하는 함수
        int cnt = 0;
        for(char ch : str.toCharArray()){
            // ( -> +1 -1가 와도 괜찮다는 뜻
            if(ch=='(') {
                cnt+=1;
            }else{
                if(cnt-1<0) return false;
                cnt-=1;
            }
        }
        return cnt==0?true:false;
    }
}