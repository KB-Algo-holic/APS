// PGM - 동영상 재생기
// 문자열
// https://school.programmers.co.kr/learn/courses/30/lessons/340213

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int start = 0;
        int end = timeToInteger(video_len);
        int op_st = timeToInteger(op_start);
        int op_ed = timeToInteger(op_end);
        int now = timeToInteger(pos);
        if (now >= op_st && now <= op_ed) {
            now = op_ed;
        }
        for (String command: commands) {
            now += "next".equals(command) ? 10 : -10;
            // 보정
            if (now > end) {
                now = end;
            } else if (now < start) {
                now = start;
            }
            if (now >= op_st && now <= op_ed) {
                now = op_ed;
            }
        }

        return timeToString(now);
    }

    public int timeToInteger(String strTime) {
        int time = 0;
        String[] minuteAndSecond = strTime.split(":");
        String minute = minuteAndSecond[0];
        String second = minuteAndSecond[1];

        time = Integer.parseInt(minute) * 60 + Integer.parseInt(second);
        return time;
    }
    public String timeToString(int time) {
        //정수
        StringBuilder sb = new StringBuilder();
        int minute = time / 60;
        int second = time % 60;
        String strMinute = Integer.toString(minute);
        String strSecond = Integer.toString(second);
        if (strMinute.length() == 1) strMinute = "0"+strMinute;
        if (strSecond.length() == 1) strSecond = "0"+strSecond;
        sb.append(strMinute);
        sb.append(":");
        sb.append(strSecond);
        return sb.toString();
    }
}