class Solution {
    public int solution(int[][] points, int[][] routes) {

        int[][][] map = new int[20000][100][100];
        int answer = 0;

        for (int[] route : routes) {
            int start = route[0];
            int sR = points[start - 1][0] - 1;
            int sC = points[start - 1][1] - 1;
            int time = 0;

            map[time][sR][sC] ++;
            if (map[time][sR][sC] == 2) answer ++;

            for (int end: route) {
                int eR = points[end - 1][0] - 1;
                int eC = points[end - 1][1] - 1;

                while (sR != eR) {
                    time ++;
                    sR += (sR < eR) ? 1 : -1;
                    map[time][sR][sC] ++;
                    if (map[time][sR][sC] == 2) answer ++;
                }
                while (sC != eC) {
                    time ++;
                    sC += (sC < eC) ? 1 : -1;
                    map[time][sR][sC] ++;
                    if (map[time][sR][sC] == 2) answer ++;
                }
            }
        }

        return answer;
    }
}