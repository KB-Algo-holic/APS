// PGM - 86491 최소직사각형
// 완전탐색?
// https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=java


class Solution {
    public int solution(int[][] sizes) {
        int[] maxSize = new int[2]; // 0 : max, 1 : min

        for (int[] size: sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            if (max > maxSize[0]) maxSize[0] = max;
            if (min > maxSize[1]) maxSize[1] = min;

        }


        return maxSize[0] * maxSize[1];
    }
}