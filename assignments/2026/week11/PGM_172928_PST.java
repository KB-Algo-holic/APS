// PGM 172928 - 공원 산책
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/172928

public class PGM_172928_PST {
    class Solution {
        public int[] solution(String[] park, String[] routes) {

            int width = park[0].length();
            int height = park.length;

            int x = 0;
            int y = 0;

            for (int i = 0; i < height; i++) {
                if (park[i].contains("S")) {
                    y = i;
                    x = park[i].indexOf("S");
                    break;
                }
            }

            for (String route : routes) {
                char direction = route.charAt(0);
                int distance = route.charAt(2) - '0';

                int tempX = x;
                int tempY = y;
                boolean isRun = true;

                for (int i = 0; i < distance; i++) {

                    if (direction == 'N') tempY--;
                    else if (direction == 'S') tempY++;
                    else if (direction == 'W') tempX--;
                    else if (direction == 'E') tempX++;

                    if (tempX < 0 || tempX >= width || tempY < 0 || tempY >= height
                            || park[tempY].charAt(tempX) == 'X') {
                        isRun = false;
                        break;
                    }
                }

                if (isRun) {
                    x = tempX;
                    y = tempY;
                }
            }

            return new int[]{y, x};
        }
    }
}
