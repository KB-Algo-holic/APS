// PGM 퍼즐게임 챌린지
// 이진탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/340212

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = 1;
        int maxLevel = Integer.MAX_VALUE-1;
        int level = Integer.MAX_VALUE;


        while (minLevel <= maxLevel) {

            int midLevel = (minLevel+maxLevel) / 2;
            if (!isPossibleToSolve(diffs, times, limit, midLevel)) {
                minLevel = midLevel+1;
            } else {
                if (level > midLevel) { level = midLevel; }
                maxLevel = midLevel-1;
            }
        }

        return level;
    }

    public boolean isPossibleToSolve(int[] diffs, int[] times, long limit, int level) {
        int puzzleCount = diffs.length;
        long total = 0;

        for (int i=0; i<puzzleCount; i++) {
            int diff = diffs[i];
            int curTime = times[i];
            long curTotal = 0;

            if ( diff <= level ) {
                curTotal = curTime;
            } else {
                int retry = diff - level;
                int prevTime = times[i-1];
                curTotal = ((prevTime+curTime)*retry) + curTime;
            }
            total += curTotal;
            if (total > limit) {
                return false;
            }
        }
        return true;
    }

}