import java.util.*;

class PGM_181932_YHS {
    public String solution(String code) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        int mode = 0;
        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);
            if(c == '1'){
                mode = mode^1;
                continue;
            }

            if(mode == 0){
                if(i%2 == 0){
                    sb.append(c);
                }
            }else{
                if(i%2 == 1){
                    sb.append(c);
                }
            }
        }

        answer = sb.toString();

        if(answer.equals("")){
            answer = "EMPTY";
        }

        return answer;
    }
}