// PGM 86491 - 최소직사각형
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java

public class PGM_86491_PST {
    class Solution {
        public int solution(int[][] sizes) {
            int maxWidth = 0;
            int maxHeight = 0;

            for (int[] size : sizes) {

                int width = Math.max(size[0], size[1]);
                int height = Math.min(size[0], size[1]);

                maxWidth = Math.max(maxWidth, width);
                maxHeight = Math.max(maxHeight, height);
            }

            return maxWidth * maxHeight;
        }
    }
}
