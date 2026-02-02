// PGM 아날로그 시계
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/250135
class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startTime = h1*3600 + m1*60 + s1;
        int endTime = h2*3600 + m2*60 + s2;

        // 12시 시작
        if (startTime == 0 || startTime == 12 * 3600) answer ++;

        while (startTime < endTime) {
            // 초당 시침 분침 초침 각도  1/120 1/10도 6도
            double curHrAngle = (startTime/120.0) % 360;
            double curMnAngle = (startTime/10.0) % 360;
            double curSdAngle = (startTime*6.0) % 360;

            double nextHrAngle = ((startTime+1)/120.0) % 360 == 0 ? 360 : ((startTime+1)/120.0) % 360;
            double nextMnAngle = ((startTime+1)/10.0) % 360 == 0 ? 360 : ((startTime+1)/10.0) % 360;
            double nextSdAngle = ((startTime+1)*6.0) % 360 == 0 ? 360 : ((startTime+1)*6.0) % 360;


            if (curHrAngle > curSdAngle && nextHrAngle <= nextSdAngle) {
                answer ++;
            }
            if (curMnAngle > curSdAngle && nextMnAngle <= nextSdAngle) {
                answer ++;
            }
            if (nextSdAngle == nextMnAngle && nextSdAngle <= nextHrAngle) answer --;

            startTime ++;

        }


        return answer;
    }
}