/*
* https://school.programmers.co.kr/learn/courses/30/lessons/86491
*/
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int answer = 0;

        int width = 0;  // 가로

        int height = 0; // 세로

        for (int i = 0; i < sizes.length; i++) {

            Arrays.sort(sizes[i]);

            width = Math.max(width, sizes[i][0]);
            height = Math.max(height, sizes[i][1]);

        }

        answer = width * height;

        return answer;
        
    }
}
