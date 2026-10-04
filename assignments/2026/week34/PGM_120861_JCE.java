// https://school.programmers.co.kr/learn/courses/30/lessons/120861?language=java
class Solution {
    public static int[] solution(String[] keyinput, int[] board) {
    int[] answer = new int[2];
    int N = board[0] / 2;   // 가로
    int M = board[1] / 2;   // 세로
    int x = 0; int y = 0;   // 출발점
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    int d = 0;
    for (String input : keyinput) {
        switch(input) {
        case "up":
            d = 0;
            break;
        case "down":
            d = 1;
            break;
        case "left":
            d = 2;
            break;
        case "right":
            d = 3;
            break;
        default:
            break;
        }
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < (-1*N) || nx > N || ny < (-1*M) || ny > M) continue;
        x = nx;
        y = ny;
    }
    answer[0] = x;
    answer[1] = y;

    return answer;
}
}
