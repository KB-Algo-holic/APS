package week15;

public class PGK_43162_HSH {
    private static boolean visited[];

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n = 3;
        int computers[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        int result = solution(n, computers);
        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n]; // n개의 노드에 대해서 얘가 다른거와 연결이 되어서 방문을 했는지를 확인하면됨
        // 노드의 갯수만큼만 dfs를 돌리되, 연결이 안된 노드일 경우는 네트워크를 늘리면 됨
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                answer += 1;
                dfs(i, n, computers, visited);
            }
        }
        return answer;
    }

    private static void dfs(int currentNode, int n, int[][] computers, boolean[] visited) {
        visited[currentNode] = true; // 현재 노드는 방문했다고 체크
        for (int i = 0; i < n; i++) {
            // 노드만큼 돌리기는 하는데,, 여기서 연결되었고 방문하지 않은 경우로 체크할 것
            if ((computers[currentNode][i] == 1) && (!visited[i])) {
                dfs(i, n, computers, visited);
            }
        }
    }

}