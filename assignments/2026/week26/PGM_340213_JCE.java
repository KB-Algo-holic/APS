/*
* PGM 동영상 재생기
* https://school.programmers.co.kr/learn/courses/30/lessons/340213
commands를 모두 수행하면서 
- 현재 재생 위치가 오프닝 구간인지 확인
    오프닝 구간이면 오프닝이 끝나는 위치로 이동
- prev이면
    10초 전으로 이동 후 
    10초 미만으로 남았으면 영상의 처음 위치로 이동
    오프닝 구간인지 확인
- next이면
    10초 후로 이동 후
    오프닝 구간인지 확인
    남은 시간이 10초 미만이면 마지막 위치로 이동
*/

class Solution {
    static int videoLen, opStart, opEnd;
       public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int num_video_len = changeToInt(video_len);
        int num_pos = changeToInt(pos);
        int num_op_start = changeToInt(op_start);
        int num_op_end = changeToInt(op_end);

        // 현재 위치가 오프닝 시간에 걸리는지 확인
        if (num_op_start <= num_pos && num_pos <= num_op_end) {
            num_pos = num_op_end;
        }
        for (int i = 0; i < commands.length; i++) {

            // 사용자 명령 수행
            if (commands[i].equals("prev")) {
                num_pos -= 10;
                if (num_pos < 0) num_pos = 0;

            } else { // "next"
                num_pos += 10;
                if (num_pos > num_video_len) num_pos = num_video_len;
            }

            // 현재 위치가 오프닝 시간에 걸리는지 확인
            if (num_op_start <= num_pos && num_pos <= num_op_end) {
                num_pos = num_op_end;
            }

        }

        answer = changeToTime(num_pos);
        return answer;
    }

    private static String changeToTime(int num_pos) {
        int mm = num_pos / 60;
        int ss = num_pos % 60;

        return String.format("%02d:%02d", mm, ss);
    }

    private static int changeToInt(String time) {
        int num = 0;
        String[] test = time.split(":");

        num = (Integer.parseInt(test[0]) * 60);
        num += Integer.parseInt(test[1]);

        return num;
    }

    
}
