import java.util.*;

/*
 * PGM 1844 - 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
*/
class Solution {
    public static int solution(int[][] maps) {
    int answer = -1;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {0, 0, 1});
    boolean[][] visited = new boolean[maps.length][maps[0].length];

        visited[0][0] = true;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    while (!queue.isEmpty()) {
        int[] qArr = queue.poll();
        int x = qArr[0];
        int y = qArr[1];
        int cnt = qArr[2];

        if (x == maps.length-1 && y == maps[0].length-1) {
            return cnt;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
            if (maps[nx][ny] == 0) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            queue.offer(new int[] {nx, ny, cnt + 1});
        }
    }

    return answer;
}

}
