/*
* Programmers 완전탐색 - 카펫
* https://school.programmers.co.kr/learn/courses/30/lessons/42842
*/
import java.util.ArrayList;

class Solution {
    public static int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        // 1. 격자수 = brown + yellow
        int total = brown + yellow;

        for (int i = 3; i <= total / 2; i++) {

            int width = i;
            int height = total / i;

            if (total % i == 0 && width >= height) {

                // 3. (가로 - 2) * (세로 - 2) = yellow
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }

        return answer;
    }
}
