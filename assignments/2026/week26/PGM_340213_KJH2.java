// PGM 340213 동영상 재생기
// https://school.programmers.co.kr/learn/courses/30/lessons/340213

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int total_sec = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int vdo_sec = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int op_sec = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int ed_sec = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        if(total_sec >= op_sec && total_sec <= ed_sec){
            total_sec = ed_sec;
        }
        for(String x : commands){
            if("next".equals(x)){
                total_sec += 10;
                if(total_sec >= vdo_sec){
                    total_sec = vdo_sec;
                }
                if(total_sec >= op_sec && total_sec <= ed_sec){
                    total_sec = ed_sec;
                }
            }
            else if("prev".equals(x)){
                total_sec -= 10;
                if(total_sec < 0){
                    total_sec = 0;
                }
                if(total_sec >= op_sec && total_sec <= ed_sec){
                    total_sec = ed_sec;
                }
            }
        }
        pos = String.format("%02d:%02d", total_sec/60, total_sec%60);
        return pos;
    }
}
