import java.io.*;
import java.util.*;

public class BOJ_14503_LGJ {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    static int[][] nextIntMatrix(int n, int m) throws Exception {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }

    static class Solution {

        public int solution(int n, int m, int r, int c, int d, int[][] map) {

            // 여기서부터 알고리즘 작성
            System.out.println("n = " + n + ", m = " + m);
            System.out.println("r = " + r + ", c = " + c + ", d = " + d);

            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("/study/gyujeon/BOJ/input.txt"));

        int n = nextInt();
        int m = nextInt();

        int r = nextInt();
        int c = nextInt();
        int d = nextInt();

        int[][] map = nextIntMatrix(n, m);

        Solution sol = new Solution();
        int answer = sol.solution(n, m, r, c, d, map);

        System.out.println(answer);
    }
}