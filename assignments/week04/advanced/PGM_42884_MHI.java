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