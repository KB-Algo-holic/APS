// PGM 수레 움직이기
// BFS - 두 포인트에 대한..
// https://school.programmers.co.kr/learn/courses/30/lessons/250134

import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(int[][] maze) {
        int n = maze.length, m = maze[0].length;

        int rx=0, ry=0, bx=0, by=0, reX=0, reY=0, beX=0, beY=0;
        for (int r=0; r<n; r++) for (int c=0; c<m; c++) {
            if (maze[r][c]==1){ rx=r; ry=c; }
            else if (maze[r][c]==2){ bx=r; by=c; }
            else if (maze[r][c]==3){ reX=r; reY=c; }
            else if (maze[r][c]==4){ beX=r; beY=c; }
        }

        boolean[][] redInit = new boolean[n][m];
        boolean[][] blueInit = new boolean[n][m];
        redInit[rx][ry] = true;
        blueInit[bx][by] = true;

        // 큐 { rx(Integer), ry, bx, by, turn, redVisited(boolean[][]), blueVisited(boolean[][]) }
        ArrayDeque<Object[]> q = new ArrayDeque<>();
        q.add(new Object[]{rx, ry, bx, by, 0, redInit, blueInit});

        while (!q.isEmpty()) {
            Object[] cur = q.poll(); // Object > casting required
            int crx = (Integer) cur[0];
            int cry = (Integer) cur[1];
            int cbx = (Integer) cur[2];
            int cby = (Integer) cur[3];
            int turn = (Integer) cur[4];
            boolean[][] rVis = (boolean[][]) cur[5];
            boolean[][] bVis = (boolean[][]) cur[6];

            if (crx==reX && cry==reY && cbx==beX && cby==beY) {
                return turn;
            }

            // 빨강 4방향, 파랑 4방향 (도착하면 고정) > 16가지 경우의 수 4방향 * 4방향
            for (int rd=0; rd<4; rd++) {
                int nrx = crx, nry = cry;
                boolean[][] rNext = rVis; // 필요할 때만 복사

                if (!(crx==reX && cry==reY)) {
                    nrx = crx + dr[rd];
                    nry = cry + dc[rd];
                    // 격자/벽 체크
                    if (nrx<0 || nry<0 || nrx>=n || nry>=m) continue;
                    if (maze[nrx][nry]==5) continue;
                    // 자기 과거 방문 금지
                    if (rVis[nrx][nry]) continue;

                    // redVisited 복사 > 경우의 수 초기화
                    rNext = new boolean[n][m];
                    for (int i=0;i<n;i++) rNext[i] = rVis[i].clone();
                    rNext[nrx][nry] = true;
                }

                for (int bd=0; bd<4; bd++) {
                    int nbx = cbx, nby = cby;
                    boolean[][] bNext = bVis; // 필요할 때만 복사

                    if (!(cbx==beX && cby==beY)) {
                        nbx = cbx + dr[bd];
                        nby = cby + dc[bd];
                        // 격자/벽 체크
                        if (nbx<0 || nby<0 || nbx>=n || nby>=m) continue;
                        if (maze[nbx][nby]==5) continue;
                        // 자기 과거 방문 금지
                        if (bVis[nbx][nby]) continue;

                        // blueVisited 복사 > 경우의 수 초기화
                        bNext = new boolean[n][m];
                        for (int i=0;i<n;i++) bNext[i] = bVis[i].clone();
                        bNext[nbx][nby] = true;
                    }

                    // 충돌 금지
                    if (nrx==nbx && nry==nby) continue; // 같은 칸 동시 진입
                    if (nrx==cbx && nry==cby && nbx==crx && nby==cry) continue; // 자리바꿈

                    q.add(new Object[]{nrx, nry, nbx, nby, turn+1, rNext, bNext});
                }
            }
        }
        return 0; // 도달 불가
    }
}
