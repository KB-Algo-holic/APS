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
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        videoLen = changeStringToInt(video_len);
        int currentPos = changeStringToInt(pos);
        opStart = changeStringToInt(op_start);
        opEnd = changeStringToInt(op_end);
        
        for(int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (isOpening(currentPos, opStart, opEnd))
                currentPos = opEnd;
            switch(command){
                case "prev":
                    moveTime(currentPos, -10);
                    System.out.println("prev");
                    break;
                case "next":
                    System.out.println("next");
                    break;
            }
        }
        
        return answer;
    }

    private int moveTime(int currentPos, int time) {
        int cur = currentPos + time;
        
        if (cur < 0) return 0;
        
        
    }
    
    private boolean isOpening(int currentPos, int opStart, int opEnd) {
        if (currentPos >= opStart && currentPos <= opEnd) {
            return true;
        }
        return false;
    }
    
    private int changeStringToInt(String stringTime) {
        String[] times = stringTime.split(":");
        return Integer.parseInt(times[0]) * 100 + Integer.parseInt(times[1]);
    }
    
}
