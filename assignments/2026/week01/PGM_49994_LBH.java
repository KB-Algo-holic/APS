// PGM 49994 - 방문 길이
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        boolean[][] visited = new boolean[121][121];

        int pointX = 5;
        int pointY = 5;

        for(int i = 0; i < dirs.length(); i++) {

            int point = pointX * 11 + pointY;

            if(dirs.charAt(i) == 'U') {
                if(pointX > 0) {
                    pointX -= 1;
                }
            } else if(dirs.charAt(i) == 'D') {
                if(pointX < 10) {
                    pointX += 1;
                }
            } else if(dirs.charAt(i) == 'L') {
                if(pointY > 0) {
                    pointY -= 1;
                }
            } else {
                if(pointY < 10) {
                    pointY += 1;
                }
            }

            if(point != pointX * 11 + pointY) {
                visited[point][pointX * 11 + pointY] = true;
                visited[pointX * 11 + pointY][point] = true;
            }
        }

        for(int i = 0; i < 121; i++) {
            for(int j = 0; j < 121; j++) {
                if(visited[i][j]) {
                    answer++;
                }
            }
        }

        return (int)(answer / 2);
    }
}