public class LC_54_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[m][n];
        int r = 0; int c = 0; int dir = 0;

        while (true) {
            if (cnt == m * n) break;
            // 현재 원소 출력
            answer.add(matrix[r][c]);
            visited[r][c] = true;

            int nr = r + dx[dir];
            int nc = c + dy[dir];

            // 현재 범위랑 방향 체크
            if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) {
                dir = (dir + 1) % 4;
                nr = r + dx[dir];
                nc = c + dy[dir];
            }

            r = nr;
            c = nc;
            cnt++;
        }

        return answer;
    }
}
