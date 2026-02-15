// BOJ 1405 - 미친로봇
// DFS
// https://www.acmicpc.net/problem/1405

import java.util.*;
import java.io.*;

public class Main {

    static int T; // 이동 횟수
    static double E, W, S, N;
    static double answer = 0.0;
    static boolean[][] visited = new boolean[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        E = Double.parseDouble(st.nextToken()) / 100.0;
        W = Double.parseDouble(st.nextToken()) / 100.0;
        S = Double.parseDouble(st.nextToken()) / 100.0;
        N = Double.parseDouble(st.nextToken()) / 100.0;

        // 중앙에서 시작
        int x = 15;
        int y = 15;

        visited[x][y] = true; // 시작점 방문 처리
        move(0, x, y, 1.0);   // DFS 시작

        System.out.println(answer);
    }

    public static void move(int cnt, int x, int y, double d) {

        if (cnt == T) {
            answer += d;
            return;
        }

        // 동
        if (!visited[x + 1][y]) {
            visited[x + 1][y] = true;
            move(cnt + 1, x + 1, y, d * E);
            visited[x + 1][y] = false;
        }

        // 서
        if (!visited[x - 1][y]) {
            visited[x - 1][y] = true;
            move(cnt + 1, x - 1, y, d * W);
            visited[x - 1][y] = false;
        }

        // 남
        if (!visited[x][y - 1]) {
            visited[x][y - 1] = true;
            move(cnt + 1, x, y - 1, d * S);
            visited[x][y - 1] = false;
        }

        // 북
        if (!visited[x][y + 1]) {
            visited[x][y + 1] = true;
            move(cnt + 1, x, y + 1, d * N);
            visited[x][y + 1] = false;
        }
    }
}
