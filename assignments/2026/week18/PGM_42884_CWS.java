// PGM 42884 - 단속카메라
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a,b) -> a[1] != b[1] ?
                Integer.compare(a[1], b[1]) :
                Integer.compare(a[0], b[0])
        );

        int answer = 1;
        int num = routes[0][1];

        for(int i = 1; i < routes.length; i++){
            if(!(routes[i][0] <= num && num <= routes[i][1])){
                num = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}