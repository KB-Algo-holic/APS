// PGM 340213 - 동영상 재생기
// 유형 : 문자열
// 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/340213

import java.util.*;

class Solution {
       public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len_s = second(video_len);
        int current_s = second(pos);
        int op_start_s = second(op_start);
        int op_end_s = second(op_end);

        if (current_s >= op_start_s && current_s <= op_end_s) {
            current_s = op_end_s;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                current_s = Math.max(current_s - 10, 0);
            } else {
                current_s = Math.min(current_s + 10, len_s);
            }

            if (current_s >= op_start_s && current_s <= op_end_s) {
                current_s = op_end_s;
            }
        }
        String minute = String.format("%02d", (int) Math.floor((double) current_s / 60));
        String second = String.format("%02d", current_s % 60);
        return minute + ":" + second;
    }

    private static int second(String time) {
        String[] time_ms = time.split(":");
        return (Integer.parseInt(time_ms[0]) * 60) + Integer.parseInt(time_ms[1]);
    }
}
