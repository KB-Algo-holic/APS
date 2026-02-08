// PGM - 49994
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        // U : -1, D : +1, R : +1, L : -1
        Map<String, int[]> dirMap = new HashMap<>();

        dirMap.put("U", new int[] {0, -1});
        dirMap.put("D", new int[] {0, 1});
        dirMap.put("R", new int[] {1, 0});
        dirMap.put("L", new int[] {-1, 0});


        int[][] board = new int[11][11]; // 0 ~ 10
        //for (int[] row: board) System.out.println(Arrays.toString(row));
        // 시작
        int sr = 5;
        int sc = 5;

        // 방문
        Set<String> visited = new HashSet<>();


        for (String dir: dirs.split("")) {
            int[] dirArr = dirMap.get(dir);
            int nr = sr+dirArr[0];
            int nc = sc+dirArr[1];

            if (nr < 0 || nr > 10 || nc < 0 || nc > 10) continue;
            String key = edgeKey(sr, sc, nr, nc);
            boolean isFirst = visited.add(key);
            if (isFirst) answer ++;
            sr = nr;
            sc = nc;

        }
        return answer;
    }


    static String edgeKey(int x1, int y1, int x2, int y2) {

        if (x1 > x2 || (x1 == x2 && y1 > y2)) {
            int tx = x1; x1 = x2; x2 = tx;
            int ty = y1; y1 = y2; y2 = ty;
        }
        return x1 + "," + y1 + "|" + x2 + "," + y2;
    }

}