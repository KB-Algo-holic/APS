// PGM 340213 - 동영상 재생기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/340213?language=java

import java.util.ArrayList;

public class PGM_340213_PST {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        ArrayList<Integer> times = new ArrayList<>();
        times.add(toSec(pos));
        times.add(toSec(op_start));
        times.add(toSec(op_end));
        times.add(toSec(video_len));

        checkOp(times);

        for (String cmd : commands) {
            int cur = times.get(0);
            if (cmd.equals("prev")) cur = Math.max(0, cur - 10);
            else if (cmd.equals("next")) cur = Math.min(times.get(3), cur + 10);

            times.set(0, cur);
            checkOp(times);
        }

        return String.format("%02d:%02d", times.get(0) / 60, times.get(0) % 60);
    }

    private void checkOp(ArrayList<Integer> t) {
        if (t.get(0) >= t.get(1) && t.get(0) <= t.get(2)) {
            t.set(0, t.get(2));
        }
    }

    private int toSec(String time) {
        String[] p = time.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }
}
