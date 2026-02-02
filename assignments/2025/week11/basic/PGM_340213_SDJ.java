import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int s_video_len = Integer.parseInt(video_len.split("\\:")[0]) * 60 + Integer.parseInt(video_len.split("\\:")[1]);
        int s_pos = Integer.parseInt(pos.split("\\:")[0]) * 60 + Integer.parseInt(pos.split("\\:")[1]);
        int s_op_start = Integer.parseInt(op_start.split("\\:")[0]) * 60 + Integer.parseInt(op_start.split("\\:")[1]);
        int s_op_end = Integer.parseInt(op_end.split("\\:")[0]) * 60 + Integer.parseInt(op_end.split("\\:")[1]);
        
        if(s_pos >= s_op_start && s_pos <= s_op_end){
            s_pos = s_op_end;
        }
        
        for(String str : commands) {
            switch(str){
                case "prev":
                    if(s_pos < 10) {
                        s_pos = 0;
                    } else {
                        s_pos = s_pos - 10;
                    }
                    break;
                case "next":
                    if(s_pos + 10 > s_video_len) {
                        s_pos = s_video_len;
                    } else {
                        s_pos = s_pos + 10;
                    }
                    break;
                default:
                    break;
            }
            if(s_pos >= s_op_start && s_pos <= s_op_end){
                s_pos = s_op_end;
            }            
        }
        
        
        String min = Integer.toString(s_pos/60);
        String sec = Integer.toString(s_pos%60);
        
        if(s_pos/60 < 10) min = "0" + min;
        if(s_pos%60 < 10) sec = "0" + sec;
        
        answer = min + ":" + sec;
        
        
        return answer;
    }
}