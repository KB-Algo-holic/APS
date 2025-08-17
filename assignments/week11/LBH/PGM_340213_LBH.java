// PGM 340213 - 동영상 재생기
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/340213

class Solution {
    public int convertTime(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public String convertTime(int time){
        String hour = String.valueOf(time / 60);
        String min = String.valueOf(time % 60);

        if(hour.length() < 2){
            hour = "0" + hour;
        }
        if(min.length() < 2){
            min = "0" + min;
        }

        return hour + ":" + min;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int ivideo_len = convertTime(video_len);
        int ipos = convertTime(pos);
        int iop_start = convertTime(op_start);
        int iop_end = convertTime(op_end);

        if(iop_start <= ipos && ipos <= iop_end){
            ipos = iop_end;
        }

        for(int i = 0; i < commands.length; i++){

            if("next".equals(commands[i])){
                ipos += 10;
            } else {
                ipos -= 10;
            }

            if(ipos < 0){
                ipos = 0;
            }

            if(ipos > ivideo_len){
                ipos = ivideo_len;
            }

            if(iop_start <= ipos && ipos <= iop_end){
                ipos = iop_end;
            }
        }

        return convertTime(ipos);
    }
}