import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) -> b[0] - a[0]);

        int maxA = scores[0][0];
        int maxB = scores[0][1];
        int currentA = maxA;
        int currentB = maxB;

        for (int i=0; i<scores.length; i++) {
            int[] score = scores[i];

            if (score[0] > wanho[0] && score[1] > wanho[1]) return -1;

            if (score[0] == currentA) {
                currentB = Math.max(score[1], currentB);
            } else {
                maxB = Math.max(maxB, currentB);

                currentA = score[0];
                currentB = score[1];
            }

            boolean incentive = score[0] == maxA || score[1] >= maxB;
            if (incentive && score[0] + score[1] > wanho[0] + wanho[1]) answer ++;
        }

        return answer;
    }
}