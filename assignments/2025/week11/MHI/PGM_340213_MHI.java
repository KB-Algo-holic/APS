class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        String[] time = video_len.split(":");
        int total = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

        String[] posTime = pos.split(":");
        int current = Integer.parseInt(posTime[0]) * 60 + Integer.parseInt(posTime[1]);

        String[] sTime = op_start.split(":");
        int start = Integer.parseInt(sTime[0]) * 60 + Integer.parseInt(sTime[1]);

        String[] eTime = op_end.split(":");
        int end = Integer.parseInt(eTime[0]) * 60 + Integer.parseInt(eTime[1]);

        for (String command : commands) {
            if (start <= current && current <= end) {
                current = end;
            }
            if (command.equals("prev")) {
                current -= 10;
                if (current < 0) current = 0;
            } else {
                current += 10;
                if (current > total) current = total;
            }
        }

        if (start <= current && current <= end) {
            current = end;
        }

        int h = current / 60;
        int m = current % 60;

        String hour = h < 10 ? ("0" + h) : (h + "");
        String minute = m < 10 ? ("0" + m) : (m + "");

        return hour + ":" + minute;
    }
}