// PGM 340213 - 동영상재생
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/340213
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int videoLenSec = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        int currentSec = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        int opStartSec = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        int opEndSec = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
 
        if (currentSec >= opStartSec && currentSec <= opEndSec) {
            currentSec = opEndSec;
        }
 
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                currentSec = Math.max(0, currentSec - 10);
            } else if (cmd.equals("next")) {
                currentSec = Math.min(videoLenSec, currentSec + 10);
            }
 
            if (currentSec >= opStartSec && currentSec <= opEndSec) {
                currentSec = opEndSec;
            }
        }
        answer = String.format("%02d:%02d", currentSec / 60, currentSec % 60);
        return answer;
    }
}
