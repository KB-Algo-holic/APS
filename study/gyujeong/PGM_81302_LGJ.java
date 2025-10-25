import java.util.*;

//P 기준 범위 안에 다른 P까지 도달할 수 있냐 > 도달 가능 : 거리두기 x / 도달 불가 : 거리두기 o
//- 범위 : 맨하튼 거리 2이하
//- 방해물 : 파티션

public class PGM_81302_LGJ {

    class Solution {

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        public int[] solution(String[][] places) {
            int n = places.length;
            int[] answer = new int[n];
            int room_cnt = places.length;
            int r_cnt = 5;
            int c_cnt = 5;

            for (int i=0; i<room_cnt; i++) { // room
                boolean isFine = true;
                String[] room = places[i];
                //System.out.println("room number : " + i);
                for (int r=0; r<r_cnt; r++) {
                    String row = room[r];
                    for (int c=0; c<c_cnt; c++) {
                        if (row.charAt(c) == 'P') {
                            //System.out.println("r: " + r);
                            //System.out.println("c: " + c);
                            isFine = bfs(room, r, c, r_cnt, c_cnt);
                            if (!isFine) break;
                        }
                    }
                    if (!isFine) break;
                }

                if (isFine) answer[i] = 1;
                else answer[i] = 0;
            }
            return answer;
        }

        boolean bfs(String[] room, int r, int c, int r_cnt, int c_cnt) {
            //System.out.println("call BFS");
            boolean[][] visited = new boolean[r_cnt][c_cnt];
            int[] start = new int[3];
            start[0] = r;
            start[1] = c;
            start[2] = 0;
            Queue<int[]> q = new ArrayDeque<int[]>();
            visited[r][c] = true;
            q.offer(start);


            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cr = cur[0];
                int cc = cur[1];
                int cnt = cur[2];
                //System.out.println("cr : " + cr);
                //System.out.println("cc : " + cc);

                if (cnt >= 2) {
                    //System.out.println("over 2 && quit");
                    continue; // 두칸까지만 검사
                }

                for (int k=0; k<4; k++) {
                    int nr = cr + dr[k];
                    int nc = cc + dc[k];
                    //System.out.println("nr : " + nr);
                    //System.out.println("nc : " + nc);

                    if (nr < 0 || nr >= r_cnt || nc < 0 || nc >= c_cnt) {
                        //System.out.println("out of range");
                        continue;
                    }
                    if (visited[nr][nc]) {
                        //System.out.println("already visited");
                        continue;
                    }
                    if (room[nr].charAt(nc) == 'X') {
                        //System.out.println("is Partition");
                        continue; // 파티션 통해서 가는 것은 거리두기 성공한 것임
                    }
                    if (room[nr].charAt(nc) == 'P') {
                        //System.out.println("end BFS with false");
                        return false; // 거리 3이하에 파티션을 거치지 않고 P에 도달했다면 거리두기 못한 것임
                    }
                    else {
                        //System.out.println("offer queue");
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc, cnt+1});
                    }
                }
            }
            //System.out.println("end BFS with true");
            return true;
        }

    }
}
