package week27;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PGM_250136_HSH {
    /**
     * 
     * @param args 1) 시추관 위치별로 뚫기는 시작하되, 획득한 덩어리가 많은 곳으로 뚫어야함 그리고 거기서 얻은 총 석유량을 반환할
     *             것 2) 우선 파고 석유가 나오면 이동을 계속 하면서 석유를 쭉쭉 빨아먹어야함 3)
     */
    private static int[] dirX = { -1, 0, 1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };
    private static boolean[][] visited;
    static // 열 별로 팠을때 거기서 나오는 석유량 넣는 해시맵
    HashMap<Integer, Integer> landOperator;
    static int[][] land = { { 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 1, 0 },
            { 1, 1, 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0, 1, 1 } };
    static int n;
    static int m;
    static int[][] oilMap;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int result = solution(land);
        System.out.println(result);
    }

    public static int solution(int[][] land) {
        n = land.length; // 행
        m = land[0].length; // 열
        oilMap = new int[n][m]; // 시추관이 차지한
        visited = new boolean[n][m];
        landOperator = new HashMap<>();
        int landId = 1; // 1열부터 탐색 시작
        // 석유가 있고 방문하지 않은곳부터 탐색 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    int size = move(i, j, landId);
                    landOperator.put(landId, size); // 시추한 열에 대해서 석유량을 넣어주기
                    landId += 1; // 다음 열 진행
                }
            }
        }
        // 열에서 내려가면 또 석유 볼텐데 그 만큼 더해줘야함
        int[] colOil = new int[m];
        // 열 내리면서 행 체크 -> 각 열마다의 석유량을 더해줘야함
        for (int j = 0; j < m; j++) {
            Set<Integer> oilSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1) {
                    oilSet.add(oilMap[i][j]);
                }
            }
            for (int id : oilSet) {
                colOil[j] += landOperator.get(id);
            }
        }

        int count = Arrays.stream(colOil).max().getAsInt();
        return count;
    }

    private static int move(int i, int j, int landId) {
        // TODO Auto-generated method stub
        visited[i][j] = true; // 방문 했다고 체크하기
        Queue<int[]> queue = new LinkedList<>(); // Queue를 설정해서 각 좌표 넣어서 이동
        queue.offer(new int[] { i, j }); // 이동 행 열 넣어주기
        oilMap[i][j] = landId; // 시추관 번호를 땅에 입력해줌(해당 땅은 시추관 것)
        int size = 1; // 우선은 한 칸 획득
        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int nx = 0; // 이동할 x좌표
            int ny = 0; // 이동할 y좌표

            for (int k = 0; k < 4; k++) {
                nx = currentNode[0] + dirX[k];
                ny = currentNode[1] + dirY[k];

                if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && (!visited[nx][ny]) && (land[nx][ny] == 1)) {
                    queue.offer(new int[] { nx, ny });
                    visited[nx][ny] = true;
                    oilMap[nx][ny] = landId; // 이동해서도 해당 시추관 번호를 입력할
                    size += 1;
                }
            }
        }

        return size;
    }
}
