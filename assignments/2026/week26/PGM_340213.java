// PGM 340213 - 동영상 재생기
// 학습 
// https://school.programmers.co.kr/learn/courses/30/lessons/340213

import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int maxSec = toSec(video_len);
        int curSec = toSec(pos);
        int opS = toSec(op_start);
        int opE = toSec(op_end);

        if(curSec >= opS && curSec <= opE) {
            curSec = opE;
        }

        for(String cmd : commands) {
            curSec += cmd.equals("next") ? 10 : -10;
            curSec = Math.max(0, Math.min(curSec, maxSec));
            if(curSec >= opS && curSec <= opE) curSec = opE;

        }

        return toTime(curSec);

    }

    static int toSec(String time) {
        String[] times = time.split(":");

        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    static String toTime(int sec) {
        int m = sec / 60, s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
}
