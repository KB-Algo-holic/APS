import java.util.*;
class Solution {
    public int solution(int[][] maze) {

        Queue<int[]> que = new LinkedList<>();
        int R = maze.length;
        int C = maze[0].length;
        int rR = 0; int rC = 0; int bR = 0; int bC = 0;
        int rBit = 0; int bBit = 0;
        int[] dR = {0, 1, 0, -1};
        int[] dC = {1, 0, -1, 0};

        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (maze[r][c] == 1) {
                    rR = r; rC = c;
                    maze[r][c] = 0;
                    rBit |= (1 << ((r * R) + c));
                } else if (maze[r][c] == 2) {
                    bR = r; bC = c;
                    maze[r][c] = 0;
                    bBit |= (1 << ((r * R) + c));
                }
            }
        }

        int answer = 0;
        que.add(new int[] {rR, rC, bR, bC, rBit, bBit, 0});
        while (!que.isEmpty()) {
            int[] info = que.poll();
            rR = info[0]; rC = info[1]; bR = info[2]; bC = info[3]; rBit = info[4]; bBit = info[5];
            int cnt = info[6];

            if (maze[rR][rC] == 3 && maze[bR][bC] == 4) {
                answer = cnt;
                break;
            }
            if (maze[rR][rC] == 3) {
                for (int b=0; b<4; b++) {
                    int nbR = bR + dR[b];
                    int nbC = bC + dC[b];

                    if (0 <= nbR && nbR < R && 0 <= nbC && nbC < C
                            && maze[nbR][nbC] != 5
                            && (bBit & (1 << (nbR * R + nbC))) == 0
                            && (nbR != rR || nbC != rC)) {
                        int nBit = bBit;
                        nBit |= (1 << (nbR * R + nbC));
                        que.add(new int[] {rR, rC, nbR, nbC, rBit, nBit, cnt + 1});
                    }
                }
            } else if (maze[bR][bC] == 4) {
                for (int r=0; r<4; r++) {
                    int nrR = rR + dR[r];
                    int nrC = rC + dC[r];

                    if (0 <= nrR && nrR < R && 0 <= nrC && nrC < C
                            && maze[nrR][nrC] != 5
                            && (rBit & (1 << (nrR * R + nrC))) == 0
                            && (nrR != bR || nrC != bC)) {
                        int nBit = rBit;
                        nBit |= (1 << (nrR * R + nrC));
                        que.add(new int[] {nrR, nrC, bR, bC, nBit, bBit, cnt + 1});
                    }
                }
            } else {
                for (int r=0; r<4; r++) {
                    for (int b=0; b<4; b++) {

                        int nrR = rR + dR[r];
                        int nrC = rC + dC[r];
                        int nbR = bR + dR[b];
                        int nbC = bC + dC[b];

                        if (0 <= nrR && nrR < R && 0 <= nrC && nrC < C && 0 <= nbR && nbR < R && 0 <= nbC && nbC < C
                                && maze[nrR][nrC] != 5 && maze[nbR][nbC] != 5
                                && (rBit & (1 << (nrR * R + nrC))) == 0
                                && (bBit & (1 << (nbR * R + nbC))) == 0
                                && (nbR != nrR || nbC != nrC)
                                && !(nrR == bR && nrC == bC && nbR == rR && nbC == rC)) {
                            int nrBit = rBit;
                            int nbBit = bBit;
                            nrBit |= (1 << (nrR * R + nrC));
                            nbBit |= (1 << (nbR * R + nbC));
                            que.add(new int[] {nrR, nrC, nbR, nbC, nrBit, nbBit, cnt + 1});
                        }
                    }
                }
            }
        }

        return answer;
    }
}