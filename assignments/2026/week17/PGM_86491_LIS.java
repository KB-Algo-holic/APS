// PGM 86491 - 최소직사각형
// 학습  
// https://school.programmers.co.kr/learn/courses/30/lessons/86491
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int[] max_arr = new int[sizes.length];
        int[] min_arr = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            max_arr[i] = max;
            min_arr[i] = min;
        }

        Arrays.sort(max_arr);
        Arrays.sort(min_arr);

        int a = max_arr[max_arr.length-1];
        int b = min_arr[min_arr.length-1];

        answer = a * b;

        return answer;
    }
}
