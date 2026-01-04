import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int M, N;
    static int[][] map;

    // BFS를 위한 큐
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M: 가로, N: 세로
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 입력, 토마토 큐에 삽입
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 안 익은 토마토
                    if (map[nx][ny] == 0) {
                        // 날짜 갱신
                        map[nx][ny] = map[x][y] + 1;
                        // 다음 탐색 대상 큐에 추가
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int max = 0;

        // 결과 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // 안 익은 토마토가 남아있으면 리턴
                if (map[i][j] == 0) return -1;

                // 최대 날짜 갱신
                max = Math.max(max, map[i][j]);
            }
        }
        return max - 1;
    }
}
