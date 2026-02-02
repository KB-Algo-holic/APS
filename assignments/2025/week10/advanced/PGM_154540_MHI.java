import java.util.*;
class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static char[][] map;
    public int[] solution(String[] maps) {

        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for (int i=0; i<maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int r=0; r<map.length; r++) {
            for (int c=0; c<map[0].length; c++) {
                if (!visited[r][c] && map[r][c] != 'X') list.add(findFood(r, c));
            }
        }
        if (list.isEmpty()) list.add(-1);
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) answer[i] = list.get(i);
        return answer;
    }

    public int findFood(int row, int col) {
        visited[row][col] = true;
        int total = map[row][col] -'0';

        for (int i=0; i<4; i++) {
            int nR = row + dr[i];
            int nC = col + dc[i];
            if (0 <= nR && nR < map.length && 0 <= nC && nC < map[0].length) {
                if (map[nR][nC] != 'X' && !visited[nR][nC]) {
                    total += findFood(nR, nC);
                }
            }
        }
        return total;
    }
}