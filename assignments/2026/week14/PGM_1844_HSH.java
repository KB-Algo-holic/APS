package week14;
import java.util.LinkedList;
import java.util.Queue;

public class PGM_1844_HSH {
    private static int[] dirX = { -1, 0, 1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };

        int sol = solution(maps);
        System.out.println(sol);
    }

    public static int solution(int[][] maps) {
        int w = maps.length;
        int h = maps[0].length;

        // 최단거리 = BFS
        Queue<int[]> queue = new LinkedList<>();
        /*
         * (0, 0) ~> (n-1, n-1)까지의 최단거리
         */

        queue.offer(new int[] { 0, 0 }); // (0, 0)에서 시작

        // 큐가 비어있지 않다면 계속 진행
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치
            int x = current[0]; // 행
            int y = current[1]; // 열
            // 동서남북 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i]; // 이동하는 x위치
                int ny = y + dirY[i]; // 이동하는 y위치
                // 범위 안에서 움직여야함
                if ((nx >= 0 && ny >= 0) && (nx < w && ny < h)) {
                    // 1일때만 이동할 수 있음
                    if (maps[nx][ny] == 1) {
                        maps[nx][ny] = maps[x][y] + 1; // 현재 위치까지의 거리가 아니라 각 칸마다 거리를 지정해서 체크해야함(전체 탐색이 아님)
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }
        // 1인 곳은 이동이 가능한 길이고 이동을 했다면 +1을 했기 때문에 2가 될 것임
        // 근데, 최종 목적지가 1이다란 것은 아직 이동을 하지 않거나 할 수 없었던 상황이므로 -1이고
        // 그게 아니라면 마지막 위치의 값을 반환했을때 여러 방면으로 도착지에 도달하기에 해당 위치에 값을 반환하면 됨
        return maps[w - 1][h - 1] == 1 ? -1 : maps[w - 1][h - 1];
    }
}
