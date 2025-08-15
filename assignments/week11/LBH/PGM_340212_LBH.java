// PGM 340212 - 퍼즐 게임 챌린지
// 이진탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/340212

class Solution {

    public boolean play(int level, int[] diffs, int[] times, long limit){
        long sum = 0;
        for(int i = 0; i < diffs.length; i++){

            if(diffs[i] > level){
                sum += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            } else {
                sum += times[i];
            }
        }

        if(sum <= limit) {
            return true;
        } else {
            return false;
        }
    }

    public int binarySearch(int start, int end, int[] diffs, int[] times, long limit){
        if(start >= end){
            return start;
        }

        int mid = (start + end) / 2;

        if(play(mid, diffs, times, limit)){
            return binarySearch(start, mid, diffs, times, limit);
        } else {
            return binarySearch(mid + 1, end, diffs, times, limit);
        }
    }

    public int solution(int[] diffs, int[] times, long limit) {

        int answer = binarySearch(1, 100001, diffs, times, limit);

        return answer;
    }
}