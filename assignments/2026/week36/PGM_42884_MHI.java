// PGM 42884 - 단속카메라
// 그리디
// https://school.programmers.co.kr/learn/courses/30/lessons/42884

import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int flag = -30000;
        int answer = 0;
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (flag < start){
                flag = end;
                answer ++;
            }
        }
        return answer;
    }
}