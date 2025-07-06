// PGM 172927 - 광물 캐기
// 유형: 그리디, 시뮬레이션
// 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int size = (minerals.length / 5) + 1;
        int[][] preSet = new int[size][3];

        for (int i=0; i<size-1; i++) {
            for (int j=5*i; j<5*(i+1); j++) {
                if (minerals[j].equals("diamond")) {
                    preSet[i][0] += 1;
                    preSet[i][1] += 5;
                    preSet[i][2] += 25;
                }
                else if (minerals[j].equals("iron")) {
                    preSet[i][0] += 1;
                    preSet[i][1] += 1;
                    preSet[i][2] += 5;
                }
                else {
                    preSet[i][0] += 1;
                    preSet[i][1] += 1;
                    preSet[i][2] += 1;
                }
            }
        }

        for (int i=5*(size-1); i<minerals.length; i++) {
            if (minerals[i].equals("diamond")) {
                preSet[size-1][0] += 1;
                preSet[size-1][1] += 5;
                preSet[size-1][2] += 25;
            }
            else if (minerals[i].equals("iron")) {
                preSet[size-1][0] += 1;
                preSet[size-1][1] += 1;
                preSet[size-1][2] += 5;
            }
            else {
                preSet[size-1][0] += 1;
                preSet[size-1][1] += 1;
                preSet[size-1][2] += 1;
            }
        }
        
        int step = picks[0] + picks[1] + picks[2];
        int[][] targetSet = new int[size][3];
        if (preSet.length > step) {
            targetSet = new int[step][3];
            for (int i=0; i<step; i++) {
                targetSet[i] = preSet[i];
            }
        }

        else {
            step = preSet.length;
            targetSet = preSet;
        }
        
        Arrays.sort(targetSet, new Comparator<int[]>() {
            public int compare(int[] x1, int[] x2) {
                if (x1[2] == x2[2]) {
                    return x2[1] - x1[2];
                }
                else {
                    return x2[2] - x1[2];
                }
            }
        });

        for (int i=0; i<step; i++) {
            if (picks[0] > 0) {
                answer += targetSet[i][0];
                picks[0] -= 1;
            }

            else if (picks[1] > 0) {
                answer += targetSet[i][1];
                picks[1] -= 1;
            }

            else {
                answer += targetSet[i][2];
                picks[2] -= 1;
            }
        }
        
        return answer;
    }
}