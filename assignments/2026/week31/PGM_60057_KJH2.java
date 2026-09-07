// PGM 60057 문자열 압축
// https://school.programmers.co.kr/learn/courses/30/lessons/60057

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int group = 1 ; group <= s.length()/2 ; group++){
            int count = 1;
            String prev = "";
            String compress = "";
            int i = 0;
            for(i = 0;i + group <= s.length();i += group){
                String unit = s.substring(i, i + group);
                if(prev.equals(unit)){
                    count++;
                }
                else{
                    if(!prev.isEmpty()){
                        if(count > 1)
                            compress += Integer.toString(count) + prev;
                        else
                            compress += prev;
                    }
                    prev = unit;
                    count = 1;
                }
            }
            if(count > 1)
                compress += Integer.toString(count) + prev;
            else
                compress += prev;
            
            if(i < s.length())
                compress += s.substring(i);
            
            if(compress.length() < answer)
                answer = compress.length();
        }
        return answer;
    }
}
