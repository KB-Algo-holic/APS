// PGM 42884 단속카메라
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42884


import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;

        Arrays.sort(routes, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        System.out.println(Arrays.deepToString(routes));

        int[] maxRoute = new int[2];
        maxRoute[0] = routes[0][0];
        maxRoute[1] = routes[0][1];
        answer += 1;
        //System.out.println(Arrays.toString(maxRoute));

        for (int i=1; i<n; i++) {
            int[] route = routes[i];
            if (maxRoute[1] < route[0]) {
                answer ++;
                maxRoute[0] = route[0];
                maxRoute[1] = route[1];
            } else {
                maxRoute[0] = Math.max(maxRoute[0], route[0]);
                maxRoute[1] = Math.min(maxRoute[1], route[1]);
            }
            //System.out.println(Arrays.toString(maxRoute));


        }

        return answer;
    }
}